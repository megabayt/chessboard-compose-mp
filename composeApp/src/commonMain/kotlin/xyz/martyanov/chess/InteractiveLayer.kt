package xyz.martyanov.chess

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun InteractiveLayer(
    board: Array<String?>,
    onPieceMoved: (fromIndex: Int, toIndex: Int) -> Unit
) {
    var selectedSquare by remember { mutableStateOf<Int?>(null) }

    Column {
        for (row in 0..7) {
            Row {
                for (col in 0..7) {
                    val index = row * 8 + col
                    val isSelected = selectedSquare == index

                    Box(
                        modifier = Modifier
                            .size(Constants.SQUARE_SIZE)
                            .background(if (isSelected) Color(0x80FFF176) else Color.Transparent)
                            .clickable {
                                if (selectedSquare == null) {
                                    // Select piece if square is not empty
                                    if (board[index] != null) {
                                        selectedSquare = index
                                    }
                                } else {
                                    // Move piece if different square selected
                                    if (selectedSquare != index) {
                                        onPieceMoved(selectedSquare!!, index)
                                    }
                                    selectedSquare = null
                                }
                            }
                    )
                }
            }
        }
    }
}