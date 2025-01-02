package com.example.my_app.view.DataCollection

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_app.R
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Data_Collection(){
    var state by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var Home_address by remember { mutableStateOf("") }
    var date by remember { mutableStateOf<String?>(null) }
    var dateState  = rememberDatePickerState()
    var dateSelector by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("sharmadinkar726@gmail.com") }
    var mobileVerification by remember { mutableStateOf(false) }
    var otp by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("Dinkar Sharma") }
    var CountryCode by remember { mutableStateOf("+91") }
    var moblieno by remember { mutableStateOf("8988640799") }
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Image(painter = painterResource(id = R.drawable.user_id_svgrepo_com), contentDescription =null)
        Text(text = "Account Details", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 35.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {
            Text(text = "Your name", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField( modifier = Modifier.fillMaxWidth(),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),leadingIcon = { Icon(imageVector = Icons.Outlined.Person, contentDescription =null, tint = Color.Gray) },value =name, onValueChange ={name=it}, placeholder = { Text(text = " Enter your name", color = Color.Gray)})
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Email", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField( modifier = Modifier.fillMaxWidth(),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription =null, tint = Color.Gray) },value =email, onValueChange ={email=it}, placeholder = { Text(text = " Enter your email", color = Color.Gray)})
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Mobile number", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            Row(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(trailingIcon = { Icon(modifier = Modifier.clickable {  },imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = null)},textStyle = TextStyle(fontSize = 18.sp),value =CountryCode , onValueChange ={CountryCode=it}, modifier = Modifier
                    .height(50.dp)
                    .width(100.dp))
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField( modifier = Modifier
                    .height(50.dp)
                    .width(400.dp),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),leadingIcon = { Icon(imageVector = Icons.Outlined.Phone, contentDescription =null, tint = Color.Gray) },value =moblieno, onValueChange ={moblieno=it}, placeholder = { Text(text = " Enter phone number ", color = Color.Gray)})


            }
            if (moblieno.isNotEmpty()){
                Spacer(modifier = Modifier.height(5.dp))
                if (mobileVerification){
                    OutlinedTextField(leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_smartphone_24), contentDescription =null)},trailingIcon = { Icon(modifier = Modifier.clickable {  },imageVector = Icons.Filled.ArrowForward, contentDescription = null)},textStyle = TextStyle(fontSize = 18.sp),value =otp , onValueChange ={otp=it}, modifier = Modifier
                        .fillMaxWidth(), placeholder = { Text(text = "Enter Otp", color = Color.Gray)})
                }
                else{
                    Button(onClick = {mobileVerification=true}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                        colorResource(id = R.color.yy))) {
                        Text(text = "Verify your mobile number", color = Color.Black, fontSize = 20.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Date of birth", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            if (dateSelector) {
                DatePickerDialog(onDismissRequest = { dateSelector = false }, confirmButton = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { dateSelector = false }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = null,
                                tint = Color.Red
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        IconButton(onClick = {
                            date = dateState.selectedDateMillis?.let { DateConverter(it) }
                            dateSelector = false
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = null,
                                tint = Color.Green
                            )
                        }
                    }
                }) {
                    DatePicker(state = dateState)
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
               if (date.isNullOrEmpty()) {
                   Button(
                       onClick = {dateSelector=true},
                       modifier = Modifier.fillMaxWidth(),
                       colors = ButtonDefaults.buttonColors(
                           colorResource(id = R.color.yy)
                       )
                   ) {
                       Text(text = "Select date", color = Color.Black, fontSize = 20.sp)
                   }
               }
               else{
                   Text(text = "Selected Date : " , color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                   Text(text = date!!, color = colorResource(id = R.color.purple_700,), fontSize = 20.sp, fontWeight =FontWeight.SemiBold)
                   Spacer(modifier = Modifier.width(8.dp))
                   IconButton(onClick = {dateSelector=true}) {
                       Icon(painter = painterResource(id =R.drawable.baseline_change_circle_24 ), tint = colorResource(
                           id = R.color.GG
                       ), contentDescription =null)
                   }
               }
                 }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Address", color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField( modifier = Modifier.fillMaxWidth(),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),value =state, onValueChange ={state=it}, placeholder = { Text(
                text = "Enter state"
            )} )
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),value =district, onValueChange ={district=it}, placeholder = { Text(
                text = "Enter district"
            )} )
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField( modifier = Modifier.fillMaxWidth(),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),value =city, onValueChange ={city=it}, placeholder = { Text(
                text = "Enter city"
            )} )
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),singleLine = true,textStyle = TextStyle(fontSize = 20.sp),value =Home_address, onValueChange ={Home_address=it}, placeholder = { Text(
                text = "Enter home address"
            )}, leadingIcon = { Icon(imageVector = Icons.Outlined.Home, contentDescription =null)} )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.yy)
                )
            ) {
                Text(text = "Lets go", color = Color.Black, fontSize = 20.sp)
                Icon(painter = painterResource(id = R.drawable.baseline_start_24), contentDescription =null)
            }


        }


    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun DateConverter(timestamp:Long):String{
    val date =LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
    val formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return date.format(formatter)
}