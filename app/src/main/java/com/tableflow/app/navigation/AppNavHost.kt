package com.tableflow.app.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tableflow.app.CardScreen
import com.tableflow.app.MenuScreen


@Composable
fun AppNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Menu
    ) {
        composable<Menu> {
            MenuScreen(
                onNextClick = {
                    navHostController.navigate(Card) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Card> {
            CardScreen(
                onBackClick = { navHostController.popBackStack() }
            )
        }
    }
}

