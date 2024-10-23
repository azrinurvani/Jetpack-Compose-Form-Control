package com.azrinurvani.latihanjetpackcompose.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.azrinurvani.latihanjetpackcompose.presentation.model.UserBioDataInput
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){

    private val _state = mutableStateOf(HomeState(userBioDataInput = UserBioDataInput()))
    val state : State<HomeState> = _state


    fun onEvent(event : HomeEvent){
        when(event){
            is HomeEvent.UpdateBioDataInput -> {
                _state.value = _state.value.copy(
                    userBioDataInput = event.userBioDataInput
                )
            }
            is HomeEvent.SubmitBioData -> {
                Log.d("HomeViewModel", "Nama Lengkap : ${event.data.fullName}")
                Log.d("HomeViewModel", "NIM/KTP : ${event.data.identityNumber}")
                Log.d("HomeViewModel", "Alamat KTP : ${event.data.addressFromId}")
                Log.d("HomeViewModel", "Alamat Domisili : ${event.data.addressDomicile}")
                Log.d("HomeViewModel", "Referal Code  : ${event.data.referralCode}")
            }
        }
    }
}