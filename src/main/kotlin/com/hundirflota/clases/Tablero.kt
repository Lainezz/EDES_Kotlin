package com.hundirflota.clases

class Tablero {
    private var NFILAS = 10
    private var NCOLS = 10
    private var guion:Char =45
    private var arroba:Char = 64
    private var posicionesBarcos:Int

    fun Tablero() {
        this.tablero = Array<CharArray>(NFILAS) { CharArray(NCOLS) }
        setPosicionesBarcos(0)
        llenarTableroVacio()
    }

}