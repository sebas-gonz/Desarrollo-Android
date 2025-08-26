package com.example.proyectobase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val ed_num1 = findViewById<android.widget.EditText>(R.id.ed_num1)
        val ed_num2 = findViewById<android.widget.EditText>(R.id.ed_num2)
        val btn_sumar = findViewById<android.widget.Button>(R.id.btn_calcular)
        val tx_resultado = findViewById<android.widget.TextView>(R.id.tx_resultado)

        btn_sumar.setOnClickListener {
            val num1 = ed_num1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = ed_num2.text.toString().toDoubleOrNull() ?: 0.0
            val resultado = num1 + num2
            tx_resultado.text = "Resultado: $resultado"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}