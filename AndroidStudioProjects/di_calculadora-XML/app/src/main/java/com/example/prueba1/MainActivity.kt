package com.example.prueba1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.TextView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView = findViewById(R.id.textView)

        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString("textViewContent", "")
        }

        val buttonIds = arrayOf(
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button0,
            R.id.buttonSuma,
            R.id.buttonResta,
            R.id.buttonSigno,
            R.id.buttonPorcentaje,
            R.id.buttonDivision,
            R.id.buttonMultiplicacion,
            R.id.buttonComa,
            R.id.buttonC,
            R.id.buttonIgual
        )

        for (id in buttonIds) {
            val button = findViewById<Button>(id)
            button.setOnClickListener {
                if (id == R.id.buttonC) {
                    textView.text = ""
                } else {
                    textView.append(button.text.toString())
                }
            }
        }
    }

    // Guardar el estado del TextView antes de rotar la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textViewContent", textView.text.toString())
    }

    // No es necesario implementar onRestoreInstanceState, ya que se maneja en onCreate
}
