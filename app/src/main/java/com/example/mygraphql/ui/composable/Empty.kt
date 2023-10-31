package com.example.mygraphql.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Empty(errorMessage: String? = null) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "No repositories $errorMessage")
    }
}

@Composable
fun Loading() {
    Surface(
        modifier = Modifier.padding(Dp(8.0f)).fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Loading...")
            CircularProgressIndicator()
        }
    }
}
