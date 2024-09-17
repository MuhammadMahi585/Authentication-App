package com.example.todoapp.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomePage(
    modifier: Modifier,
    authViewModel: AuthViewModel,
    navHostController: NavHostController
){
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
      when(authState.value){
          is AuthState.UnAuthenticated -> navHostController.navigate("Login")
          else-> Unit
      }
    }
    Column(
        modifier =
            modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "SignOut Page",
            style = MaterialTheme.typography.titleLarge
            )
        Spacer(modifier = Modifier.padding(16.dp))
        TextButton(onClick = {
            authViewModel.signOut()
        }) {
            Text(text = "SignOut")
        }
    }
}