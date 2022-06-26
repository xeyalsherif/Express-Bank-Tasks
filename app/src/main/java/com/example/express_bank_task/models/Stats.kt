package com.example.express_bank_task.models

import androidx.annotation.DrawableRes
import com.example.express_bank_task.models.enums.CategoryType

data class Stats(
    val year: String,
    val month: String,
    val transportPerice: String,
    val transportPrice: String,
    val bankCards: List<BankCard>,
    val categories: List<StatsCategory>,
    val report: List<Report>,
    val viewText: String
)

data class BankCard(
    val name: String,
    @DrawableRes
    val photo: Int,
    val lastNumbers: String
)

data class StatsCategory(
    val type: CategoryType,
    val name: String,
    val percentage: String,
    val price: String,
    val expenses: List<Expense>
) {
    data class Expense(
        @DrawableRes
        val photo: Int,
        val name: String,
        val price: String,
        val time: String
    )

    fun getPercentageInt(): Int {
        return percentage.toInt()
    }

    fun getPercentageWithFormat(): String {
        return "$percentage%"
    }

    fun getPercentageWithFormat2(): String {
        return "$percentage% of all"
    }
}

data class Report(
    val price: String,
    val detailText: String
)