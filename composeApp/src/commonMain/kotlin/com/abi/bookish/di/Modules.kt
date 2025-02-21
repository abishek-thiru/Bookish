package com.abi.bookish.di

import com.abi.bookish.book.data.network.KtorRemoteBookDataSource
import com.abi.bookish.book.data.network.RemoteDataSource
import com.abi.bookish.book.data.repository.DefaultRepository
import com.abi.bookish.book.domain.BookRepository
import com.abi.bookish.book.presentation.SelectedBookViewModel
import com.abi.bookish.book.presentation.book_detail.BookDetailViewModel
import com.abi.bookish.book.presentation.book_list.BookListViewModel
import com.abi.bookish.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        HttpClientFactory.create(get())
    }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteDataSource>()
    singleOf(::DefaultRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)
}