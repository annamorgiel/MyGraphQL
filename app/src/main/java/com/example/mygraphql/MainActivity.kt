package com.example.mygraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mygraphql.ui.GitHubViewModel
import com.example.mygraphql.ui.composable.GitHubScreen
import com.example.mygraphql.ui.theme.MyGraphQLTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGraphQLTheme {
                GitHubScreen(viewModel = hiltViewModel<GitHubViewModel>())
            }
        }
    }
}
