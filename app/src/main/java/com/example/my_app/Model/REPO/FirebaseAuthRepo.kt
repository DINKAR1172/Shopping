package com.example.my_app.Model.REPO

import com.example.my_app.Model.dc.NewUser
import com.example.my_app.constant.Resultss
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepo @Inject constructor(val auth:FirebaseAuth,val firestore:FirebaseFirestore){
    suspend fun  Adduser( Name:String, Email:String, password:String):Resultss<Boolean> =try {
auth.createUserWithEmailAndPassword(Email,password).await()
        addtofirestore(NewUser(Name=Name, Email = Email))
        Resultss.Suceess(true)

    }
    catch (e:Exception){
        Resultss.Error(e)
    }
    private suspend fun addtofirestore(data:NewUser){
        firestore.collection("Users").document(data.Name).set(data).await()
    }
    suspend fun Check_Authentication(Email:String,Password:String):Resultss<Boolean> =try {
        auth.signInWithEmailAndPassword(Email,Password).await()
        Resultss.Suceess(true)
    }
    catch (e:Exception){
        Resultss.Error(e)
    }

}