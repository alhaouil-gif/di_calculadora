package com.example.calculadora

import androidx.compose.foundation.shape.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.platform.LocalConfiguration
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border




 class MainActivity : ComponentActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContent {
            CalculadoraCompose()
        }
    }
}

@Preview

@Composable
 fun CalculadoraCompose() {

    var displayText by remember { mutableStateOf("") }
    val buttonLabels = listOf(
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
        "+", "-", "%", "÷", "×", "+/-", ".", "C"
    )

    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            LandscapeScreenComposition(displayText, buttonLabels) { label ->
                displayText = handleButtonClick(label, displayText)
            }
        }

        else -> {
            VerticalScreenComposition(displayText, buttonLabels) { label ->
                displayText = handleButtonClick(label, displayText)
            }
        }
    }

}
 @Composable
fun VerticalScreenComposition(displayText: String, buttonLabels: List<String>, onButtonClick: (String) -> Unit) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = displayText,
                fontSize = 32.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(bottom = 16.dp)

            )
        }

        items(buttonLabels.chunked(3)) { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for (label in row) {
                    Button(
                        onClick = { onButtonClick(label) },
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(2f),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black
                        )
                    ) {
                        Text(text = label)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Button(
                onClick = { onButtonClick("=") },
                modifier = Modifier
                    .aspectRatio(5f)
                    .padding(top = 10.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(text = "=")
            }
        }
    }
}

@Composable
fun LandscapeScreenComposition(displayText: String, buttonLabels: List<String>, onButtonClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)

    ) {
         Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f).padding(end = 16.dp)
        ) {
            Text(
                text = displayText,
                fontSize = 28.sp,
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .height(280.dp)
                    .border(2.dp,Color.Black)
                    //.background(Color.Yellow)


            )
        }

         LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            items(buttonLabels.chunked(6)) { row ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (label in row) {

                        Button(
                            onClick = { onButtonClick(label) },
                            modifier = Modifier

                                .weight(1f)

                                .aspectRatio(1f),
                            // Botones cuadrados
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black

                            )

                        ) {
                            Text(text = label)



                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Button(
                    onClick = { onButtonClick("=") },
                    modifier = Modifier
                        .aspectRatio(5f)
                        .padding(top = 10.dp),

                shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    )
                ) {
                    Text(text = "=")

                }
            }
        }
    }
}

fun handleButtonClick(label: String, currentText: String): String {
    return when (label) {
        "C" -> ""
        else -> currentText + label
    }
}
