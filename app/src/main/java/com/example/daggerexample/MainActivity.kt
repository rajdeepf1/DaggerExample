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
import androidx.lifecycle.ViewModelProvider
import com.example.daggerexample.ui.theme.DaggerExampleTheme
import com.example.daggerexample.viewmodels.MainViewModel
import com.example.daggerexample.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as FakerApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this,{
            Log.d("MainActivity", "onCreate: ${it}")
        })
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