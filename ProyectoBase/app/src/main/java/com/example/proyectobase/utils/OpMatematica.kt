package com.example.proyectobase.utils

object OpMatematica {

    fun dividir(num1: Double, num2: Double): Double {
        return try {
            num1 / num2
        } catch (a : ArithmeticException){
            println("Error aritmetico no se puede dividir por cero")
            0.0
        }
    }
}