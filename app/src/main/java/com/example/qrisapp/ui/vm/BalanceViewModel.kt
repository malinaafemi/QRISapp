package com.example.qrisapp.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrisapp.data.models.UserBalance

class BalanceViewModel : ViewModel() {

    private val _userBalance = MutableLiveData<UserBalance>()
    val userBalance: LiveData<UserBalance> = _userBalance

    init {
        _userBalance.value = UserBalance("150000")
    }
}