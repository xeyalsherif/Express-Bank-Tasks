package com.example.express_bank_task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.express_bank_task.databinding.ItemCategoryBinding
import com.example.express_bank_task.models.StatsCategory
import com.example.express_bank_task.utils.ClickListener
import com.example.express_bank_task.utils.diff_utils.CategoriesDetailDiffUtil

class CategoriesAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var dataList = emptyList<StatsCategory>()

    class CategoriesViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): CategoriesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
                return CategoriesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.binding.category = dataList[position]
        holder.binding.categoryItem.setOnClickListener { clickListener.onClick(it, position) }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newList: List<StatsCategory>) {
        val categoriesDiffUtil =
            CategoriesDetailDiffUtil(dataList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(categoriesDiffUtil)
        dataList = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }
}