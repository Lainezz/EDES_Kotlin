package com.hundirflota.clases

class Tablero {
 fun llenarTableroVacio(){

    for (i in 0 .. tablero.size){
         for ( j in 0 .. this.tablero[i].length) {
         this.tablero[i][j] = guion }

 }

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

    private fun colocarHorizontal(barco: Barco) {
        val rand = Random()
        var x: Int
        var auxX: Int
        var y: Int
        var auxY: Int
        var colocado = false
        var libre: Boolean
        while (!colocado) {
            //Variable para controlar si las posiciones estan libres
            libre = true

            //Variables de posicion
            x = rand.nextInt(9)
            y = rand.nextInt(9)

            //Ajustamos y para que no nos de excepcion
            while (y + barco.getTamanio() > 10) {
                y--
            }

            //Variables auxiliares que usaremos para comprobar si las posiciones estan libres
            auxX = x
            auxY = y

            //Primero deberiamos comprobar si las posiciones para insertar el barco estan libres
            for (i in 0 until barco.getTamanio()) {
                if (comprobarSiLibre(auxX, auxY)) {
                    //Como nos movemos horizontalmente, incrementamos Y
                    auxY++
                } else {
                    libre = false
                    break
                }
            }

            //Si las posiciones están libres, colocamos el barco sin miedo
            if (libre) {
                for (i in 0 until barco.getTamanio()) {
                    this.tablero.get(x).get(y) = barco.getIni()
                    y++
                }
                colocado = true
            }
        }
    }

}