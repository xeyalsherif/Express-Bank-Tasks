package com.example.express_bank_task.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.express_bank_task.base.BaseViewModel
import com.example.express_bank_task.mock_data.MockData
import com.example.express_bank_task.models.Stats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    private val _stats =
        MutableLiveData<List<Stats>>()
    val stats: LiveData<List<Stats>> get() = _stats

    init {
        getReportData()
    }

    private fun getReportData() = viewModelScope.launch {
        _stats.value = MockData.getStatsMockData()
    }

}
