package com.example.daggerexample

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
//    fun getUserRegistrationService() : UserRegistrationService
//    fun getEmailService() : EmailService

    //or

    fun inject(mainActivity: MainActivity)

    fun getEmailService() : EmailService

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance count : Int):UserRegistrationComponent
    }

}