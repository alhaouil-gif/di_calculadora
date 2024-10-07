package com.example.appmusica

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Orientador()
        }
    }
}




@Composable
fun Orientador() {

    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {

            Apaisada()
        }
        Configuration.ORIENTATION_PORTRAIT -> {

            AppPrincipal()
        }
    }
}
@Composable
fun AppPrincipal() {
    var barraVolumen by remember { mutableStateOf(0.7f) }
    val maxVolume = 1f
    var sliderPosition by remember { mutableStateOf(0f) }
    val maxDuration = 177f
    val progrsoReproduccion = maxDuration * 0.25f
    sliderPosition = progrsoReproduccion

    EstablecerFondoPantalla()

    Column (
        modifier = Modifier.fillMaxSize() .padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

            ){
            Image(
                painter = painterResource(id=R.drawable.imagendisco2),
                contentDescription = "Imagen del disco",
                modifier = Modifier .size(300.dp).clip(CircleShape),
                 contentScale = ContentScale.Crop

        )


        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
       Text(
           text = "Arena caliente",
           fontSize = 30.sp,
           fontWeight = FontWeight.Bold,
           color = Color.White,
           modifier = Modifier.padding(16.dp)

       )
        }
        Spacer(modifier = Modifier.height(0.dp))

        Row (
            modifier = Modifier .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "La Gripe",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(10.dp)

            )
            Spacer(modifier = Modifier.height(60.dp))



        }


        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){

            Icon(
                painter = painterResource(id = R.drawable.botoncompartir),
                contentDescription = "Previous",
                modifier = Modifier
                    .size(64.dp)
                    .clickable {
                     },
                tint = Color.Yellow
            )
            Spacer(modifier = Modifier.width(60.dp))

            Icon(
                painter = painterResource(id = R.drawable.botonlistacanciones),
                contentDescription = "Previous",
                modifier = Modifier

                    .size(64.dp)
                    .clickable {
                     },
                tint = Color.Yellow

                )
            Spacer(modifier = Modifier.width(60.dp))

            Icon(
                painter = painterResource(id = R.drawable.botonletra),
                contentDescription = "Previous",

                modifier = Modifier
                    .size(64.dp)
                    .clickable {
                     },
                tint = Color.Yellow

            )



        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            Slider(
                 value = sliderPosition,
                onValueChange = {                },
                valueRange = 0.5f..maxDuration ,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row (
            modifier = Modifier .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "0:44",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(10.dp)

            )
            Spacer(modifier = Modifier.width(180.dp))
            Text(
                text = "02:13",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(10.dp)

            )


        }
        Row(
            modifier = Modifier .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.botonanterior),
                contentDescription = "Previous",
                modifier = Modifier
                    .size(64.dp)
                    .clickable {
                     },
                tint = Color.Yellow

            )
            Spacer(modifier = Modifier.width(60.dp))

            PlayPauseButton()
            Spacer(modifier = Modifier.width(60.dp))

            Icon(
                painter = painterResource(id = R.drawable.botonsiguiente),
                contentDescription = "Next",
                modifier = Modifier
                    .size(64.dp)
                    .clickable {
                     },
                tint = Color.Yellow

            )
        }
        Row (){
            Icon(
                painter = painterResource(id = R.drawable.botonvolumen),
                contentDescription = "botoncompartir",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                    },
                tint = Color.Yellow

            )
            Slider(
                value = barraVolumen,
                onValueChange = { newValue ->
                    barraVolumen = newValue
                },
                valueRange = 0f..maxVolume,
                modifier = Modifier.width(200.dp)
            )




        }




    }

}





@Composable
fun PlayPauseButton() {
    var isPlaying by remember { mutableStateOf(false) }
    val icon = if (isPlaying) {
        painterResource(id = R.drawable.botonpausa)
    } else {
        painterResource(id = R.drawable.botonplay)
    }
    Icon(
        painter = icon,
        contentDescription = if (isPlaying) "Pause" else "Play",
        modifier = Modifier
            .size(64.dp)
            .clickable {
                isPlaying = !isPlaying },
        tint = Color.Yellow)
}





@Preview(device = "spec:parent=pixel_5,orientation=landscape")

@Composable
fun Apaisada() {
    var barraVolumen by remember { mutableStateOf(0.7f) }
    val maxVolume = 1f
    var sliderPosition by remember { mutableStateOf(0f) }
    val maxDuration = 177f
    val progrsoReproduccion = maxDuration * 0.25f
    sliderPosition = progrsoReproduccion

    EstablecerFondoPantalla()

    Row(
        modifier = Modifier.fillMaxSize() ,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id=R.drawable.imagendisco2),
            contentDescription = "Imagen del disco",
            modifier = Modifier .size(300.dp).clip(CircleShape),
            contentScale = ContentScale.Crop

        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        )

        {
             Row(modifier = Modifier.height(50.dp) ){
            Text(
                text = "Arena caliente",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,



            )
                 Spacer(modifier = Modifier.width(80.dp))



                Text(
                    text = "La gripe",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,


                    )}
            Spacer(modifier = Modifier.height(60.dp))

            Row( modifier = Modifier.height(40.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                Icon(
                    painter = painterResource(id = R.drawable.botoncompartir),
                    contentDescription = "botoncompartir",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable {
                         },
                    tint = Color.Yellow

                )
                Spacer(modifier = Modifier.width(80.dp))
                Icon(
                    painter = painterResource(id = R.drawable.botonlistacanciones),
                    contentDescription = "botonlistacanciones",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable {
                         },
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(80.dp))

                Icon(
                    painter = painterResource(id = R.drawable.botonletra),
                    contentDescription = "botonletra",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable {
                         },
                    tint = Color.Yellow
                )

            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center)
            {

                Slider(
                    value = sliderPosition,
                    onValueChange = {                },
                    valueRange = 0.5f..maxDuration ,
                    modifier = Modifier.width(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.height(30.dp)) {
                Text(
                    text = "00:44",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    )
                Spacer(modifier = Modifier.width(120.dp))
                Text(
                    text = "02:13",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(   modifier = Modifier.height(40.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Icon(
                    painter = painterResource(id = R.drawable.botonanterior),
                    contentDescription = "botonanterior",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable {
                         },
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(80.dp))
                PlayPauseButton()
                Spacer(modifier = Modifier.width(80.dp))
                Icon(
                    painter = painterResource(id = R.drawable.botonsiguiente),
                    contentDescription = "botonsiguiente",
                    modifier = Modifier
                        .size(64.dp)
                        .clickable {
                            // Acción del botón "Previous"
                        },
                    tint = Color.Yellow
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center)
            {
                Icon(
                    painter = painterResource(id = R.drawable.botonvolumen),
                    contentDescription = "botoncompartir",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                         },
                    tint = Color.Yellow

                )
                Slider(
                    value = barraVolumen,
                    onValueChange = { newValue ->
                        barraVolumen = newValue // Actualiza el valor del slider
                    },
                    valueRange = 0f..maxVolume, // El rango de valores del slider (0 a 100%)
                    modifier = Modifier.width(200.dp)
                )




            }

         }

      }
}









@Composable
fun EstablecerFondoPantalla() {
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(
                    painter= painterResource(id=R.drawable.imgfondo),
                    contentDescription = "Fondo de pantalla",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
        )
    }


}

