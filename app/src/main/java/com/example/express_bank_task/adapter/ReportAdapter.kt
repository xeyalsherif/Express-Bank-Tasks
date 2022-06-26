package com.example.express_bank_task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.express_bank_task.databinding.ItemReportBinding
import com.example.express_bank_task.models.Report
import com.example.express_bank_task.utils.diff_utils.ReportDiffUtil

class ReportAdapter : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    private var dataList = emptyList<Report>()

    class ReportViewHolder(val binding: ItemReportBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ReportViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemReportBinding.inflate(layoutInflater, parent, false)
                return ReportViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        return ReportViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.binding.report = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newList: List<Report>) {
        val reportDiffUtil =
            ReportDiffUtil(dataList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(reportDiffUtil)
        dataList = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }

}