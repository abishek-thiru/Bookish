package com.abi.bookish

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.engine.okhttp.OkHttp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bookish",
    ) {
        App(
            engine = remember { OkHttp.create() }
        )
    }
}