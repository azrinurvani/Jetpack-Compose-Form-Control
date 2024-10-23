package com.azrinurvani.latihanjetpackcompose.presentation.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state : State<LoginState> = _state

    fun onEvent(event : LoginEvent){
        when(event){
            is LoginEvent.UpdateQueryChange -> {
                _state.value = state.value.copy(inputPhoneNumber = event.inputQuery)
            }
            LoginEvent.SubmitLogin -> {
                //navigate and pass data to next page
                Log.d("LoginViewModel", "submitLogin : ${state.value.inputPhoneNumber}")
            }
        }
    }

}