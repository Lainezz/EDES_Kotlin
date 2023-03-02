package com.hundirflota.clases

class Tablero {
 fun llenarTableroVacio(){

    for (i in 0 .. tablero.size){
         for ( j in 0 .. this.tablero[i].length) {
         this.tablero[i][j] = guion }

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