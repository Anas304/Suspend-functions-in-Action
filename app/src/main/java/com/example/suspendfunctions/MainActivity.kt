package com.example.suspendfunctions

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.suspendfunctions.ui.theme.SuspendFunctionsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuspendFunctionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        GlobalScope.launch(Dispatchers.IO) {
              Task1()
              Task2()
        }



    }
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun Task1(){
    val result : Deferred<String> = GlobalScope.async {
        DoSomethingOnce()
    }
    val value : String = runBlocking {
        result.await()
    }
    Log.d(TAG,value)
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun Task2(){
    val result : Deferred<String> = GlobalScope.async {
        DoSomethingTwice()
    }
    val value : String = runBlocking {
        result.await()
    }
    Log.d(TAG,value)
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
    SuspendFunctionsTheme {
        Greeting("Android")
    }
}