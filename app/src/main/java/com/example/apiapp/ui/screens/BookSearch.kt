package com.example.apiapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apiapp.ui.BookUiState
import com.example.apiapp.ui.theme.APIAPPTheme

@Composable
fun BookSearchScreen(
    uiState: BookUiState,
    onQueryChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Search Books")
        OutlinedTextField(
            value = uiState.queryText,
            onValueChange = { onQueryChange(it) },
        )
        ElevatedButton(onClick = onSubmit,
            modifier = Modifier.padding(vertical = 16.dp)) {
            Text(text = "Search Book")
        }
    }
}

@Preview
@Composable
fun BookSearchScreenPreview() {
    APIAPPTheme {
        BookSearchScreen(
            uiState = BookUiState(queryText =  "Android"),
            onQueryChange = {},
            onSubmit = {})
    }
}