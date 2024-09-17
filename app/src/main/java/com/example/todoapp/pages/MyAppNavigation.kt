package com.example.todoapp.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier,viewModel: AuthViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "Login") {
        composable("HomePage"){
            HomePage(modifier,viewModel,navController)
        }
        composable("Login"){
            Login(modifier,navController,viewModel)
        }
        composable("SignUp"){
             SignUpPage(modifier,navController,viewModel)
        }
    }
}