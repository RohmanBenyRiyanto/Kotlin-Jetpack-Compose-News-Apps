package com.learncompose.presentation.navgraph

sealed class Routes(
    val route: String
) {
    object OnBoardingScreen : Routes("onboarding")
    object HomeScreen : Routes("home")
    object SearchScreen : Routes("search")
    object BookmarksScreen : Routes("bookmarks")
    object DetailsScreen : Routes("details")
    object AppStartNavigation : Routes("appStartNavigation")
    object NewsNavigation : Routes("newsNavigation")
    object NewsNavigationScreen : Routes("newsNavigationScreen")


}
