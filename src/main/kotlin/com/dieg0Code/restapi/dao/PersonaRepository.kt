package com.dieg0Code.restapi.dao

import com.dieg0Code.restapi.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// El DAO (Data Access Object) es el encargado de tener los metodos para manipular los datos en la DB(Data Base)

// Esta interfaz es la encargada de poder acceder a los datos en la DB
@Repository
interface PersonaRepository : JpaRepository<Persona, Long>