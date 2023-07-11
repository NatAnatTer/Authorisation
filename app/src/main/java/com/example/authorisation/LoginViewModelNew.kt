package com.example.authorisation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModelNew: ViewModel() {
    val token = MutableLiveData<String>()
}