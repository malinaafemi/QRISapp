package com.example.qrisapp.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrisapp.domain.repo.QRRepo
import com.example.qrisapp.data.models.QRScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QRViewModel @Inject constructor(
    private val repo: QRRepo
): ViewModel() {

    private val _state = MutableStateFlow(QRScreenState())
    val state = _state.asStateFlow()


    fun startScanning() {
        viewModelScope.launch {
            repo.startScanning().collect{ data ->
                if (!data.isNullOrBlank()){
                    _state.value = state.value.copy(
                        details = data
                    )
                }
            }
        }
    }
}