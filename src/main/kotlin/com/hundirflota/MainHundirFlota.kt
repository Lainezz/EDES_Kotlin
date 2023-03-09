import com.hundirflota.clases.Barco
import com.hundirflota.clases.Tablero
import java.util.*

fun main() {

    var nLanchas = 0
    var nBuques = 0
    var nAcorazados = 0
    var nPortaAviones = 0
    var nIntentos = 0
    var nPosiciones = 0
    // Tablero que mostrar� los disparos del jugador (Agua, Barcos, pos Vacias,
    // Aciertos...)
    val tableroJuego = Tablero()

    // Tablero que mostrar� el tablero con las posiciones de los barcos
    val tableroSolucion = Tablero()

    // SELECCION DE DIFICULTAD
    val sc = Scanner(System.`in`)
    var opc: Int
    var opcOK = false
    cabecera()
    menuPpal()
    System.out.flush()
    while (!opcOK) {
        opc = sc.nextInt()
        when (opc) {
            1 -> {
                opcOK = true
                println("Ha elegido dificultad f�cil")
                System.out.flush()
                nLanchas = 5
                nBuques = 3
                nAcorazados = 1
                nPortaAviones = 1
                nIntentos = 50
            }

            2 -> {
                println("Ha elegido dificultad media")
                System.out.flush()
                opcOK = true
                nLanchas = 2
                nBuques = 1
                nAcorazados = 1
                nPortaAviones = 1
                nIntentos = 30
            }

            3 -> {
                println("Ha elegido dificultad dif�cil")
                System.out.flush()
                opcOK = true
                nLanchas = 1
                nBuques = 1
                nAcorazados = 0
                nPortaAviones = 0
                nIntentos = 10
            }

            4 -> {
                opcOK = true
            }

            0 -> {
                despedida()
                opcOK = true
                return
            }

            else -> {
                errorSeleccion()
                menuPpal()
                System.out.flush()
            }
        }
    }

    // Creamos objetos de tipo Barco para meter en el tablero
    val lancha = Barco('L')
    val buque = Barco('B')
    val acorazado = Barco('Z')
    val portaAviones = Barco('P')

    //Calculamos el numero de posiciones a derribar
    nPosiciones =
        nPosiciones + (nLanchas * lancha.getTamanio() + nBuques * buque.getTamanio() + nAcorazados * acorazado.getTamanio() + nPortaAviones) * portaAviones.getTamanio()
    tableroSolucion.setPosicionesBarcos(nPosiciones)
    try {
        for (i in 0 until nLanchas) {
            tableroSolucion.colocarBarco(lancha)
        }
        // Colocamos los buques
        for (i in 0 until nBuques) {
            tableroSolucion.colocarBarco(buque)
        }
        // Colocamos los acorazados
        for (i in 0 until nAcorazados) {
            tableroSolucion.colocarBarco(acorazado)
        }
        // Colocamos los portaAviones
        for (i in 0 until nPortaAviones) {
            tableroSolucion.colocarBarco(portaAviones)
        }
    } catch (e: Exception) {
        println("holi")
    }
    // Colocamos las lanchas
    tableroSolucion.mostrarTablero()

    //COMIENZA EL JUEGO
    comienzoJuego()
    var ganador = false
    var columna: String
    var fila: Int
    var col: Int
    var respuesta: Char
    while (nIntentos > 0 && !ganador) {
        tableroJuego.mostrarTablero()
        println("�Dispara!")
        print("Fila [1-10]: ")
        System.out.flush()
        fila = sc.nextInt()
        fila -= 1
        sc.nextLine()
        print("Columna [A-J]: ")
        System.out.flush()
        columna = sc.nextLine()
        col = columna.trim { it <= ' ' }.uppercase(Locale.getDefault())[0].code - 65
        if ((fila < 0 || fila > 9) || col < 0 || col > 9) {
            errorPosicion()
        } else {
            respuesta = tableroSolucion.checkDisparo(fila, col)
            tableroJuego.updateTablero(fila, col, respuesta)
            nIntentos--
            if (tableroSolucion.getPosicionesBarcos() === 0) {
                ganador = true
            }
        }
    }
    tableroJuego.mostrarTablero()
    if (ganador) {
        println("Ha ganado")
    } else {
        println("Ha perdido")
    }
}

fun cabecera() {
    print("____________________________________________\n")
    print("______________HUNDIR LA FLOTA_______________\n")
    System.out.flush()
}

fun menuPpal() {
    print(
        "___________Elija dificultad (1 - 4)_________\n"
                + "____________________________________________\n"
                + "1. Nivel f�cil\n" + "2. Nivel medio\n"
                + "3. Nivel dif�cil\n"
                + "4. Nivel personalizado\n"
                + "\n"
                + "0. Salir\n"
    )
    System.out.flush()
}

fun errorSeleccion() {
    System.err.print(
        ("************\n"
                + "Error en la elecci�n de la dificultad.\n"
                + "Por favor, elija una opci�n v�lida.\n"
                + "************\n")
    )
}

fun despedida() {
    print("Nus vemos!\n")
    System.out.flush()
}

fun comienzoJuego() {
    try {
        print("\n\nComienza el juego en 3")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print("2")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print("1")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print(".")
        Thread.sleep(300)
        print("Go!")
        Thread.sleep(500)
        for (i in 0..49) println()
        System.out.flush()
    } catch (e: InterruptedException) {
        // TODO Auto-generated catch block
        e.printStackTrace()
    }
}

fun errorPosicion() {
    System.err.println("Error, indique una opcion v�lida")
}
