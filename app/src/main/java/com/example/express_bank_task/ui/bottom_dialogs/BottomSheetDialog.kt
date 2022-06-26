package com.example.express_bank_task.ui.bottom_dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.express_bank_task.R
import com.example.express_bank_task.adapter.CategoriesDetailAdapter
import com.example.express_bank_task.databinding.DialogBottomSheetBinding
import com.example.express_bank_task.models.StatsCategory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetDialog(
    private val stats: StatsCategory,
    private val month: String,
    private val year: String
) : BottomSheetDialogFragment() {

    private lateinit var binding: DialogBottomSheetBinding
    private val categoriesDetailAdapter: CategoriesDetailAdapter by lazy { CategoriesDetailAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.transparentDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurationCategoryRecyclerView()
        categoriesDetailAdapter.setData(stats.expenses)
        binding.backgroundType.background.setTint(
            ContextCompat.getColor(
                requireContext(),
                stats.type.color
            )
        )
        binding.imageType.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                stats.type.icon
            )
        )
        binding.stats = stats
        binding.date = "Expences for $month $year"
    }

    private fun configurationCategoryRecyclerView() {
        binding.recyclerViewCategoryDetail.adapter = categoriesDetailAdapter
        binding.recyclerViewCategoryDetail.layoutManager =
            LinearLayoutManager(requireContext())
    }
}