package com.azrinurvani.latihanjetpackcompose.presentation.util

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.azrinurvani.latihanjetpackcompose.R

fun Modifier.inputTextBorder() = composed{
    if (!isSystemInDarkTheme()) {
        border(
            width = 1.dp,
            color = colorResource(R.color.gray_200),
            shape = MaterialTheme.shapes.medium
        )
    }else{

        this
    }
}
val stroke = Stroke(
    width = 4f,
    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
)