package com.abi.bookish

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.abi.bookish.book.data.network.KtorRemoteBookDataSource
import com.abi.bookish.book.data.repository.DefaultRepository
import com.abi.bookish.book.presentation.book_list.BookListScreenRoot
import com.abi.bookish.book.presentation.book_list.BookListViewModel
import com.abi.bookish.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel(
            bookRepository = DefaultRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(
                    httpClient = HttpClientFactory.create(
                        engine
                    )
                )
            )
        ) },
        onBookClick = {

        }
    )
}