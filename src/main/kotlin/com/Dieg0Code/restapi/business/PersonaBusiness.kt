package com.Dieg0Code.restapi.business

import com.Dieg0Code.restapi.dao.PersonaRepository
import com.Dieg0Code.restapi.exception.BusinessException
import com.Dieg0Code.restapi.exception.NotFoundException
import com.Dieg0Code.restapi.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaBusiness : IPersonaBusiness {

    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try {
            return personaRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con id: $idPersona")
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        try {
            return personaRepository!!.save(persona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun remove(idPersona: Long) {
        val op: Optional<Persona>

        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if(!op.isPresent) {
            throw NotFoundException("No se encontro la persona con el id: $idPersona")
        } else {
            try {
                personaRepository!!.deleteById(idPersona)
            } catch (e:Exception) {
                throw BusinessException(e.message)
            }
        }
    }

}