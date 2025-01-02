package com.example.my_app.constant

  public sealed class Screens(val route:String) {
     object SIGNIN:Screens("SIGNIN")
     object SIGNUP:Screens("SIGNUP")
      object Data:Screens("Data")
}
