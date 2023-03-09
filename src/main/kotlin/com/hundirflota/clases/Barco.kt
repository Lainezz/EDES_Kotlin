package com.hundirflota.clases

class Barco {


    /*
    TODO: SARA
     */
    /*public char getIni() {
        return ini;
    }

    public void setIni(char ini) throws IllegalArgumentException{
        for (char c : listaAdmitidos) {
            if(c == ini) {
                this.ini = ini;
                break;
            }
        }
        if(this.ini != ini) throw new IllegalArgumentException("Inicial no admitida");

        //Si se ha establecido la inicial correctamente, establecemos el nombre y el tamanio del Barco
        setNombre(ini);
        setTamanio(ini);
    }

    public int getTamanio() {
        return tamanio;
    }

    private void setTamanio(char ini) {
        switch (ini) {
            case 'L': {
            this.tamanio = 1;
            break;
        }
            case 'B': {
            this.tamanio = 3;
            break;
        }
            case 'Z': {
            this.tamanio = 4;
            break;
        }
            case 'P': {
            this.tamanio = 5;
            break;
        }
            default:
            throw new IllegalArgumentException("Unexpected value: " + ini);
        }
    }*/


    /*
    TODO: PABLO
     */
    private var nombre: String = null
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

}