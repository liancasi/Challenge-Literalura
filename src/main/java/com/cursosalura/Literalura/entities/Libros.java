package com.cursosalura.Literalura.entities;

import com.cursosalura.Literalura.dto.LibrosDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autores_id")
    private Autores autores;
    private String idioma;
    private Long descargas;


    public Libros() {
    }

    public Libros(Long id, String titulo, Autores autores, String idioma, Long descargas) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.idioma = idioma;
        this.descargas = descargas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getDescargas() {
        return descargas;
    }

    public void setDescargas(Long descargas) {
        this.descargas = descargas;
    }
}
