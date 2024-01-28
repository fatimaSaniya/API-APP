package com.example.apiapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apiapp.ui.screens.BookDetailScreen
import com.example.apiapp.ui.screens.BookSearchScreen


//screen
enum class Screens {
    Search,
    Detail
}

@Composable
fun BookNavigation(
    // navController: NavController = rememberNavController(),
    startDestination: String = Screens.Search.name,
) {
    val viewModel = viewModel<BookViewModel>()
    val uiState = viewModel.uiState.collectAsState().value

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Search.name) {
            BookSearchScreen(
                uiState = uiState,
                onQueryChange = viewModel::onQueryChange,
                onSubmit = {
                    viewModel.searchBooks()
                    navController.navigate(Screens.Detail.name)
                }
            )
        }
        composable(Screens.Detail.name) {
            BookDetailScreen(
                uiState = uiState,
                onBackPress = {
                    navController.popBackStack()
                },
                onBookSelected = {
                    // todo put it in UiState
                    // todo move to the display screen
                }
            )
        }
    }
}