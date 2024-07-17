package com.cursosalura.Literalura.repository;

import com.cursosalura.Literalura.entities.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository <Libros, Long> {


    Optional<Libros> findByTitulo(String titulo);
}
