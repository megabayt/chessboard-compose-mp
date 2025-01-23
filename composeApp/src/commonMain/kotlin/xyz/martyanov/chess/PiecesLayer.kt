package xyz.martyanov.chess

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

private val pieceMap = mapOf(
    "bK" to "♚", "bQ" to "♛", "bR" to "♜", "bB" to "♝", "bN" to "♞", "bP" to "♟",
    "wK" to "♔", "wQ" to "♕", "wR" to "♖", "wB" to "♗", "wN" to "♘", "wP" to "♙"
)

@Composable
fun PiecesLayer(board: Array<String?>) {
    Column {
        for (row in 0..7) {
            Row {
                for (col in 0..7) {
                    Box(
                        modifier = Modifier.size(Constants.SQUARE_SIZE),
                        contentAlignment = Alignment.Center
                    ) {
                        val piece = board[row * 8 + col]
                        if (piece != null) {
                            Text(
                                text = pieceMap[piece] ?: "",
                                fontSize = 32.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
