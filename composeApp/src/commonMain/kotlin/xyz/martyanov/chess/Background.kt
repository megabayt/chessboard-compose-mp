package xyz.martyanov.chess

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BackgroundCell(isLight: Boolean) {
    Box(
        modifier = Modifier
            .size(Constants.SQUARE_SIZE)
            .background(if (isLight) Color(0xFFEBECD0) else Color(0xFF739552))
    )
}

@Composable
fun BackgroundRow(startWithLight: Boolean) {
    Row {
        for (i in 0..7) {
            BackgroundCell(isLight = (i % 2 == 0) == startWithLight)
        }
    }
}

@Composable
@Preview
fun Background() {
    Column {
        for (i in 0..7) {
            BackgroundRow(startWithLight = i % 2 == 0)
        }
    }
}
