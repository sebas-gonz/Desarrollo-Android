package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)
        val opcionesLv : ListView = findViewById(R.id.lv_listview);
        val opciones = arrayOf("Sumar","Restar","Multiplicar","Dividir","Hola mundo");
        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones);
        opcionesLv.adapter = adaptador;

        opcionesLv.setOnItemClickListener { parent,view,position,id ->
            val itemElegido = parent.getItemAtPosition(position).toString()

            Toast.makeText(this,itemElegido,Toast.LENGTH_LONG).show()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}