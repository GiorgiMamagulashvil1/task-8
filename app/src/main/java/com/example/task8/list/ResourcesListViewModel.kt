package com.example.task8.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.api.RetrofitInstance
import com.example.task8.model.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResourcesListViewModel : ViewModel() {

    private val _data = MutableStateFlow<List<Resources>?>(null)
    val data: StateFlow<List<Resources>?> = _data

    fun apiCall() = viewModelScope.launch(Dispatchers.IO) {
        val response = RetrofitInstance.api.getResources()
        if (response.isSuccessful) {
            val data = response.body()
            _data.emit(data?.data)
        }
    }
}