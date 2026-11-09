package com.tableflow.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf("Все") }
    val cartManager = remember { CardMenager() }


    val categories = listOf(
        "Все", "Горячие блюда", "Холодные блюда",
        "Закуски", "Салаты", "Десерты", "Напитки"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "TableFlow", fontSize = 18.sp)
            Text(text = "Столик 12", fontSize = 14.sp)
        }

        Text(
            text = "Меню",
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 28.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = { Text(text = category) }
                )
            }

        }

        val filteredDishes = if (selectedCategory == "Все") {
            dishes
        } else {
            dishes.filter { dish -> dish.category == selectedCategory }
        }

        if (filteredDishes.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){ Text(text = "В этой категории пока нет блюд") }

        } else {
            LazyColumn() { items(filteredDishes) { dish -> DishCard(dish = dish, onAddToCart =
                {cartManager.addDish(dish)})
            }
            }
        }

    }
}
