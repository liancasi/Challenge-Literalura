package com.cursosalura.Literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        if (json == null || json.trim().isEmpty()) {
            throw new IllegalArgumentException("La cadena JSON de entrada es nula o está vacía");
        }

        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new ExcepcionParseJson("Error al analizar JSON: " + e.getMessage(), e);
        }
    }
}

// Clase de excepción personalizada
class ExcepcionParseJson extends RuntimeException {
    public ExcepcionParseJson(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
