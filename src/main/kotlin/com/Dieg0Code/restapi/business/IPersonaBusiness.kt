package com.Dieg0Code.restapi.business

import com.Dieg0Code.restapi.model.Persona

interface IPersonaBusiness {
    fun list(): List<Persona>
    fun load(idPersona: Long): Persona
    fun save(persona: Persona): Persona
    fun remove(idPersona: Long)
}