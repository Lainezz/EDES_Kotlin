package com.hundirflota.clases

class Tablero {

    private val NFILAS = 10
    private val NCOLS = 10
    private val guion:Char =45
    private val arroba:Char = 64
    private val posicionesBarcos = 0
    fun Tablero() {
        this.tablero = Array<CharArray>(NFILAS) { CharArray(NCOLS) }
        setPosicionesBarcos(0)
        llenarTableroVacio()
    }



        private fun colocarLancha(lancha: Barco) {
        val random = Random()
        var x = 0
        var y = 0
        var colocado = false
        while (!colocado) {
            x = random.nextInt(9)
            y = random.nextInt(9)
            if (comprobarSiLibre(x, y)) {
                this.tablero.get(x).get(y) = lancha.getIni()
                colocado = true
            }
        }
    }
}