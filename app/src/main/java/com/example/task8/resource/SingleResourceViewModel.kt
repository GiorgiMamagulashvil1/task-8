package com.example.task8.resource

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.api.RetrofitInstance
import com.example.task8.model.Resources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SingleResourceViewModel : ViewModel() {

    private val _data = MutableStateFlow<Resources?>(null)
    val data: StateFlow<Resources?> = _data

    fun setData(id: Int) = viewModelScope.launch {
        val response = RetrofitInstance.api.getSingleResource(id)
        if (response.isSuccessful) {
            val body = response.body()
            _data.emit(body?.data)
        } else {
            _data.emit(null)
        }
    }

}