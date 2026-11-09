package com.tableflow.app

import androidx.compose.runtime.mutableStateListOf

class CardMenager {
    private val items = mutableStateListOf<CardItem>()

    val cardItems: List<CardItem>
        get() = items.toList()

    val totalPrice: Int
        get() = items.sumOf { it.totalPrice }

    val totalQuantity: Int
        get() = items.sumOf { it.quantity }



    fun addDish(dish: MenuDish) {
        val item = items.find { it.dish.id == dish.id }

        if (item != null) {
            item.quantity += 1
        } else {
            items.add(CardItem(dish = dish, quantity = 1))
        }
    }


    fun removeDish(dish: MenuDish) {
        val item = items.find { it.dish.id == dish.id }
        if (item != null) {
            item.quantity -= 1
            if (item.quantity <= 0) {
                items.remove(item)
            }
        }
    }

    fun clearCard() {
        items.clear()
    }
    }