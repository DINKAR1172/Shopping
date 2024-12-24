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
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_app.R

@Composable
fun Sign_IN() {
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
                Image(painter = painterResource(id = R.drawable.namaste), contentDescription =null)
                Text(text = "Sign In", fontWeight = FontWeight.ExtraBold, color = Color.Black, fontSize = 35.sp)
                Spacer(modifier = Modifier.height(20.dp))
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(value =email, onValueChange ={email=it}, placeholder = { Text(text = "Email Address")})
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                OutlinedTextField(value =password, onValueChange ={password=it}, placeholder = { Text(text = "Password")}, trailingIcon ={if(passwordView){
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
                .padding(end = 50.dp), horizontalArrangement = Arrangement.End){
                Text(text = "Forgot Password?", color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.GG)), modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
                    Text(text = "Sign In", color = Color.White, fontSize = 30.sp)
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

        }

    }
    }