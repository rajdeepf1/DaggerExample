package com.example.daggerexample

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepositoryService: UserRepositoryService,
    private val notificationService: NotificationService
){

    fun registerUser(email: String, password: String) {
        userRepositoryService.saveUser(email, password)
        notificationService.send (email, "no-reply@cheezycode.com", "User Registered")
    }

}