package com.pokemon.clases

class Pokemon(id: Int, nombre: String, vida: Int, tipo: String) {

    var id: Int = 0
        set(value){
            if(value <= 0){
                throw Exception("El Id no puede ser menor que 0")
            }
            field = value
        }

    var nombre: String = ""

    var vida: Int = 0

    var tipo: Tipo

    init {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = Tipo(tipo)
    }

}