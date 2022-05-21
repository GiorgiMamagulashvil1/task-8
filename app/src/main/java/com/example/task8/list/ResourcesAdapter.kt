package com.example.task8.list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.R
import com.example.task8.model.Resources

class ResourcesAdapter(
    private val data: List<Resources>,
    private val onItemClick: (id: Int) -> Unit
) :
    RecyclerView.Adapter<ResourcesAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: Resources, onItemClick: (id: Int) -> Unit) {
            itemView.apply {
                findViewById<View>(R.id.colorView).apply {
                    setBackgroundColor(Color.parseColor(item.color))
                }
                findViewById<AppCompatTextView>(R.id.nameTextView).apply {
                    text = item.name
                }
                findViewById<AppCompatTextView>(R.id.yearTextView).apply {
                    text = item.year.toString()
                }
                setOnClickListener {
                    onItemClick.invoke(item.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.resource_list_item, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position], onItemClick = onItemClick)
    }

    override fun getItemCount() = data.size
}