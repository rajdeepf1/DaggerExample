package com.example.daggerexample

import android.util.Log
import javax.inject.Inject

class UserRegisterService @Inject constructor(){
    fun saveUser (email: String, password: String) {
        Log.d("UserRegisterService", "User Saved in DB")
    }
}