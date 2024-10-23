package com.azrinurvani.latihanjetpackcompose.presentation.nav_graph

import kotlinx.serialization.Serializable

sealed class RoutesPrimitiveTypes {

    @Serializable
    object LoginScreen : RoutesPrimitiveTypes()

    @Serializable
    object StartedLoginScreen : RoutesPrimitiveTypes()

    @Serializable
    data class HomeScreen(val phoneNumber : String) : RoutesPrimitiveTypes()

}
