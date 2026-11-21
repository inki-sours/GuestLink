package com.tableflow.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val MenuBackground = Color(0xFFF5F2EC)

@Composable
fun MenuScreen(
    cartManager: CardManager,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf("Все") }
    val categories = listOf("Все") + dishes.map { it.category }.distinct()
    val filteredDishes = if (selectedCategory == "Все") {
        dishes
    } else {
        dishes.filter { dish -> dish.category == selectedCategory }
    }
    val recommended = dishes.firstOrNull()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MenuBackground)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "GuestLink", fontSize = 23.sp, fontWeight = FontWeight.Bold)
                Text(text = "Меню ресторана",
                    color = Color(0xFF827E77),
                    fontSize = 12.sp)
            }
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color.Transparent,
                border = BorderStroke(1.dp,
                    Color.DarkGray)
            ) {
                Text(
                    text = "Столик 12",
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    fontSize = 12.sp
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            items(categories) { category ->
                val selected = selectedCategory == category
                Column(
                    modifier = Modifier
                        .clickable { selectedCategory = category }
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = category,
                        fontSize = 13.sp,
                        color = if (selected) Color.Black else Color(0xFF827E77),
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                    )
                    Spacer(Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .width(if (selected) 24.dp else 0.dp)
                            .height(2.dp)
                            .background(Color.Black)
                    )
                }
            }
        }
        HorizontalDivider(color = Color(0xFFE3DED5))
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 18.dp, bottom = 12.dp)
        ) {
            if (selectedCategory == "Все" && recommended != null) {
                item {
                    Text(
                        text = "ШЕФ РЕКОМЕНДУЕТ",
                        fontSize = 11.sp,
                        letterSpacing = 1.sp,
                        color = Color(0xFF827E77),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(170.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFD9D3C9))
                    )
                    DishCard(
                        dish = recommended,
                        onAddToCart = { cartManager.addDish(recommended) }
                    )
                }
            }
            if (filteredDishes.isEmpty()) {
                item {
                    Text(
                        text = "В этой категории пока нет блюд",
                        modifier = Modifier.padding(vertical = 24.dp)
                    )
                }
            } else {
                item {
                    Text(
                        text = if (selectedCategory == "Все") "МЕНЮ" else selectedCategory.uppercase(),
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
                        fontSize = 11.sp,
                        letterSpacing = 1.sp,
                        color = Color(0xFF827E77),
                        fontWeight = FontWeight.Bold
                    )
                }
                items(filteredDishes, key = { it.id }) { dish ->
                    DishCard(
                        dish = dish,
                        onAddToCart = { cartManager.addDish(dish) }
                    )
                    HorizontalDivider(color = Color(0xFFE3DED5))
                }
            }
        }
/*
Button(
    onClick = onNextClick,
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp),
    shape = RoundedCornerShape(12.dp),
    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF171717))
) {
    Text(
        text = "Открыть корзину",
        modifier = Modifier.padding(vertical = 6.dp)
    )
}
*/
}
}
