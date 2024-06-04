package com.example.baseball.presentation.game

sealed interface Event {
    data class ShowRequests(val message : String) : Event
    data class ShowResult(val result : String, val correctAnswer : Int) : Event
    data object RestartGameActivity : Event
    data object NavigateToMainActivity : Event
}