package com.azrinurvani.latihanjetpackcompose.presentation.option_role_login

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azrinurvani.latihanjetpackcompose.R
import com.azrinurvani.latihanjetpackcompose.presentation.theme.LatihanJetpackComposeTheme

@Composable
fun StartedLoginScreen(
    modifier: Modifier = Modifier,
    navigateToLogin : () -> Unit
){
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
    ){
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
            ){
                Image(
                    painter = painterResource(R.drawable.darlink_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                )
                Spacer(modifier = Modifier.height(116.dp))

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    onClick = {
                        navigateToLogin()
                    },
                    border = BorderStroke(
                        color = colorResource(R.color.primary),
                        width = 1.dp
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "Konsumen",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.primary)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    onClick = {
                        navigateToLogin()
                    },
                    border = BorderStroke(
                        color = colorResource(R.color.primary),
                        width = 1.dp
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "Agen",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.primary)
                    )
                }
            }
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun StartedLoginScreenPreview(){
    LatihanJetpackComposeTheme {
        StartedLoginScreen(
            navigateToLogin = {}
        )
    }
}