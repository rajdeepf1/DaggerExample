package com.example.daggerexample

import android.util.Log
import javax.inject.Inject


interface UserRepositoryService{
    fun saveUser(email: String, password: String)
}

class SQLRepository @Inject constructor() : UserRepositoryService {
    override fun saveUser(email: String, password: String) {
        Log.d("SQLRepository", "User Saved in SQLRepository")
    }
}

class FirebaseRepository @Inject constructor() : UserRepositoryService {
    override fun saveUser(email: String, password: String) {
        Log.d("FirebaseRepository", "User Saved in FirebaseRepository")
    }

}