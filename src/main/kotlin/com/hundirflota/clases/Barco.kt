package com.hundirflota.clases

class Barco {


    /*
    TODO: SARA
     */
    open fun getIni(): Char {
        return ini
    }

    @kotlin.Throws(IllegalArgumentException::class)
    fun setIni(ini: Char) {
        for (c in listaAdmitidos) {
            if (c == ini) {
                ini == ini
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
        }
    }

    /*
    TODO: PABLO
     */
    private var nombre: String = ' '
    private var ini: Char = ' '
    private var tamanio: Int = 0

    private val listaAdmitidos = charArrayOf('L', 'B', 'Z', 'P')

    /*
    TODO: RUBEN
     */
    /**
     * Constructor principal de clase
     * @param ini
     */
    /*
    public Barco(char ini) {
        setIni(ini);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(char ini) {
        switch (ini) {
            case 'L': {
            this.nombre = "Lancha";
            break;
        }
            case 'B': {
            this.nombre = "Buque";
            break;
        }
            case 'Z': {
            this.nombre = "Acorazado";
            break;
        }
            case 'P': {
            this.nombre = "Porta-Aviones";
            break;
        }
            default:
            throw new IllegalArgumentException("Unexpected value: " + ini);
        }
    }
    */
    fun Barco(ini: Char) {
            setIni(ini)
    }

    fun getNombre(): String {
        return nombre
    }

    private fun setNombre(ini: Char) {
        when (ini) {
            "L" -> {
                this.nombre = "Lancha"
            }

            "B" -> {
                this.nombre = "Buque"
            }

            "Z" -> {
                this.nombre = "Acorazado"
            }

            "P" -> {
                this.nombre = "Porta-Aviones"
            }

            else -> throw IllegalArgumentException("Unexpected value: $ini")
        }
    }

}