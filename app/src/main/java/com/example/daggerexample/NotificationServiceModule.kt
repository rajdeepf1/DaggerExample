package com.example.daggerexample

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class NotificationServiceModule {

    //@Named("message") //Qualifier
    @Singleton
    @MessageQualifier //custom qualifier made by me
    @Provides
    fun getMessageService(count : Int) : NotificationService{
        return  MessageService(count)
    }

    @Named("email") //Qualifierx
    @Provides
    fun getEmailService() : NotificationService{
        return  EmailService()
    }

}