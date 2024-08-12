package com.example.daggerexample

import android.util.Log
import com.example.daggerexample.analytics.AnalyticsServices
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepositoryService{
    fun saveUser(email: String, password: String)
}

//@Singleton
//@ApplicationScope
@ActivityScope
class SQLRepository @Inject constructor(private val analyticsServices: AnalyticsServices) : UserRepositoryService {
    override fun saveUser(email: String, password: String) {
        Log.d("SQLRepository", "User Saved in SQLRepository")
        analyticsServices.trackEvent("SAVE USER","CREATE")
    }
}

class FirebaseRepository @Inject constructor(private val analyticsServices: AnalyticsServices) : UserRepositoryService {
    override fun saveUser(email: String, password: String) {
        Log.d("FirebaseRepository", "User Saved in FirebaseRepository")
        analyticsServices.trackEvent("SAVE USER","CREATE")
    }

}