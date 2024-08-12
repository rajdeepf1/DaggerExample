package com.example.daggerexample

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.daggerexample.ui.theme.DaggerExampleTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userRegistrationService :UserRegistrationService

    //@Inject
    lateinit var emailService: EmailService

    //@Inject
    lateinit var emailService1: EmailService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val component = DaggerUserRegistrationComponent
//            //.builder()
////            .notificationServiceModule(NotificationServiceModule(3))
//            //.build()
//            .factory().create(3)  // Passing value through Factory

//        val userRegistrationService = component.getUserRegistrationService()
//        val emailService = component.getEmailService()
        // or

        // Now we are creating this object from application scope, so these objects will same
        //val component = (application as UserApplication).userRegistrationComponent

        val appComponent = (application as UserApplication).appComponent
        //val userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(3,appComponent)
        val userRegistrationComponent = appComponent.getUserRegistrationComponentFactory().create(3)
        emailService = userRegistrationComponent.getEmailService()
        emailService1 = userRegistrationComponent.getEmailService()

        Log.d("emailService", "onCreate: ${emailService}")
        Log.d("emailService1", "onCreate: ${emailService1}")

        //component.inject(this)
        userRegistrationComponent.inject(this)
        userRegistrationService.registerUser("rajdeepf1@gmail.com","123")

        enableEdgeToEdge()
        setContent {
            DaggerExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerExampleTheme {
        Greeting("Android")
    }
}