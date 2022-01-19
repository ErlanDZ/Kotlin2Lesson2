package com.example.kotlin2lesson2.presentation.state

sealed class UIState<T> {
    class Loading<T> : UIState<T>()
    class Error<T>(error: String) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
}