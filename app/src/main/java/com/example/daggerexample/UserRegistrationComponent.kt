package com.example.daggerexample

import com.example.daggerexample.analytics.AnalyticsServiceModule
import com.example.daggerexample.analytics.AnalyticsServices
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

//@Singleton
//@ApplicationScope
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
//    fun getUserRegistrationService() : UserRegistrationService
//    fun getEmailService() : EmailService

    //or

    fun inject(mainActivity: MainActivity)

    fun getEmailService() : EmailService

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance count : Int,appComponent: AppComponent):UserRegistrationComponent
    }

}