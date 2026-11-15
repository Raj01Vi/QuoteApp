package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.ui.theme.QuoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "The best way to predict the future is to create it!",
        fontSize = 28.sp,
        modifier = modifier
    )
}

@Composable
fun QuoteScreen(modifier: Modifier = Modifier) {
    val quotes = listOf(
        "Funny how you can live a whole life waiting and not know it",
        "It's easier to keep a desire out than to get it out once it's in.",
        "All great and precious things are lonely.",
        "It was the best of times, it was the worst of times.",
        "You've never been tested, so nobody will ever know what you're made of, not even you.",
        "No one suffers both hard and long. Pain is either bearable or short.",
        "I was with them yet I was alone.",
        "You can return to a place, but you can never return to a moment.",
        "No night is long enough for us to dream twice.",
        "How poetic was God when he made her eyes.",
        "In case you ever foolishly forget: I am never not thinking of you.",
        "Nothing is so painful to the human mind as a great and sudden change."
    )
var currentQuote by remember { mutableStateOf(quotes.random()) }

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally) {
        Text(
            text = currentQuote,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {currentQuote = quotes.random()}) {
            Text("Show me Another")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteAppTheme {
        Greeting("Android")
    }
}