package com.Dieg0Code.restapi.dao

import com.Dieg0Code.restapi.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository : JpaRepository<Persona, Long>