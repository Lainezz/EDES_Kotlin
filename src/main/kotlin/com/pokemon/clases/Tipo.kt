package com.pokemon.clases

class Tipo(tipo: String) {

    val tipo: String;

    init {
        if(tipo.isEmpty()){
            throw IllegalArgumentException("El tipo no puede ser vacío")
        }

        val tipoValido = tiposAceptados.find { t -> tipo.lowercase().equals(t) }
        tipoValido ?: throw IllegalArgumentException("El tipo no es válido")

        this.tipo = tipoValido;
    }

    companion object {
        private val tiposAceptados: List<String> = listOf<String>(
            "acero","agua","bicho","dragon","electrico","fantasma","fuego","hada","hielo","lucha","normal",
            "planta", "psiquico","roca","siniestro","tierra","veneno","volador")
        fun getTiposAceptados(): List<String>{
            return tiposAceptados;
        }
    }

    override fun toString(): String {
        return "Tipo del pokemon: $tipo"
    }
}