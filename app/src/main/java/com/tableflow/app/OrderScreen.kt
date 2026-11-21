package com.tableflow.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tableflow.app.navigation.Order
import com.tableflow.app.ui.theme.BackgroundLight



@Composable
fun OrderScreen(
    modifier : Modifier = Modifier

) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background( BackgroundLight)
        .padding(horizontal = 20.dp)

    ){
        Row(modifier = Modifier
            .fillMaxWidth()

        ) {
        Row{
            Text(text="Заказ №")
            Text(text = "Стол 12")
        }

        }


    }



}