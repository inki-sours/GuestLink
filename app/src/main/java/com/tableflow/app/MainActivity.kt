package com.tableflow.app


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tableflow.app.navigation.AppNavHost
import com.tableflow.app.navigation.Card
import com.tableflow.app.navigation.Menu
import com.tableflow.app.ui.theme.TableFlowTheme
import com.tableflow.app.navigation.Order

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TableFlowTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination
                val isMenuSelected = currentDestination?.hasRoute<Menu>() == true
                val isCartSelected = currentDestination?.hasRoute<Card>() == true
                val isOrderSelected = currentDestination?.hasRoute<Order>() == true
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = isMenuSelected,
                                onClick = {
                                    if (!isMenuSelected) {
                                        navController.navigate(Menu) {
                                            popUpTo<Menu>()
                                            launchSingleTop = true
                                        }
                                    }
                                },
                                icon = { Text("☰") },
                                label = { Text("Меню") }
                            )

                            NavigationBarItem(
                                selected = isCartSelected,
                                onClick = {
                                    if (!isCartSelected) {
                                        navController.navigate(Card) {
                                            popUpTo<Menu>()
                                            launchSingleTop = true
                                        }
                                    }
                                },
                                icon = { Text("🛒") },
                                label = { Text("Корзина") }
                            )


                            NavigationBarItem(
                                selected = isOrderSelected,
                                onClick = {
                                    if (!isOrderSelected) {
                                        navController.navigate(Order) {
                                            popUpTo<Menu>()
                                            launchSingleTop = true
                                        }
                                    }
                                },
                                icon = { Text("📋") },
                                label = { Text("Заказ") }
                            )

                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        AppNavHost(navHostController = navController)


                    }
                }
            }

        }

    }
}
