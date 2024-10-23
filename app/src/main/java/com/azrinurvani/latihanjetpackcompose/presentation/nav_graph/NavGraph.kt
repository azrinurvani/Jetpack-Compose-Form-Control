package com.azrinurvani.latihanjetpackcompose.presentation.nav_graph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.azrinurvani.latihanjetpackcompose.presentation.home.HomeScreen
import com.azrinurvani.latihanjetpackcompose.presentation.home.HomeViewModel
import com.azrinurvani.latihanjetpackcompose.presentation.input_bio_data.InputBioDataStep2Screen
import com.azrinurvani.latihanjetpackcompose.presentation.login.LoginScreen
import com.azrinurvani.latihanjetpackcompose.presentation.login.LoginViewModel
import com.azrinurvani.latihanjetpackcompose.presentation.model.UserBioDataInput
import com.azrinurvani.latihanjetpackcompose.presentation.option_role_login.StartedLoginScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    scrollBehavior: TopAppBarScrollBehavior
){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RoutesPrimitiveTypes.StartedLoginScreen
    ){
        composable<RoutesPrimitiveTypes.StartedLoginScreen> {
            StartedLoginScreen(
                navigateToLogin = {
                    navigateToLogin(navController = navController)
                }
            )
        }

        composable<RoutesPrimitiveTypes.LoginScreen> {
            val viewModel : LoginViewModel = hiltViewModel()
            val loginState = viewModel.state.value
            LoginScreen(
                state = loginState,
                event = viewModel::onEvent,
                navigateToHome = { phoneNumber->
                    navigateToHome(
                        navController = navController,
                        phoneNumber = phoneNumber
                    )
                }
            )
        }

        composable<RoutesPrimitiveTypes.HomeScreen> { navBackStackEntry ->
            val phoneNumber = navBackStackEntry.toRoute<RoutesPrimitiveTypes.HomeScreen>().phoneNumber
            val viewModel : HomeViewModel = hiltViewModel()
            val state = viewModel.state.value
            HomeScreen(
                phoneNumber = phoneNumber,
                state = state,
                event = viewModel::onEvent,
                onBackClick = {
                    navController.navigateUp()
                },
                scrollBehavior = scrollBehavior,
                navigateToInputStep2 = {
                    navigateToInputBioDataStep2(
                        navController = navController,
                        userBioDataInput = it
                    )
                }
            )
        }


        composable(
            RoutesNotPrimitiveTypes.InputBioDataStep2Screen.route,
            arguments = listOf(navArgument("userBioDataInput") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val userBioDataInputJson = navBackStackEntry.arguments?.getString("userBioDataInput")
            val userBioDataInput = userBioDataInputJson?.let {
                Json.decodeFromString<UserBioDataInput>(URLDecoder.decode(it, StandardCharsets.UTF_8.toString()))
            }
            InputBioDataStep2Screen(
                userBioDataInput = userBioDataInput,
                onBackClick = { navController.navigateUp() }
            )
        }

    }
}

fun navigateToLogin(navController: NavController){
    navController.navigate(RoutesPrimitiveTypes.LoginScreen)
}

fun navigateToHome(navController: NavController,phoneNumber: String){
    navController.navigate(RoutesPrimitiveTypes.HomeScreen(phoneNumber))
}

fun navigateToInputBioDataStep2(navController: NavController, userBioDataInput: UserBioDataInput) {
    val json = URLEncoder.encode(Json.encodeToString(userBioDataInput), StandardCharsets.UTF_8.toString())
    navController.navigate("InputBioDataStep2Screen/$json")
}