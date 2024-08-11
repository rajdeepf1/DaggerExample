package com.example.daggerexample

import android.util.Log
import javax.inject.Inject


interface NotificationService{
    fun send(to: String, from: String, body: String?)
}

class EmailService @Inject constructor() : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d("EmailService",  "Email Sent")
    }
}

class MessageService @Inject constructor(private val count : Int) : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d("MessageService", "Message Sent ${count}")
    }

}