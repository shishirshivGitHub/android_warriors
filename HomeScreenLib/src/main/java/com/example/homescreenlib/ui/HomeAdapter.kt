package com.example.homescreenlib.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homescreenlib.data.Dashboard
import com.example.homescreenlib.databinding.DashboardItemsLayoutBinding

class HomeAdapter : ListAdapter<Dashboard, HomeAdapter.ViewHolder>(HomeAdapterDiffCallback()) {

    class ViewHolder private constructor(private val binding: DashboardItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Dashboard){
            binding.dashboardItem = item
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DashboardItemsLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(item) }
        }
        holder.bind(item)
    }
    private var onItemClickListener: ((Dashboard) -> Unit)? = null
    fun setOnItemClickListener(listener: (Dashboard) -> Unit) {
        onItemClickListener = listener
    }
}

class HomeAdapterDiffCallback : DiffUtil.ItemCallback<Dashboard>() {
    override fun areItemsTheSame(oldItem: Dashboard, newItem: Dashboard): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: Dashboard, newItem: Dashboard): Boolean {
        return oldItem == newItem
    }

}
