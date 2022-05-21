package com.example.task8.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.R
import com.example.task8.model.Resources
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ResourcesListFragment : Fragment() {

    private lateinit var resourcesRecyclerView: RecyclerView
    private val vm: ResourcesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.resources_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.apiCall()
        view.apply {
            resourcesRecyclerView = findViewById(R.id.resourcesRecyclerView)
        }
        dataObserver()
    }

    private fun dataObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            vm.data.collect { data ->
                data?.let { it -> setUpRecyclerView(it) }
            }
        }
    }

    private fun setUpRecyclerView(data: List<Resources>) {
        with(resourcesRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ResourcesAdapter(data) {

                findNavController().navigate(
                    ResourcesListFragmentDirections.actionResourcesListFragmentToSingleResourceFragment(it)
                )
            }
        }
    }
}