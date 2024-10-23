package com.azrinurvani.latihanjetpackcompose.presentation.nav_graph

sealed class RoutesNotPrimitiveTypes(
    val route : String
) {


    object InputBioDataStep2Screen : RoutesNotPrimitiveTypes(route = INPUT_BIO_DATA_STEP2_SCREEN)

    companion object {
        const val INPUT_BIO_DATA_STEP2_SCREEN = "inputBioDataStep2Screen/{userBioDataInput}"
    }
}
