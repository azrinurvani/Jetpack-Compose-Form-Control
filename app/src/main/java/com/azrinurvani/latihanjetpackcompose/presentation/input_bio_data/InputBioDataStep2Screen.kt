package com.azrinurvani.latihanjetpackcompose.presentation.input_bio_data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.azrinurvani.latihanjetpackcompose.presentation.model.UserBioDataInput

@Composable
fun InputBioDataStep2Screen(
    modifier: Modifier = Modifier,
    userBioDataInput: UserBioDataInput? = null,
    onBackClick : () -> Unit = {},
){

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = modifier,
            text = "Halo " + userBioDataInput?.fullName + "\n" + userBioDataInput?.identityNumber)
    }


}