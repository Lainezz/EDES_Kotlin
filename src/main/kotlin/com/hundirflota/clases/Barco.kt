package com.hundirflota.clases

class Barco(nombre: String, ini: Char, tamanio: Int) {

    private fun colocarBarco(barco : Barco){
        when(barco.ini){
            "L"->colocarL(barco)
            "B","Z"->colocarHorizontal(barco)
            "P"->colocarVertical(barco)
            else-> imprimirError("Barco erróneo")
        }
    }
}