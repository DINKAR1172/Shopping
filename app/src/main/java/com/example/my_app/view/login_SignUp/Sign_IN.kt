package com.example.my_app.view.login_SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_app.R
import com.example.my_app.ViewModel.FirebaseAuthVM
import com.example.my_app.constant.Resultss
import com.example.my_app.constant.Screens

@Composable
fun Sign_IN(navHostController: NavHostController,VM:FirebaseAuthVM) {
    var SignInState =VM.SIGNINSTATE.observeAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordView by remember { mutableStateOf(true) }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.GG)), verticalArrangement = Arrangement.Center){
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .background(Color.White)){
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter = painterResource(id = R.drawable.businessman_shaking_hands_svgrepo_com), contentDescription =null)
                Text(text = "Sign In", fontWeight = FontWeight.ExtraBold, color = Color.Black, fontSize = 35.sp)
                Spacer(modifier = Modifier.height(20.dp))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(modifier = Modifier.size(width = 300.dp, height = 55.dp),singleLine = true,leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription =null, tint = Color.Gray)},textStyle = TextStyle(fontSize = 20.sp),shape = CircleShape,value =email, onValueChange ={email=it}, placeholder = { Text(text = "Email Address")})
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(modifier = Modifier.size(width = 300.dp, height = 55.dp),singleLine = true,leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription =null, tint = Color.Gray)},textStyle = TextStyle(fontSize = 20.sp),shape = CircleShape,value =password, onValueChange ={password=it}, placeholder = { Text(text = "Password")}, trailingIcon ={if(passwordView){
                    Icon(painter = painterResource(id = R.drawable.hidden), contentDescription =null, modifier = Modifier.clickable { passwordView=false})
                }else{
                    Icon(painter = painterResource(id = R.drawable.eye), contentDescription =null, modifier = Modifier.clickable { passwordView=true})
                }}, visualTransformation =if (passwordView){
                 PasswordVisualTransformation()
                }
                else{
                    VisualTransformation.None
                })
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 55.dp), horizontalArrangement = Arrangement.End){
                Text(text = "Forgot Password?", color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (SignInState.value is Resultss.Suceess){
                email=""
                password=""
                navHostController.navigate(Screens.Data.route)
            }
            if (SignInState.value is Resultss.Error) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Invalid user & password", color = Color.Red)
                }
            }
            Spacer(modifier =Modifier.height(20.dp) )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(onClick = {
                    VM.SIGN_IN(email,password)}, colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.GG)), modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
                    Text(text = "Sign In", color = Color.White, fontSize = 30.sp)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "Or Sign In with")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.google_logo_search_new_svgrepo_com), contentDescription =null)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { navHostController.navigate(Screens.SIGNUP.route) }, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Don't have an account?", color = Color.Black, fontSize = 15.sp)
                Text(text = "SIGN UP", color = colorResource(id = R.color.GG), fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(5.dp))

        }

    }
    }
