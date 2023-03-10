    /*
    PROYECTO HUNDIR LA FLOTA

    Somos un equipo, y nos han encomendado realizar un proyecto, hundir la flota.
    Se va a seguir una metodología SCRUM, donde el profesor será el SCRUM master.
    Habrá un total de 12-14 alumn@s

    Van a consistir en 2 sprints.
    1er Sprint, crear la clase tablero de juego y la clase barco.
    2o sprint, crear la clase principal.
    */
    
    
    /************************************************
    ***********INICIO CLASE TABLERO******************
    ************************************************/
    /*
    TODO: DANIEL
     */
     ```
    /**
     * Coloca una lancha dentro del tablero de juego
     * @param lancha - Objeto de tipo barco que debe ser una lancha
     */
    private void colocarL(Barco lancha) {
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
    }
    ```

    /*
    TODO: ELOY
     */
    /**
     * Método que recibe por parámetros un objeto de tipo barco y lo coloca horizontalmente en el tablero
     * @param barco
     */
    private void colocarHorizontal(Barco barco) {
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
    }

    /*
    TODO: JOSE MANUEL
     */
    /**
     * Metodo que coloca un barco verticalmente
     */
    private void colocarVertical(Barco barco) {
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
            while(x+barco.getTamanio()>10) {
                x--;
            }

            //Variables auxiliares que usaremos para comprobar si las posiciones estan libres
            auxX = x;
            auxY = y;

            //Primero deberiamos comprobar si las posiciones para insertar el barco estan libres
            for(int i=0; i<barco.getTamanio(); i++) {
                if (comprobarSiLibre(auxX, auxY)) {
                    //Como nos movemos verticalmente, incrementamos X
                    auxX++;
                } else {
                    libre = false;
                    break;
                }
            }

            //Si las posiciones están libres, colocamos el barco sin miedo
            if(libre) {
                for(int i=0; i<barco.getTamanio(); i++) {
                    this.tablero[x][y] = barco.getIni();
                    x++;
                }
                colocado = true;
            }
        }
        System.out.flush();
    }

    /*
    TODO: PATRICIO
     */
    /**
     * Método para mostrar el tablero por pantalla
     */
    public void mostrarTablero() {

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
    }

    /*
    TODO: DIEGO
     */
    /**
     * Llena el tablero de juego con guiones, es decir, lo rellena vacio.
     */
    public void llenarTableroVacio() {

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                this.tablero[i][j] = guion;
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
    public char checkDisparo(int x, int y) {
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
    public void updateTablero(int x, int y, char cosa) {
        this.tablero[x][y] = cosa;
    }

    /*
    TODO: FRANCISCO
     */
    /**
     * Metodo para colocar un barco en el tablero.
     * El {@code Barco.class} puede ser de tipo {@code <L>, <B>, <Z> o <P>}
     * @param barco Objeto de tipo {@link Barco#Barco(String, char, int)}
     * @throws Exception lanza la excepción cuando se ha producido algún error {@link #imprimirError(String)}
     */
    public void colocarBarco(Barco barco) throws Exception{

        if (barco.getIni() == 'L') {
            colocarL(barco);
        } else if (barco.getIni() == 'B' || barco.getIni() == 'Z') {
            colocarHorizontal(barco);
        } else if (barco.getIni() == 'P') {
            colocarVertical(barco);
        } else {
            imprimirError("Barco erróneo");
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
    private void imprimirError(String mensaje) throws Exception {
        System.err.format("ERROR: %s", mensaje);
        throw new Exception(mensaje);
    }

    public int getPosicionesBarcos() {
        return posicionesBarcos;
    }

    public void setPosicionesBarcos(int posicionesBarcos) {
        this.posicionesBarcos = posicionesBarcos;
    }

    /*
    TODO: ALEJANDRO
     */
    /**
     * Numero de filas del tablero. Hardcodeado a 10.
     */
    private final int NFILAS = 10;

    /**
     * Numero de columnas del tablero. Hardcodeado a 10.
     */
    private final int NCOLS = 10;

    /**
     * Guion - Correspondiente a una casilla con agua, no disparada aún
     */
    private final char guion = (char) 45;

    /**
     * Arroba - Correspondiente a una casilla donde se ha disparado y no ha tocado ningún barco
     */
    private final char arroba = (char) 64;

    /**
     * Numero de posiciones totales que ocupan los barcos en el tablero
     */
    private int posicionesBarcos;

    char[][] tablero;

    /**
     * Constructor por defecto. Crea un tablero de NFILAS y NCOLUMNAS
     * Setea las posiciones de barcos y llena el tablero vacío.
     * @see #posicionesBarcos
     */
    public Tablero() {
        this.tablero = new char[NFILAS][NCOLS];
        setPosicionesBarcos(0);
        llenarTableroVacio();
    }

    /*
    TODO: ALEJANDRO
    */
    public static void cabecera() {
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
	}

    /************************************************
    ***********FIN CLASE TABLERO******************
    ************************************************/
    
    
    /************************************************
    ***********INICIO CLASE BARCO********************
    ************************************************/
    /*
    TODO: PABLO
     */
    /**
     * Atributos de la clase Barco
     */
    private String nombre;
    private char ini;
    private int tamanio;
	
    /**
    * Lista con las iniciales admitidas en el juego
    */
    private char[] listaAdmitidos = new char[]{'L','B','Z','P'};

    /*
    TODO: RUBEN
     */
    /**
	 * Constructor principal de clase
	 * @param ini
	 */
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

    /*
    TODO: SARA
     */
    public char getIni() {
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
	}
    /************************************************
    ***********FIN CLASE BARCO***********************
    ************************************************/
