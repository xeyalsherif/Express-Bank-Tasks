package com.example.express_bank_task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.express_bank_task.databinding.ItemCategoryDetailBinding
import com.example.express_bank_task.models.StatsCategory
import com.example.express_bank_task.utils.diff_utils.CategoriesDiffUtil

class CategoriesDetailAdapter :
    RecyclerView.Adapter<CategoriesDetailAdapter.CategoriesDetailViewHolder>() {

    private var dataList = emptyList<StatsCategory.Expense>()

    class CategoriesDetailViewHolder(val binding: ItemCategoryDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): CategoriesDetailViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCategoryDetailBinding.inflate(layoutInflater, parent, false)
                return CategoriesDetailViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesDetailViewHolder {
        return CategoriesDetailViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoriesDetailViewHolder, position: Int) {
        holder.binding.expense = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newList: List<StatsCategory.Expense>) {
        val categoriesDetailDiffUtil =
            CategoriesDiffUtil(dataList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(categoriesDetailDiffUtil)
        dataList = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }
}