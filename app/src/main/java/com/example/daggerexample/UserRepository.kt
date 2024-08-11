package com.example.daggerexample

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepositoryService{
    fun saveUser(email: String, password: String)
}

//@Singleton
@ApplicationScope
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