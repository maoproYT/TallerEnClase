package me.mauricioherrera.statecompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanzarDado() {

    val list = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    var currentDice by remember { mutableStateOf(list[0]) }

    var number by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = currentDice),
            contentDescription = "Dado",
            modifier = Modifier.size(180.dp)
        )

        if (number != null) {
            Text(
                text = "Número: $number",
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {

            number = (1..6).random()

            currentDice = list[number!! - 1]

        }) {
            Text(
                text = "Lanza el dado!!!!",
                fontSize = 16.sp
            )
        }
    }
}