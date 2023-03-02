package com.hundirflota.clases

class Tablero {


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