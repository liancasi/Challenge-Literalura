package com.cursosalura.Literalura.dto;

import com.cursosalura.Literalura.entities.Libros;

import java.util.List;

public record AutoresDTO(
        String nombre,
        Long nacimiento,
        Long fallecimiento,
        List<Libros> libros
) {
}
