package com.cursosalura.Literalura.dto;

import com.cursosalura.Literalura.entities.Autores;

public record LibrosDTO(
        String titulo,
        Autores autores,
        String idioma,
        Long descargas
) {
}
