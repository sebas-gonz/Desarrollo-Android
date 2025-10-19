package com.example.proyectobase.utils

object Regex {
    fun Regex(cadena: String): Boolean{
        val regex = "[a-zA-Z]@duocuc.cl".toRegex()
        return regex.matches(cadena)
    }

}