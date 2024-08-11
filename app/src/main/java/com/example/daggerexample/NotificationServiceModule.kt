package com.example.daggerexample

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule(private val count : Int) {

    //@Named("message") //Qualifier
    @MessageQualifier //custom qualifier made by me
    @Provides
    fun getMessageService() : NotificationService{
        return  MessageService(count)
    }
    @Named("email") //Qualifierx
    @Provides
    fun getEmailService() : NotificationService{
        return  EmailService()
    }

}