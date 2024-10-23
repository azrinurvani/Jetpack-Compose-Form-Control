package com.azrinurvani.latihanjetpackcompose.presentation.login

sealed class LoginEvent {
    data class UpdateQueryChange(val inputQuery : String) : LoginEvent()

    object SubmitLogin : LoginEvent()
}