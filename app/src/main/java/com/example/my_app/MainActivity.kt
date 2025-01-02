package com.example.my_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.my_app.ViewModel.FirebaseAuthVM
import com.example.my_app.constant.Screens
import com.example.my_app.ui.theme.My_AppTheme
import com.example.my_app.view.DataCollection.Data_Collection
import com.example.my_app.view.login_SignUp.Sign_IN
import com.example.my_app.view.login_SignUp.Sign_Up
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val FirebaseVM= hiltViewModel<FirebaseAuthVM>()
            My_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
Navigator(VM = FirebaseVM)
                }
            }
        }
    }
}

@Composable
fun Navigator(navHostController: NavHostController= rememberNavController(),VM:FirebaseAuthVM){
    NavHost(navController =navHostController, startDestination =Screens.SIGNUP.route ){
        composable(Screens.SIGNUP.route){
            Sign_Up(navHostController,VM)
        }
        composable(Screens.SIGNIN.route){
            Sign_IN(navHostController,VM)
        }
        composable(Screens.Data.route){
            Data_Collection()
        }
    }
}