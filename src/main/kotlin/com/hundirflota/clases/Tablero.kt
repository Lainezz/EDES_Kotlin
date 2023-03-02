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