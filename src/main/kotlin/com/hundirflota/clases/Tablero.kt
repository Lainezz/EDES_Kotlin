package com.hundirflota.clases

class Tablero {
 fun llenarTableroVacio(){



        /*
    TODO: PATRICIO
     */
    /**
     * Método para mostrar el tablero por pantalla
     */
    fun mostrarTablero() {

        // Imprimo dos espacios
        System.out.print("  ")

        // La letra A en decimal es el numero 65
        var letra = 65
        for (i in 0 until NCOLS) {
            System.out.format("%2c", letra.toChar())
            letra++
        }
        // Imprimo un salto de linea
        System.out.println()

        // Procedo a mostrar el contenido de mi tablero
        for (i in 0 until tablero.length) {
            // Primero imprimo el numero de linea
            System.out.format("%2d", i + 1)
            for (j in 0 until tablero.get(i).length) {
                System.out.format("%2c", this.tablero.get(i).get(j))
            }
            // Al terminar la fila, imprimo un salto de línea
            System.out.println()
        }
        System.out.flush()

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
=======
    fun checkDisparo(x: Int, y: Int): Char {
        if (this.tablero[x][y] != guion) {
            println("Tocado")
            setPosicionesBarcos(getPosicionesBarcos() - 1)
            return this.tablero[x][y]
        } else {
            println("Agua")
            return arroba

    private fun colocarLancha(lancha: Barco) {
>>>>>>> beb366338afd4f79c8668dd7f75ebd834209f939
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

<<<<<<< HEAD
=======
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

>>>>>>> beb366338afd4f79c8668dd7f75ebd834209f939
}