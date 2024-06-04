package com.example.baseball.presentation.main

sealed interface Event {
    data object NavigateToGame: Event
    data class ShowErrorMessage(val message : String): Event
}