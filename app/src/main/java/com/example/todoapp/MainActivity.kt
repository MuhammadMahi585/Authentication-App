package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.todoapp.pages.AuthViewModel
import com.example.todoapp.pages.MyAppNavigation
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel: AuthViewModel by viewModels()
        setContent {
            TodoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->
                    MyAppNavigation(modifier = Modifier.padding(innerPadding),authViewModel)
                }
            }
        }
    }
}

