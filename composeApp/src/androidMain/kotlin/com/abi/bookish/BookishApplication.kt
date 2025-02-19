package com.abi.bookish

import android.app.Application
import com.abi.bookish.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookishApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookishApplication)
        }
    }
}