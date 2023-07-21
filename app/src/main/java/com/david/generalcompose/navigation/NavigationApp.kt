package com.david.generalcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.david.generalcompose.screns.ConnectivityScreen
import com.david.generalcompose.screns.DatePickerScreen
import com.david.generalcompose.screns.GeneralMainScreen
import com.david.generalcompose.screns.TimePickerScreen

@Composable
fun NavigationApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ROUTES.GENERAL.route) {
        composable(ROUTES.GENERAL.route) {
            GeneralMainScreen(
                onSelectItem = {
                    navController.navigate(it.route)
                },
            )
        }
        composable(ROUTES.DATE_PICKER.route) {
            DatePickerScreen()
        }
        composable(ROUTES.TIME_PICKER.route) {
            TimePickerScreen()
        }
        composable(ROUTES.CONNECTIVITY_STATUS.route) {
            ConnectivityScreen()
        }
    }
}
