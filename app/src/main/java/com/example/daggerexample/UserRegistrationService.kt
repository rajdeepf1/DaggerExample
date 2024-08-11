package com.example.daggerexample

import javax.inject.Inject
import javax.inject.Named
// @Named Qualifier
// @Named("message")
// @MessageQualifier a custom qualifier made by me
class UserRegistrationService @Inject constructor(
    private val userRepositoryService: UserRepositoryService,
    @MessageQualifier private val notificationService: NotificationService
){

    fun registerUser(email: String, password: String) {
        userRepositoryService.saveUser(email, password)
        notificationService.send (email, "no-reply@cheezycode.com", "User Registered")
    }

}