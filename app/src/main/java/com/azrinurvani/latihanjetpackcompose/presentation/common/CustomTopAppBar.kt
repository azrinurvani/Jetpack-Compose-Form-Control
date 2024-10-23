package com.azrinurvani.latihanjetpackcompose.presentation.common

import android.content.res.Configuration
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.azrinurvani.latihanjetpackcompose.R
import com.azrinurvani.latihanjetpackcompose.presentation.theme.LatihanJetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    title: String = "Darlink",
    navigationIcon: @Composable () -> Unit = {},
    actionIcon: @Composable () -> Unit = {}
){
    CenterAlignedTopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = if (!isSystemInDarkTheme()){
                    colorResource(R.color.input_text)
                }else{
                    colorResource(R.color.white)
                }
            )
        },
        navigationIcon = navigationIcon,
        actions = {
            actionIcon()
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor =   if (!isSystemInDarkTheme()){
                Color.White
            }else{
                colorResource(R.color.primary_gradient)
            },
            scrolledContainerColor =
            if (!isSystemInDarkTheme()){
                Color.White
            }else{
                colorResource(R.color.primary_gradient)
            }

        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CustomTopAppBarPreview(){
    LatihanJetpackComposeTheme {
        CustomTopAppBar(
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
            title = "Darlink",
            navigationIcon = {
                IconButton(
                    onClick = {  }
                ) {
                    if (isSystemInDarkTheme()) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back_white),
                            contentDescription = "Back",

                            )
                    }else{
                        Icon(
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = "Back",

                            )
                    }

                }
            }
        )
    }
}