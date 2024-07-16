package com.cursosalura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutores(
        @JsonProperty("name") String nombre,
        @JsonProperty("birth_year") Long nacimiento,
        @JsonProperty("death_year") Long fallecimiento
       ) {
}
