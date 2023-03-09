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


    /*
    TODO: DANIEL
     */
    /**
     * Coloca una lancha dentro del tablero de juego
     * @param lancha - Objeto de tipo barco que debe ser una lancha
     */
    /*private void colocarL(Barco lancha) {
        Random rand = new Random();

        int x;
        int y;

        boolean colocado = false;
        while (!colocado) {
            x = rand.nextInt(9);
            y = rand.nextInt(9);

            if (comprobarSiLibre(x, y)) {
                this.tablero[x][y] = lancha.getIni();
                colocado = true;
            }
        }
    }*/




    /*
    TODO: ELOY
     */
    /**
     * Método que recibe por parámetros un objeto de tipo barco y lo coloca horizontalmente en el tablero
     * @param barco
     */
    /*private void colocarHorizontal(Barco barco) {
        Random rand = new Random();

        int x, auxX;
        int y, auxY;

        boolean colocado = false;
        boolean libre;
        while (!colocado) {
            //Variable para controlar si las posiciones estan libres
            libre = true;

            //Variables de posicion
            x = rand.nextInt(9);
            y = rand.nextInt(9);

            //Ajustamos y para que no nos de excepcion
            while(y+barco.getTamanio()>10) {
                y--;
            }

            //Variables auxiliares que usaremos para comprobar si las posiciones estan libres
            auxX = x;
            auxY = y;

            //Primero deberiamos comprobar si las posiciones para insertar el barco estan libres
            for(int i=0; i<barco.getTamanio(); i++) {
                if (comprobarSiLibre(auxX, auxY)) {
                    //Como nos movemos horizontalmente, incrementamos Y
                    auxY++;
                } else {
                    libre = false;
                    break;
                }
            }

            //Si las posiciones están libres, colocamos el barco sin miedo
            if(libre) {
                for(int i=0; i<barco.getTamanio(); i++) {
                    this.tablero[x][y] = barco.getIni();
                    y++;
                }
                colocado = true;
            }
        }
        System.out.flush();
    }*/

    private fun colocarHorizontal(barco:Barco){
        var colocado = false
        var libre : Boolean
        while (!colocado){
            //Variable para controlar si las posiciones estan libres
            libre = true
            //Variables de posicion
            var x = (0..9).random()
            var y = (0..9).random()

            //Ajustamos y para que no nos de excepcion
            while (y+barco.getTamanio()>10){
                y--
            }

            //Variables auxiliares que usaremos para comprobar si las posiciones estan libres
            var auxX = x
            var auxY = y

            //Primero deberiamos comprobar si las posiciones para insertar el barco estan libres
            for(i in 1..barco.tamanio){
                if (comprobarSiLibre(auxX, auxY)){
                    //Como nos movemos horizontalmente, incrementamos Y
                    auxY++
                }else {
                    libre = false
                    break
                }
            }

            //Si las posiciones están libres, colocamos el barco sin miedo
            if (libre){
                for (i in 1..barco.tamanio){
                    this.tablero[x][y] = barco.ini
                }
                colocado = true
            }
        }
    }

    /*
    TODO: JOSE MANUEL
     */
    /**
     * Metodo que coloca un barco verticalmente
     */
        private fun colocarVertical(barco: Barco) {
            var rand = (0..10).random()
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
                x = rand
                rand = (0..10).random()
                y = rand

                //Ajustamos y para que no nos de excepcion
                while (x + barco.getTamanio() > 10) {
                    x--
                }

                //Variables auxiliares que usaremos para comprobar si las posiciones estan libres
                auxX = x
                auxY = y

                //Primero deberiamos comprobar si las posiciones para insertar el barco estan libres
                for (i in 0 until barco.getTamanio()) {
                    if (comprobarSiLibre(auxX, auxY)) {
                        //Como nos movemos verticalmente, incrementamos X
                        auxX++
                    } else {
                        libre = false
                        break
                    }
                }

                //Si las posiciones están libres, colocamos el barco sin miedo
                if (libre) {
                    for (i in 0 until barco.getTamanio()) {
                        this.tablero.get(x).get(y) = barco.getIni()
                        x++
                    }
                    colocado = true
                }
            }
        }




    /*
    TODO: PATRICIO
     */
    /**
     * Método para mostrar el tablero por pantalla
     */
    /*public void mostrarTablero() {

        // Imprimo dos espacios
        System.out.print("  ");

        // La letra A en decimal es el numero 65
        int letra = 65;
        for (int i = 0; i < NCOLS; i++) {
            System.out.format("%2c", (char) letra);
            letra++;
        }
        // Imprimo un salto de linea
        System.out.println();

        // Procedo a mostrar el contenido de mi tablero
        for (int i = 0; i < tablero.length; i++) {
            // Primero imprimo el numero de linea
            System.out.format("%2d", i + 1);
            for (int j = 0; j < tablero[i].length; j++) {
            System.out.format("%2c", this.tablero[i][j]);
        }
            // Al terminar la fila, imprimo un salto de línea
            System.out.println();
        }
        System.out.flush();
    }*/

    open fun mostrarTablero() {

        // Imprimo dos espacios
        print("  ")

        // La letra A en decimal es el numero 65
        var letra = 65
        for (i in 0 until NCOLS) {
            System.out.format("%2c", letra.toChar())
            letra++
        }
        // Imprimo un salto de linea
        println()

        // Procedo a mostrar el contenido de mi tablero
        for (i in 0 until tablero.length) {
            // Primero imprimo el numero de linea
            System.out.format("%2d", i + 1)
            for (j in 0 until tablero.get(i).length) {
                System.out.format("%2c", this.tablero.get(i).get(j))
            }
            // Al terminar la fila, imprimo un salto de línea
            println()
        }
        System.out.flush()
    }



    /*
    TODO: DIEGO
     */
    /**
     * Llena el tablero de juego con guiones, es decir, lo rellena vacio.
     */
    /*public void llenarTableroVacio() {

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
            this.tablero[i][j] = guion;
        }
        }
    }*/

    fun llenarTableroVacio() {
        //Funcion que llena el tablero con guiones segun el tamaño que tenga,empezando desde 0
        // hasta la longitud maxima establecida en el tablero.
        // Guion es una variable ya establecida.
        for (i in 0..this.tablero.size) {
            for (j in 0..this.tablero[i].length) {
                this.tablero[i][j] = guion
            }
        }
    }

    /*
    TODO: ESTHER
     */
    /**
     * Se realiza un disparo y comprueba si ha dado en el blanco o al agua.
     * Actualiza {@link #posicionesBarcos} restandole 1 unidad.
     * @param x - posicion x en tablero, corresponde con la columna del tablero.
     * @param y - posicion y en el tablero, corresponde con la fila del tablero.
     * @return si en la posicion indicada hay un barco, devuelve el char de ese barco, si no, devuelve un arroba.
     */
    /*public char checkDisparo(int x, int y) {
        if(this.tablero[x][y] != guion) {
            System.out.println("Tocado");
            System.out.flush();
            setPosicionesBarcos(getPosicionesBarcos() - 1);
            return this.tablero[x][y];
        } else {
            System.out.println("Agua");
            System.out.flush();
            return arroba;
        }
    }*/
    fun checkDisparo(x: Int, y: Int): Char {
        if (this.tablero[x][y] != guion) {
            println("Tocado")
            setPosicionesBarcos(getPosicionesBarcos() - 1)
            return this.tablero[x][y]
        } else {
            println("Agua")
            return arroba
        }
    }

    /*
    TODO: JOSE ANTONIO
     */
    /**
     * Actualiza el tablero y pone en la posición x-y otra cosa
     * @param x Corresponde con la columna del tablero
     * @param y corresponde con la fila del tablero
     * @param cosa - char con el que queremos rellenar la posición
     */
    /*public void updateTablero(int x, int y, char cosa) {
        this.tablero[x][y] = cosa;
    }*/



    /*
    TODO: FRANCISCO
     */
    /**
     * Metodo para colocar un barco en el tablero.
     * El {@code Barco.class} puede ser de tipo {@code <L>, <B>, <Z> o <P>}
     * @param barco Objeto de tipo {@link Barco#Barco(String, char, int)}
     * @throws Exception lanza la excepción cuando se ha producido algún error {@link #imprimirError(String)}
     */
    /*public void colocarBarco(Barco barco) throws Exception{

        if (barco.getIni() == 'L') {
            colocarL(barco);
        } else if (barco.getIni() == 'B' || barco.getIni() == 'Z') {
            colocarHorizontal(barco);
        } else if (barco.getIni() == 'P') {
            colocarVertical(barco);
        } else {
            imprimirError("Barco erróneo");
        }
    }*/
    fun colocarBarco(barco: Barco){
        when(barco.getIni()){
            'L'->colocarL(barco)
            'B' -> colocarHorizontal(barco)
            'Z'-> colocarHorizontal(barco)
            'P' -> colocarVertical(barco)
            else->throw imprimirError("Barco erróneo")
        }
    }
    /*
    TODO: ALVARO
     */
    /**
     * Si se produce un error en este método, se arroja una excepción
     * @param mensaje mensaje de error que se mostrará por pantalla
     * @throws Exception Excepción genérica que se lanza al producirse un error
     * @see Barco
     */

    @Throws(Exception::class)
    private fun imprimirError(mensaje: String) {
        System.err.format("ERROR: %s", mensaje)
        throw Exception(mensaje)
    }
            open fun getPosicionesBarcos(){
            return posicionesBarcos}

            open fun setPosicionesBarcos(posicionesBarcos:Int){
            this.posicionesBarcos=posicionesBarcos}



    /*
    TODO: FELIPE
    */
    /*public static void cabecera() {
        System.out.print("____________________________________________\n");
        System.out.print("______________HUNDIR LA FLOTA_______________\n");
        System.out.flush();
    }

    public static void menuPpal() {
        System.out.print(
            "___________Elija dificultad (1 - 4)_________\n"
                    + "____________________________________________\n"
                    + "1. Nivel f�cil\n" + "2. Nivel medio\n"
                    + "3. Nivel dif�cil\n"
                    + "4. Nivel personalizado\n"
                    + "\n"
                    + "0. Salir\n");
        System.out.flush();
    }

    public static void errorSeleccion() {
        System.err.print(
            "************\n"
                    + "Error en la elecci�n de la dificultad.\n"
                    + "Por favor, elija una opci�n v�lida.\n"
                    + "************\n");
    }

    public static void despedida() {
        System.out.print("Nus vemos!\n");
        System.out.flush();
    }

    public static void comienzoJuego() {
        try {
            System.out.print("\n\nComienza el juego en 3");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print("2");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print("1");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print(".");
            Thread.sleep(300);System.out.print("Go!");
            Thread.sleep(500);
            for (int i = 0; i < 50; ++i) System.out.println();
            System.out.flush();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void errorPosicion() {
        System.err.println("Error, indique una opcion v�lida");
    }*/
}