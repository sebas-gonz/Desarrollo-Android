package com.example.proyectobase

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        val ed_fechaNacimiento: EditText = findViewById(R.id.ed_fecha_nacimiento)
        val ed_nombre: EditText = findViewById(R.id.ed_nombre)
        val ed_apellido: EditText = findViewById(R.id.ed_apellido)
        val btn_guardar: Button = findViewById(R.id.btn_guardar)

        ed_fechaNacimiento.setOnClickListener {
            val c = Calendar.getInstance()
            val anio = c.get(Calendar.YEAR)
            val mes = c.get(Calendar.MONTH)
            val dia = c.get(Calendar.DAY_OF_MONTH)

            val calendario =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val fecha = "%02d/%02d/%04d".format(selectedDay, selectedMonth + 1, selectedYear)
                ed_fechaNacimiento.setText(fecha)
            }, anio, mes, dia)

            calendario.show()
        }


        btn_guardar.setOnClickListener {
            var nombre = ed_nombre.text.toString()
            var apellido = ed_apellido.text.toString()
            var fechaNacimiento = ed_fechaNacimiento.text.toString()

            val tx_nombre: TextView = findViewById(R.id.tx_nombre)
            val tx_apellido: TextView = findViewById(R.id.tx_apellido)
            val tx_fechaNacimiento: TextView = findViewById(R.id.tx_fecha_nacimiento)
            tx_nombre.text = nombre
            tx_apellido.text = apellido
            tx_fechaNacimiento.text = fechaNacimiento

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}