package com.example.daggerexample

import com.example.daggerexample.analytics.AnalyticsServiceModule
import com.example.daggerexample.analytics.AnalyticsServices
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsServiceModule::class])
interface AppComponent {
    //fun getAnalyticsServices():AnalyticsServices
    fun getUserRegistrationComponentFactory():UserRegistrationComponent.Factory
}