package com.example.express_bank_task.utils.diff_utils

import androidx.recyclerview.widget.DiffUtil
import com.example.express_bank_task.models.StatsCategory

class CategoriesDiffUtil(
    private val oldList: List<StatsCategory.Expense>,
    private val newList: List<StatsCategory.Expense>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}