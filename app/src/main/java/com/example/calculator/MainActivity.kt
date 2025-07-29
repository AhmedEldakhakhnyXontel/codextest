package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CalculatorApp()
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var currentInput by remember { mutableStateOf("") }
    var sum by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Sum: $sum", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        Digits(onDigit = { digit ->
            currentInput += digit
        })

        Spacer(Modifier.height(16.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                val value = currentInput.toIntOrNull() ?: 0
                sum += value
                currentInput = ""
            }, modifier = Modifier.weight(1f)) {
                Text("+")
            }
            Button(onClick = { currentInput = ""; sum = 0 }, modifier = Modifier.weight(1f)) {
                Text("Clear")
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(text = "Current input: $currentInput")
    }
}

@Composable
fun Digits(onDigit: (String) -> Unit) {
    val rows = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("0")
    )
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (row in rows) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                for (digit in row) {
                    Button(onClick = { onDigit(digit) }, modifier = Modifier.weight(1f)) {
                        Text(digit)
                    }
                }
                if (row.size < 3) {
                    repeat(3 - row.size) {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
