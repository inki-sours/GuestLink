package com.tableflow.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
@Composable
fun CardScreen(
cardManager: CardManager
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Корзина")

    }

    val cardItems = cardManager.cardItems
    if (cardItems.isEmpty()) {
        Text(text = "Корзина пуста")
    } else {
        LazyColumn( modifier = Modifier
            .fillMaxWidth()

        ) {
             items(cardItems) {item ->
                 Column() {
                     Text(text = item.dish.name)
                     Text(text = "Количество: ${item.quantity}")
                     Text(text="Цена: ${item.totalPrice} ₽")
                 }
             }

        }
    }
}