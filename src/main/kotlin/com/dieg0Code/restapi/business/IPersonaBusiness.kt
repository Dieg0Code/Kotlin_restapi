package com.dieg0Code.restapi.business

import com.dieg0Code.restapi.model.Persona

// Contiene la declaracion de los metodos que se van a utilizar en PersonaBusiness
interface IPersonaBusiness {
    fun list(): List<Persona>
    fun load(idPersona: Long): Persona
    fun save(persona: Persona): Persona
    fun remove(idPersona: Long)
}