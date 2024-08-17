package com.example.daggerexample

import android.app.Application
//import com.example.daggerexample.di.ApplicationComponent
//import com.example.daggerexample.di.DaggerApplicationComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakerApplication : Application() {

    //lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        //applicationComponent = DaggerApplicationComponent.builder().build()
    }

}