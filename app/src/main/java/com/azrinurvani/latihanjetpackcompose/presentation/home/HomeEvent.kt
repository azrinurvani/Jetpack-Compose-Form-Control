package com.azrinurvani.latihanjetpackcompose.presentation.home

import com.azrinurvani.latihanjetpackcompose.presentation.model.UserBioDataInput

sealed class HomeEvent{

    data class UpdateBioDataInput(val userBioDataInput: UserBioDataInput) : HomeEvent()

    data class SubmitBioData(val data : UserBioDataInput) : HomeEvent()

}