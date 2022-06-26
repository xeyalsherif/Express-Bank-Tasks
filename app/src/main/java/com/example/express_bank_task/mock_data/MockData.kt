package com.example.express_bank_task.mock_data

import com.example.express_bank_task.R
import com.example.express_bank_task.models.BankCard
import com.example.express_bank_task.models.Report
import com.example.express_bank_task.models.Stats
import com.example.express_bank_task.models.StatsCategory
import com.example.express_bank_task.models.enums.CategoryType

object MockData {

    fun getStatsMockData(): List<Stats> {
        val statsList = ArrayList<Stats>()
        statsList.add(
            Stats(
                "2021",
                "January",
                "Transport 56%",
                "1 900",
                getBankCardsMockData(),
                getCategoriesMockData(),
                getReportsMockData1(),
                "View statement"
            )
        )

        statsList.add(
            Stats(
                "2021",
                "February",
                "Transport 42%",
                "2 500",
                getBankCardsMockData(), getCategoriesMockData(), getReportsMockData2(),
                "View statement"
            )
        )
        statsList.add(
            Stats(
                "2022",
                "January",
                "Transport 20%",
                "4 500",
                getBankCardsMockData(),
                getCategoriesMockData(),
                getReportsMockData3(),
                "View statement"

            )
        )
        statsList.add(
            Stats(
                "2022",
                "February",
                "Transport 21%",
                "1 100",
                getBankCardsMockData(),
                getCategoriesMockData(),
                getReportsMockData4(),
                "View statement"
            )
        )
        return statsList
    }

    private fun getReportsMockData1(): List<Report> {
        val report = ArrayList<Report>()
        report.add(Report("1 450 000", "Expences"))
        report.add(Report("1 140 000", "Incomings"))
        report.add(Report("124 500", "Cashback"))
        return report.toList()
    }

    private fun getReportsMockData2(): List<Report> {
        val report = ArrayList<Report>()
        report.add(Report("3 300 000", "Expences"))
        report.add(Report("90 700 000", "Incomings"))
        report.add(Report("442 500", "Cashback"))
        return report.toList()
    }

    private fun getReportsMockData3(): List<Report> {
        val report = ArrayList<Report>()
        report.add(Report("1 320 000", "Expences"))
        report.add(Report("1 400 000", "Incomings"))
        report.add(Report("60 500", "Cashback"))
        return report.toList()
    }

    private fun getReportsMockData4(): List<Report> {
        val report = ArrayList<Report>()
        report.add(Report("2 220 000", "Expences"))
        report.add(Report("4 401 000", "Incomings"))
        report.add(Report("140 500", "Cashback"))
        return report.toList()
    }

    private fun getCategoriesMockData(): List<StatsCategory> {
        val category = ArrayList<StatsCategory>()
        category.add(
            StatsCategory(
                CategoryType.AIRLINES,
                "Airlines",
                "22",
                "1 500 AZN",
                getExpensesMockData()
            )
        )
        category.add(
            StatsCategory(
                CategoryType.RENT_A_CAR,
                "Rent A Car",
                "32",
                "1 700 AZN",
                getExpensesMockData()
            )
        )
        category.add(
            StatsCategory(
                CategoryType.HOTELS,
                "Hotels and Motels",
                "96",
                "1 500 AZN",
                getExpensesMockData()
            )
        )

        category.add(
            StatsCategory(
                CategoryType.CARS_AND_VEHICLES,
                "Cars And Vehicles",
                "46",
                "1 900 AZN",
                getExpensesMockData()
            )
        )
        category.add(
            StatsCategory(
                CategoryType.TRANSPORT,
                "Transport",
                "41",
                "1 500 AZN",
                getExpensesMockData()
            )
        )
        category.add(
            StatsCategory(
                CategoryType.GOVERNMENT_SERVICES,
                "Government Services",
                "50",
                "1 000 AZN",
                getExpensesMockData()
            )
        )
        category.add(
            StatsCategory(
                CategoryType.HOTELS,
                "Hotels and Motels",
                "96",
                "1 500 AZN",
                getExpensesMockData()
            )
        )
        return category.toList()
    }

    private fun getExpensesMockData(): List<StatsCategory.Expense> {
        val expense = ArrayList<StatsCategory.Expense>()
        expense.add(
            StatsCategory.Expense(
                R.drawable.image_uber,
                "Uber trip 20 UAW",
                "100 ₼",
                "13:02 17.09.2018",
            )
        )
        expense.add(
            StatsCategory.Expense(
                R.drawable.image_uber,
                "Uber trip 20 UAW",
                "230 ₼",
                "03:01 03.01.2018",
            )
        )
        expense.add(
            StatsCategory.Expense(
                R.drawable.image_uber,
                "Uber trip 20 UAW",
                "140 ₼",
                "13:12 09.09.2018",
            )
        )
        expense.add(
            StatsCategory.Expense(
                R.drawable.image_uber,
                "Uber trip 20 UAW",
                "600 ₼",
                "16:02 17.09.2020",
            )
        )
        expense.add(
            StatsCategory.Expense(
                R.drawable.image_uber,
                "Uber trip 20 UAW",
                "500 ₼",
                "11:02 27.05.2022",
            )
        )
        return expense.toList()
    }

    private fun getBankCardsMockData(): List<BankCard> {
        val cardList = ArrayList<BankCard>()
        cardList.add(BankCard("Expresso MC", R.drawable.image_bank_card, "** 4554"))
        cardList.add(BankCard("Expresso MC", R.drawable.image_bank_card, "** 4554"))
        cardList.add(BankCard("Expresso MC", R.drawable.image_bank_card, "** 4554"))
        return cardList.toList()
    }
}