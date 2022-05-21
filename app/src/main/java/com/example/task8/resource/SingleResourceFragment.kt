package com.example.task8.resource

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.task8.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SingleResourceFragment : Fragment() {

    private val vm: SingleResourceViewModel by viewModels()
    private val args: SingleResourceFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.single_resource_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.setData(args.id)
        viewLifecycleOwner.lifecycleScope.launch {
            vm.data.collect { data ->
                data?.let {
                    view.findViewById<ConstraintLayout>(R.id.rootLyt).apply {
                        setBackgroundColor(Color.parseColor(it.color))
                    }
                    view.findViewById<TextView>(R.id.textView).apply {
                        text = it.name
                    }
                }
            }
        }
    }
}