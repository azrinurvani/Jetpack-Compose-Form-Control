package com.azrinurvani.latihanjetpackcompose.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class UserBioDataInput(
    val fullName : String = "",
    val identityNumber : String = "",
    val addressFromId : String = "",
    val addressDomicile : String = "",
    val referralCode : String = "",
    val qrPath : String = ""
)
