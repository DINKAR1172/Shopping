package com.example.my_app.view.login_SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_app.R
import com.example.my_app.ViewModel.FirebaseAuthVM
import com.example.my_app.constant.Resultss
import com.example.my_app.constant.Screens


@Composable
fun Sign_Up(navHostController: NavHostController,VM:FirebaseAuthVM) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordview by remember { mutableStateOf(true) }
    var fullname by remember { mutableStateOf("") }
    var FIREBASEAUTHSTATE=VM.AuthState.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.GG)), verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter = painterResource(id = R.drawable.namaste), contentDescription =null)
                Text(text = "Sign Up", fontWeight = FontWeight.ExtraBold, color = Color.Black, fontSize = 35.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "Create an account", color = Color.Black, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(modifier = Modifier.size(width = 300.dp, height = 55.dp), singleLine = true,textStyle = TextStyle(fontSize = 20.sp),leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription =null, tint = Color.Gray)},shape = CircleShape,value =email, onValueChange ={email=it}, placeholder = { Text(text = " Enter your email", color = Color.Gray)})
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(modifier = Modifier.size(width = 300.dp, height = 55.dp),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),leadingIcon = {Icon(imageVector = Icons.Outlined.Person, contentDescription =null, tint = Color.Gray)

                },shape = CircleShape,value =fullname, onValueChange ={fullname=it}, placeholder = { Text(text = "Enter your full name", color = Color.Gray)})
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(modifier = Modifier.size(width = 300.dp, height = 55.dp),singleLine = true, textStyle = TextStyle(fontSize = 20.sp),leadingIcon = {Icon(imageVector = Icons.Outlined.Lock, contentDescription =null, tint = Color.Gray)},shape = CircleShape,value =password, onValueChange ={password=it}, placeholder = { Text(text = " Enter password", color = Color.Gray)}, trailingIcon ={if(passwordview){
                    Icon(painter = painterResource(id = R.drawable.hidden), contentDescription =null, modifier = Modifier.clickable { passwordview=false})
                }else{
                    Icon(painter = painterResource(id = R.drawable.eye), contentDescription =null, modifier = Modifier.clickable { passwordview=true})
                }}, visualTransformation =if (passwordview){
                    PasswordVisualTransformation()
                }
                else{
                    VisualTransformation.None
                })
            }
            if(FIREBASEAUTHSTATE.value is Resultss.Suceess){
                fullname=""
                email=""
                password=""
                navHostController.navigate(Screens.SIGNIN.route)}
            Spacer(modifier = Modifier.height(40.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(onClick = {VM.ADDUSER(Name = fullname, Email = email, Password = password) }, colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.GG)), modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
                    Text(text = "Sign Up", color = Color.White, fontSize = 30.sp)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "Or Sign up with")
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
                .clickable { navHostController.navigate(Screens.SIGNIN.route) }, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Text(text = "Have an account?", color = Color.Black, fontSize = 15.sp)
                Text(text = "SIGN IN", color = colorResource(id = R.color.GG), fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(5.dp))


        }
    }
}