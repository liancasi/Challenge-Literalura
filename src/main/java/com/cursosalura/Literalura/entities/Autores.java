package com.cursosalura.Literalura.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long nacimiento;
    private Long fallecimmiento;
    @OneToMany(mappedBy = "autores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libros> libros;

    public Autores() {
    }

    public Autores(Long id, String nombre, Long nacimiento, Long fallecimmiento, List<Libros> libros) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.fallecimmiento = fallecimmiento;
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Long nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Long getFallecimmiento() {
        return fallecimmiento;
    }

    public void setFallecimmiento(Long fallecimmiento) {
        this.fallecimmiento = fallecimmiento;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }
}