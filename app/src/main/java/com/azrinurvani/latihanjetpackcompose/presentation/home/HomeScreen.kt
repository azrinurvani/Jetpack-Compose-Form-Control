package com.azrinurvani.latihanjetpackcompose.presentation.home

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azrinurvani.latihanjetpackcompose.R
import com.azrinurvani.latihanjetpackcompose.presentation.common.CustomOutlineTextField
import com.azrinurvani.latihanjetpackcompose.presentation.common.CustomTopAppBar
import com.azrinurvani.latihanjetpackcompose.presentation.model.UserBioDataInput
import com.azrinurvani.latihanjetpackcompose.presentation.theme.LatihanJetpackComposeTheme
import com.azrinurvani.latihanjetpackcompose.presentation.util.stroke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    phoneNumber : String,
    state: HomeState,
    event : (HomeEvent) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    onBackClick : () -> Unit = {},
    navigateToInputStep2 : (UserBioDataInput) -> Unit
){

    val context = LocalContext.current

    var userBioDataInput by remember {
        mutableStateOf(UserBioDataInput())
    }
    val strokeColor = colorResource(R.color.primary_200)

    Scaffold(
        topBar = {
            CustomTopAppBar(
                modifier = modifier,
                title = "Buat Agen Baru",
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(
                        onClick = { onBackClick() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .background(color = colorResource(R.color.gray_25))
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
                    .weight(1f,false)
            ) {
                Text(
                    text = "Informasi KTP",
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.gray_600)
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomOutlineTextField(
                    modifier = modifier.fillMaxSize(),
                    value = state.userBioDataInput.fullName,
                    onValueTextChange = {
                        userBioDataInput = userBioDataInput.copy(fullName = it)
                        event(HomeEvent.UpdateBioDataInput(
                            userBioDataInput = userBioDataInput
                        ))
                    },
                    label = "Nama Lengkap",
                    placeHolder = "Azri Nurvani",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                )
                Spacer(modifier = Modifier.height(12.dp))
                CustomOutlineTextField(
                    modifier = modifier,
                    value = state.userBioDataInput.identityNumber,
                    onValueTextChange = {
                        userBioDataInput = userBioDataInput.copy(identityNumber = it)
                        event(HomeEvent.UpdateBioDataInput(
                            userBioDataInput = userBioDataInput
                        ))
                    },
                    label = "NIK KTP",
                    placeHolder = "1102xxxxxxxxx",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                )
                Spacer(modifier = Modifier.height(12.dp))
                CustomOutlineTextField(
                    modifier = modifier,
                    value = state.userBioDataInput.addressFromId,
                    onValueTextChange = {
                        userBioDataInput = userBioDataInput.copy(addressFromId = it)
                        event(HomeEvent.UpdateBioDataInput(
                            userBioDataInput = userBioDataInput
                        ))
                    },
                    label = "Alamat KTP",
                    placeHolder = "Jaka Setia, Pekayon, Bekasi Selatan, Bekasi, 17147",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                )
                Spacer(modifier = Modifier.height(12.dp))
                CustomOutlineTextField(
                    modifier = modifier,
                    value = state.userBioDataInput.addressDomicile,
                    onValueTextChange = {
                        userBioDataInput = userBioDataInput.copy(addressDomicile = it)
                        event(HomeEvent.UpdateBioDataInput(
                            userBioDataInput = userBioDataInput
                        ))
                    },
                    label = "Lokasi Domisili",
                    placeHolder = "Jaka Setia, Pekayon, Bekasi Selatan, Bekasi, 17147",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Kode Referal",
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.gray_600)
                )
                Spacer(modifier = Modifier.height(16.dp))

                CustomOutlineTextField(
                    modifier = modifier,
                    value = state.userBioDataInput.referralCode,
                    onValueTextChange = {
                        userBioDataInput = userBioDataInput.copy(referralCode = it)
                        event(HomeEvent.UpdateBioDataInput(
                            userBioDataInput = userBioDataInput
                        ))
                    },
                    label = "Input",
                    placeHolder = "CODE1234xxxxx",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Pindai QR",
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.gray_600)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.medium)
                        .background(color = colorResource(R.color.primary_25))
                        .drawBehind {
                            drawRoundRect(
                                color = strokeColor,
                                style = stroke
                            )
                        }
                        .clickable {  },
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.size(
                                24.dp,
                                24.dp
                            ),
                            painter = painterResource(R.drawable.ic_camera_primary),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Buka Kamera",
                            style = MaterialTheme.typography.labelSmall,
                            color = colorResource(R.color.input_text)
                        )
                    }

                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 32.dp
                    ),
                onClick = {
                    event(HomeEvent.SubmitBioData(state.userBioDataInput))
                    navigateToInputStep2(state.userBioDataInput)
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview(){
    LatihanJetpackComposeTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        HomeScreen(
            modifier = Modifier,
            phoneNumber = "",
            state = HomeState(userBioDataInput = UserBioDataInput()),
            scrollBehavior = scrollBehavior,
            event = {},
            navigateToInputStep2 = {}
        )
    }
}

