package com.azrinurvani.latihanjetpackcompose.presentation.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.azrinurvani.latihanjetpackcompose.R

@Composable
fun CustomOutlineTextField(
    modifier: Modifier = Modifier,
    value : String,
    onValueTextChange : (String) -> Unit,
    placeHolder : String,
    label : String,
    keyboardOptions: KeyboardOptions
) {
    val interactionSource = remember{
        MutableInteractionSource()
    }
    OutlinedTextField(
        modifier = modifier
            .fillMaxSize(),
        value = value,
        onValueChange = { valueChange->
            onValueTextChange(valueChange)
        },
        textStyle = TextStyle(
            color = colorResource(R.color.input_text),
            fontSize = 12.sp
        ),
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall.copy(),
                fontSize = 12.sp,
                color = colorResource(R.color.hint_text)
            )
        },
        placeholder = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.labelSmall.copy(),

                fontSize = 12.sp,
                color = colorResource(R.color.hint_text)
            )
        },

        readOnly = false,
        shape = MaterialTheme.shapes.medium,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions {
            //onKeyboardDone or Enter
            onValueTextChange(value)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(R.color.gray_25),
            unfocusedContainerColor = colorResource(R.color.gray_25),
            focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            unfocusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            focusedIndicatorColor = if (isSystemInDarkTheme()) colorResource(R.color.primary) else colorResource(R.color.gray_25),
            disabledIndicatorColor = if (isSystemInDarkTheme()) colorResource(R.color.primary) else colorResource(R.color.gray_25),
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = if (isSystemInDarkTheme()) colorResource(R.color.primary) else colorResource(R.color.gray_25)
        ),

        interactionSource = interactionSource
    )
}