package com.example.appmusica

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var botonPlayPause: ImageButton
    private lateinit var botonSiguiente: ImageButton
    private lateinit var botonAnterior: ImageButton
    private lateinit var barraVolumen: SeekBar
    private lateinit var tiempoActual: TextView
    private lateinit var tiempoRestante: TextView
    private lateinit var seekBar: SeekBar

    private lateinit var botonCompartir: ImageButton
    private lateinit var botonletra: ImageButton
    private lateinit var botonLista: ImageButton

    private lateinit var botonVolume: ImageButton


    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)
        botonVolume = findViewById(R.id.botonVolume)

        botonPlayPause = findViewById(R.id.botonPlay)
        botonSiguiente = findViewById(R.id.imageButton2)
        botonAnterior = findViewById(R.id.imageAnterior)
        barraVolumen = findViewById(R.id.barravolumen)
        tiempoActual = findViewById(R.id.tiempoActual)
        tiempoRestante = findViewById(R.id.tiemporestante)

        botonCompartir = findViewById(R.id.imageCompartir)
        botonletra = findViewById(R.id.imageButton12)
        botonLista = findViewById(R.id.imageButton8)



        seekBar.progress = 25
        seekBar.max = 100
        barraVolumen.progress = 70
        barraVolumen.max = 100

         botonPlayPause.setOnClickListener {
            isPlaying = !isPlaying
            if (isPlaying) {
                 botonPlayPause.setImageResource(android.R.drawable.ic_media_play)
             } else {
                 botonPlayPause.setImageResource(android.R.drawable.ic_media_pause)
             }
        }

         botonAnterior.setOnClickListener {
             Snackbar.make(it, "Botón siguiente presionado", Snackbar.LENGTH_SHORT).show()

         }

        botonSiguiente.setOnClickListener {
            Snackbar.make(it, "Botón anterior presionado", Snackbar.LENGTH_SHORT).show()

        }

             botonCompartir.setOnClickListener {
                 Snackbar.make(it, "Botón compartir  presionado", Snackbar.LENGTH_SHORT).show()


             }

        botonletra.setOnClickListener {
            Snackbar.make(it, "Botón letra presionado", Snackbar.LENGTH_SHORT).show()

        }

          botonLista.setOnClickListener {
              Snackbar.make(it, "Botón lista presionado", Snackbar.LENGTH_SHORT).show()

          }


        botonVolume.setOnClickListener {
            Snackbar.make(it, "Botón volumen presionado", Snackbar.LENGTH_SHORT).show()

        }


    }
}
