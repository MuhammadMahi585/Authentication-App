package com.example.todoapp.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.todoapp.R

@Composable
fun Login(
    modifier: Modifier,
    navHostController: NavHostController,
    viewModel: AuthViewModel
){
    val authState = viewModel.authState.observeAsState()
    val conext = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated-> navHostController.navigate("HomePage")
            is AuthState.Error -> Toast.makeText(conext,
                (authState.value as AuthState.Error).message,Toast.LENGTH_SHORT).show()
            else->Unit
        }
    }
      Column(
          modifier = modifier
              .fillMaxSize(),
            //  .padding(8.dp)
              //.safeContentPadding(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Text(text = stringResource(R.string.login_page),
             style = MaterialTheme.typography.titleLarge)
          
          Spacer(modifier = Modifier.height(16.dp))
          OutlinedTextField(
              value = email,
              onValueChange = {it->email=it},
              label = {
                  Text(text = stringResource(R.string.email))
              })
          Spacer(modifier = Modifier.height(8.dp))
          OutlinedTextField(
              value = password,
              onValueChange = {it->password=it},
              label = {
                  Text(text = stringResource(id = R.string.password))
              })
          Spacer(modifier = Modifier.height(16.dp))
          Button(onClick = {
              viewModel.logIn(email,password)
          }) {
              Text(text = stringResource(R.string.login))
          }
          Spacer(modifier = Modifier.height(8.dp))
          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
          ) {
              Text(text = stringResource(R.string.don_t_have_an_a_account))
              TextButton(onClick = { navHostController.navigate("SignUp") }) {
                  Text(text = "SignUp")
              }
          }
      }
}