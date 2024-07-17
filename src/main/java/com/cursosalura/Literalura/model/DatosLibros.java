package com.cursosalura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonProperty("title")  String titulo,
        @JsonProperty("authors")List<DatosAutores> autores,
        @JsonProperty("languages")  List<String> idioma,
        @JsonProperty("download_count") Long descargas
) {



}
