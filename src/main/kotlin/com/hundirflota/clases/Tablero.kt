package com.hundirflota.clases

class Tablero {

    fun checkDisparo(x: Int, y: Int): Char {
        if (this.tablero[x][y] != guion) {
            println("Tocado")
            setPosicionesBarcos(getPosicionesBarcos() - 1)
            return this.tablero[x][y]
        } else {
            println("Agua")
            return arroba
        }
    }
}