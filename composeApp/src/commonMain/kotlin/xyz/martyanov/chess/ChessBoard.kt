package xyz.martyanov.chess

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*

@Composable
fun ChessBoard(
    initialPosition: Array<String?> = defaultBoardPosition()
) {
    Box {
        Background()
        PiecesLayer(initialPosition)
    }
}

private fun defaultBoardPosition(): Array<String?> = arrayOf(
    "bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR",
    "bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP",
    null, null, null, null, null, null, null, null,
    null, null, null, null, null, null, null, null,
    null, null, null, null, null, null, null, null,
    null, null, null, null, null, null, null, null,
    "wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP",
    "wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"
)
