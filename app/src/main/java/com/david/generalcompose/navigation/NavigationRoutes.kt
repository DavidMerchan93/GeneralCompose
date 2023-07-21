package com.david.generalcompose.navigation

sealed class NavigationRoutes(
    val baseRoute: String,
) {
    object GeneralScreen : NavigationRoutes(ROUTES.GENERAL.route)
    object DatePickerScreen : NavigationRoutes(ROUTES.DATE_PICKER.route)
    object TimePickerScreen : NavigationRoutes(ROUTES.TIME_PICKER.route)
    object ConnectivityScreen : NavigationRoutes(ROUTES.CONNECTIVITY_STATUS.route)
}

enum class ROUTES(val route: String) {
    GENERAL("general"),
    DATE_PICKER("date_picker"),
    TIME_PICKER("time_picker"),
    CONNECTIVITY_STATUS("connectivity_status"),
}
