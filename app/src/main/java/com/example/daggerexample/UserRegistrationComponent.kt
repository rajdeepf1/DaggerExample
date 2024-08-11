package com.example.daggerexample

import dagger.Component

@Component(modules = arrayOf(UserRepositoryModule::class,NotificationServiceModule::class))
interface UserRegistrationComponent {
//    fun getUserRegistrationService() : UserRegistrationService
//    fun getEmailService() : EmailService
    //or

    fun inject(mainActivity: MainActivity)
}