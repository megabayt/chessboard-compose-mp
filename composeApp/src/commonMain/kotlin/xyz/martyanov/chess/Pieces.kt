package xyz.martyanov.chess

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

private val pieceMap = mapOf(
    'k' to "♚", 'q' to "♛", 'r' to "♜", 'b' to "♝", 'n' to "♞", 'p' to "♟",
    'K' to "♔", 'Q' to "♕", 'R' to "♖", 'B' to "♗", 'N' to "♘", 'P' to "♙"
)

fun parseFen(fen: String): Array<String?> {
    val board = Array<String?>(64) { null }
    val fenBoard = fen.split(" ")[0]
    var index = 0

    for (char in fenBoard) {
        when (char) {
            '/' -> continue
            in '1'..'8' -> index += char.digitToInt()
            else -> {
                if (index < 64) {
                    board[index] = pieceMap[char]
                    index++
                }
            }
        }
    }
    return board
}

@Composable
fun PiecesLayer(fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1") {
    val board = remember(fen) { parseFen(fen) }

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
                                text = piece,
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

@Composable
@Preview
fun PiecesLayerPreview() {
    PiecesLayer()
}