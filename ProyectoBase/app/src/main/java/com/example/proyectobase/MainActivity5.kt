package com.example.proyectobase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectobase.utils.Convertidor
class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        val pesos = findViewById<android.widget.EditText>(R.id.ed_peso)
        val dolares = findViewById<android.widget.TextView>(R.id.tv_dolar)
        val btnConvertir = findViewById<android.widget.Button>(R.id.btn_calcular)
        btnConvertir.setOnClickListener {
            val valorPesos = pesos.text.toString().toDoubleOrNull() ?: 0.0
            val valorDolares = Math.round(Convertidor.PesosDolares(valorPesos,971.72) * 100) / 100.0
            dolares.text = "USD $valorDolares"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}