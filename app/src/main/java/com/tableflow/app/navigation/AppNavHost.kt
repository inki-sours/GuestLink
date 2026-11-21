package com.tableflow.app.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tableflow.app.CardManager
import com.tableflow.app.CardScreen
import com.tableflow.app.MenuScreen
import com.tableflow.app.OrderScreen



@Composable
fun AppNavHost(
    navHostController: NavHostController,

) {
    val cardManager = remember { CardManager() }
    NavHost(
        navController = navHostController,
        startDestination = Menu
    ) {
        composable<Menu> {
            MenuScreen(
                cartManager = cardManager
            )


        }
        composable<Card> {
            CardScreen(
                cardManager = cardManager
            )


        }
        composable<Order> {
            OrderScreen()


        }



    }
}

