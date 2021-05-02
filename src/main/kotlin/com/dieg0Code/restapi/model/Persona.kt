package com.dieg0Code.restapi.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*

// Entidad "Persona"
@Entity
// Nombre de la tabla en la DB
@Table(name = "persona")
data class Persona(
    val dni: Long = 0,
    val nombre: String = "",
    val apellido: String = "",
    val fechaNac: LocalDate? = null
) {
    // Genera ID autoincremental único
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}