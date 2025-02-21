package com.abi.bookish

import androidx.compose.ui.window.ComposeUIViewController
import com.abi.bookish.app.App
import com.abi.bookish.di.initKoin

fun MainViewController() = ComposeUIViewController (
    configure = {
        initKoin()
    }
){ App() }