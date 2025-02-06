package domain

data class Game(
    val status: GameStatus = GameStatus.Idle,
    val score: Int = 0,
    val settings: GameSettings = GameSettings()
)

data class GameSettings(
    val alienSpeed: Float = 10f,
    val alienLaserSpeed: Float = 15f
)