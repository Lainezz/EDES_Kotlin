package com.hundirflota.clases

class Barco(nombre: String, ini: Char, tamanio: Int) {

    fun getIni(): Char {
        return ini
    }

    @kotlin.Throws(IllegalArgumentException::class)
    fun setIni(ini: Char) {
        for (c in listaAdmitidos) {
            if (c == ini) {
                ini = ini
                break
            }
        }
        if (ini !== ini) throw IllegalArgumentException("Inicial no admitida")

        //Si se ha establecido la inicial correctamente, establecemos el nombre y el tamanio del Barco
        setNombre(ini)
        setTamanio(ini)
    }

    fun getTamanio(): Int {
        return tamanio
    }

    private fun setTamanio(ini: Char) {
        when (ini) {
            'L' -> {
                this.tamanio = 1
            }

            'B' -> {
                this.tamanio = 3
            }

            'Z' -> {
                this.tamanio = 4
            }

            'P' -> {
                this.tamanio = 5
            }

            else -> throw IllegalArgumentException("Unexpected value: $ini")
    private fun colocarBarco(barco : Barco){
        when(barco.ini){
            "L"->colocarL(barco)
            "B","Z"->colocarHorizontal(barco)
            "P"->colocarVertical(barco)
            else-> imprimirError("Barco erróneo")
        }
    }
}