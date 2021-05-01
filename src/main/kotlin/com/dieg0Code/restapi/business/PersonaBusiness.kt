package com.dieg0Code.restapi.business

import com.dieg0Code.restapi.dao.PersonaRepository
import com.dieg0Code.restapi.exception.BusinessException
import com.dieg0Code.restapi.exception.NotFoundException
import com.dieg0Code.restapi.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

// Esta clase va a ser la encargada de implementar los metodos de la interfaz IPersonaBusiness
// Es la encargada de generar todas las peticiones a la base de datos para traer los datos
@Service
class PersonaBusiness : IPersonaBusiness {

    // Autowired es una inyeccion de dependencia dentro de PersonaBusiness
    @Autowired // Inyecta en PersonaBusinnes el repository encargado de tener todos los metodos para poder trabajar con la base de datos
    val personaRepository: PersonaRepository? = null

    //Todos los metodos que tengan que ver con persistencia; escribir, leer o modificar la base de datos siempre deben ir acompañados de un try-catch.
    // ya que estos metodos pueden llegar a arrojar una excepcion en caso de que no se encuentre algun tipo de dato en la Base de Datos o que no se pudea insertar

    @Throws(BusinessException::class) // Excepciones
    override fun list(): List<Persona> {
        try {
            return personaRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona> // Esta variable es para saber si ese dato esta en la Base de Datos
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con id: $idPersona")
        }

        return op.get() // retorna la persona si la pudo encontrar en la Base de Datos
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

        if (!op.isPresent) {
            throw NotFoundException("No se encontro la persona con el id: $idPersona")
        } else {
            try {
                personaRepository!!.deleteById(idPersona)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }

}