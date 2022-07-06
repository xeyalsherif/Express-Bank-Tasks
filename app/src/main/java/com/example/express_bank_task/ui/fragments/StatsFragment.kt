package com.example.express_bank_task.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.express_bank_task.R
import com.example.express_bank_task.adapter.CategoriesAdapter
import com.example.express_bank_task.adapter.ReportAdapter
import com.example.express_bank_task.base.BaseFragment
import com.example.express_bank_task.databinding.FragmentStatsBinding
import com.example.express_bank_task.models.Stats
import com.example.express_bank_task.ui.bottom_dialogs.BottomSheetDialog
import com.example.express_bank_task.utils.ClickListener
import com.example.express_bank_task.view_model.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StatsFragment : BaseFragment<FragmentStatsBinding, StatsViewModel>(), ClickListener {

    private lateinit var binding: FragmentStatsBinding
    private lateinit var viewModel: StatsViewModel

    private val reportAdapter: ReportAdapter by lazy { ReportAdapter() }
    private val categoriesAdapter: CategoriesAdapter by lazy { CategoriesAdapter(this) }

    private lateinit var statsList: List<Stats>
    private var selectedStatsIndex = 0

    override fun getLayoutId(): Int {
        return R.layout.fragment_stats
    }

    override fun getViewModel(): StatsViewModel {
        viewModel = ViewModelProvider(this)[StatsViewModel::class.java]
        return viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getBinding()

        configurationCategoryRecyclerView()
        configurationReportRecyclerView()

        initMonthsMenu()
        initYearsMenu()
        initBankCardMenu()

        collectTheResponse()
    }

    private fun collectTheResponse() {
        lifecycleScope.launch {
            viewModel.stats.collect {
                selectedStatsIndex = 0
                statsList = it
                updateUi(it)
            }
        }
    }

    private fun updateUi(list: List<Stats>) {
        reportAdapter.setData(list[selectedStatsIndex].report)
        categoriesAdapter.setData(list[selectedStatsIndex].categories)
        binding.stats = list[selectedStatsIndex]
    }

    private fun configurationReportRecyclerView() {
        binding.recyclerViewReport.adapter = reportAdapter
        binding.recyclerViewReport.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
    }

    private fun configurationCategoryRecyclerView() {
        binding.recyclerViewCategories.adapter = categoriesAdapter
        binding.recyclerViewCategories.layoutManager =
            LinearLayoutManager(requireContext())
    }

    private fun initBankCardMenu() {
        //Updating after changing the card name but information don't changing
        binding.cardView.setOnClickListener {
            val popup = PopupMenu(requireContext(), binding.cardView)
            for (element in statsList[selectedStatsIndex].bankCards) {
                popup.menu.add(
                    "${element.name}  (${element.lastNumbers})"
                )
            }
            popup.setOnMenuItemClickListener {
                for (element in statsList[selectedStatsIndex].bankCards) {
                    binding.textCardName.text = element.name
                    binding.textLastNumber.text = element.lastNumbers
                }
                true
            }
            popup.show()
        }
    }

    private fun initYearsMenu() {
        val years = arrayOf("2021", "2022")
        binding.textYear.inputType = InputType.TYPE_NULL
        binding.textYear.setAdapter(
            ArrayAdapter(requireContext(), R.layout.item_drop_down_menu, years)
        )
        binding.textYear.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                checkSelectedDate()
            }
        })
    }

    private fun initMonthsMenu() {
        val months = arrayOf("January", "February")
        binding.textMonth.inputType = InputType.TYPE_NULL
        binding.textMonth.setAdapter(
            ArrayAdapter(requireContext(), R.layout.item_drop_down_menu, months)
        )
        binding.textMonth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                checkSelectedDate()
            }
        })
    }

    private fun checkSelectedDate() {
        if (binding.textMonth.text.toString() == "January" && binding.textYear.text.toString() == "2021") {
            selectedStatsIndex = 0
            updateUi(statsList)
        } else if (binding.textMonth.text.toString() == "February" && binding.textYear.text.toString() == "2021") {
            selectedStatsIndex = 1
            updateUi(statsList)
        } else if (binding.textMonth.text.toString() == "January" && binding.textYear.text.toString() == "2022") {
            selectedStatsIndex = 2
            updateUi(statsList)
        } else if (binding.textMonth.text.toString() == "February" && binding.textYear.text.toString() == "2022") {
            selectedStatsIndex = 3
            updateUi(statsList)
        }
    }

    private fun openDialog(position: Int) {
        val dialog = BottomSheetDialog(
            statsList[selectedStatsIndex].categories[position],
            binding.textMonth.text.toString(),
            binding.textYear.text.toString()
        )
        dialog.show(childFragmentManager, "dialog")
    }

    override fun onClick(view: View, position: Int) {
        openDialog(position)
    }
}
