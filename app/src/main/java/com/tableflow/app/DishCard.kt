package com.tableflow.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun DishCard(
    dish: MenuDish,
    onAddToCart: () -> Unit
) {
    Card(modifier = Modifier,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = ColorPainter(Color.DarkGray),
                    contentDescription = "здесь должно быть изображение:(",

                    modifier = Modifier
                        .size(width = 130.dp, height = 150.dp)
                        .clip(RoundedCornerShape(12.dp))


                )

                Column(
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp)

                ) {
                    Text(text = dish.name,
                        style = MaterialTheme.typography.titleMedium
                        )
                    Text(text = dish.description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                        )
                    Text(text = "${dish.price} ₽",
                        style = MaterialTheme.typography.titleMedium
                        )
                }

            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp)),
                onClick = onAddToCart
            ) {
                Text(text = "Добавить в заказ")
            }
        }

    }
}


