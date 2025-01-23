package xyz.martyanov.chess

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ChessBoard(fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1") {
    Box {
        Background()
        PiecesLayer(fen)
    }
}
