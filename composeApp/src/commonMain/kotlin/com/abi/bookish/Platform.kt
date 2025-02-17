package com.abi.bookish

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform