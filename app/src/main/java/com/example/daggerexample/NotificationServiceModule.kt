package com.example.daggerexample

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule {

    @Named("message") //Qualifier
    @Provides
    fun getMessageService() : NotificationService{
        return  MessageService()
    }
    @Named("email") //Qualifier
    @Provides
    fun getEmailService() : NotificationService{
        return  EmailService()
    }

}