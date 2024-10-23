package com.azrinurvani.latihanjetpackcompose.presentation.login

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azrinurvani.latihanjetpackcompose.R
import com.azrinurvani.latihanjetpackcompose.presentation.theme.LatihanJetpackComposeTheme
import com.azrinurvani.latihanjetpackcompose.presentation.util.Constants
import com.azrinurvani.latihanjetpackcompose.presentation.util.inputTextBorder

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginState,
    event: (LoginEvent) -> Unit,
    onClick : (()->Unit)? = null,
    navigateToHome : (String) -> Unit
){
    val interactionSource = remember{
        MutableInteractionSource()
    }

    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if (isClicked){
            onClick?.invoke()
        }
    }
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(R.color.secondary_gradient),
                        colorResource(R.color.primary_gradient)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card (
            modifier = modifier
                .fillMaxWidth(fraction = 0.9f)
                .padding(
                    vertical = 24.dp,
                    horizontal = 16.dp
                ),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.primary_25)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(12.dp),
        ){
            Column(
                modifier = modifier.padding(
                    vertical = 32.dp,
                    horizontal = 24.dp
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.darlink_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Hi! Selamat Datang di Darlink!",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    text = "Masukkan Nomor Whatsapp",
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.gray_600)
                )
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.inputPhoneNumber ?:"",
                    onValueChange = {
                        if (it.length <= Constants.MAX_CHAR_PHONE_NUMBER_INPUT) {
//                            onValueChange(it)
                            event(LoginEvent.UpdateQueryChange(it))
                        }
                    },
                    supportingText = {
                        Text(
                            text = if (state.inputPhoneNumber?.length!! <= 0) "0 / ${Constants.MAX_CHAR_PHONE_NUMBER_INPUT}" else  "${state.inputPhoneNumber.length} / ${Constants.MAX_CHAR_PHONE_NUMBER_INPUT}",
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.End,
                            color = colorResource(R.color.input_text)
                        )
                    },
                    textStyle = TextStyle(
                        color = colorResource(R.color.input_text),
                        fontSize = 12.sp
                    ),
                    label = {
                        Text(
                            text = "No HP",
                            style = MaterialTheme.typography.labelSmall.copy(),
                            fontSize = 12.sp,
                            color = colorResource(R.color.hint_text)
                        )
                    },
                    placeholder = {
                        Text(
                            text = "0812xxxxxxxx",
                            style = MaterialTheme.typography.labelSmall.copy(),

                            fontSize = 12.sp,
                            color = colorResource(R.color.hint_text)
                        )
                    },

                    readOnly = false,
                    shape = MaterialTheme.shapes.medium,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions {
                        //onKeyboardDone or Enter
                        event(LoginEvent.SubmitLogin)
                        if (state.inputPhoneNumber?.isNotEmpty() == true){
                            navigateToHome(state.inputPhoneNumber)
                        }else{
                            Toast.makeText(context,"Please input your phone number",Toast.LENGTH_LONG).show()
                        }

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
                Spacer(modifier = Modifier.height(108.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        event(LoginEvent.SubmitLogin)
                        if (state.inputPhoneNumber?.isNotEmpty() == true){
                            navigateToHome(state.inputPhoneNumber)
                        }else{
                            Toast.makeText(context,"Please input phone number!",Toast.LENGTH_LONG).show()
                        }

                    },
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "Lanjut",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        color = colorResource(R.color.white)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun LoginScreenPreview(){
    LatihanJetpackComposeTheme {
        LoginScreen(
//            text = "",
//            onValueChange = {},
            event = {},
            state = LoginState(),
            navigateToHome = {}
        )
    }
}