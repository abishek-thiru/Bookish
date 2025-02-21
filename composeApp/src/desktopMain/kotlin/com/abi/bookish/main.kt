package com.abi.bookish

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.abi.bookish.app.App
import com.abi.bookish.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Bookish",
        ) {
            App()
        }
    }
}