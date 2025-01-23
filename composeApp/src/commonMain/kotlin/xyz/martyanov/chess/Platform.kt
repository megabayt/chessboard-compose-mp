package xyz.martyanov.chess

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform