package com.tableflow.app

data class CardItem(
    val dish: MenuDish,
    var quantity: Int
) {
    val totalPrice: Int
        get() = dish.price * quantity
}