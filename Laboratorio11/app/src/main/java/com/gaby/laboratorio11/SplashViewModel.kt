package com.gaby.laboratorio11

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _isloading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isloading

    init {
        viewModelScope.launch {
            delay(3000)         // carga de 3 segundos

            _isloading.value = false
        }
}

}