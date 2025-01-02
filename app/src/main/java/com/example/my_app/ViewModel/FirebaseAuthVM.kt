package com.example.my_app.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_app.Model.REPO.FirebaseAuthRepo
import com.example.my_app.constant.Resultss
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseAuthVM @Inject constructor(private  val repo:FirebaseAuthRepo) :ViewModel() {
    private var _SIGNINState=MutableLiveData<Resultss<Boolean>>()
    val SIGNINSTATE:LiveData<Resultss<Boolean>> get() = _SIGNINState

    private var _AuthState=MutableLiveData<Resultss<Boolean>>()
    val AuthState:LiveData<Resultss<Boolean>> get() = _AuthState
    fun ADDUSER(Name:String,Email:String,Password:String){
        _AuthState.value=Resultss.loading
        viewModelScope.launch {
        _AuthState.value=repo.Adduser(Name,Email,Password)
        }
}
    fun SIGN_IN(Email: String,Password: String){
        _SIGNINState.value=Resultss.loading
        viewModelScope.launch {
            _SIGNINState.value=repo.Check_Authentication(Email, Password)
        }
    }

}