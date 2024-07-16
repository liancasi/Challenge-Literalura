package com.cursosalura.Literalura.service;

import com.cursosalura.Literalura.dto.LibrosDTO;
import com.cursosalura.Literalura.entities.Autores;
import com.cursosalura.Literalura.entities.Libros;
import com.cursosalura.Literalura.model.Datos;
import com.cursosalura.Literalura.model.DatosAutores;
import com.cursosalura.Literalura.model.DatosLibros;
import com.cursosalura.Literalura.repository.AutorRepository;
import com.cursosalura.Literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DatosService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ConvierteDatos convierteDatos;

    public void buscarLibroPorTitulo(String json) {

        Datos busqueda = convierteDatos.obtenerDatos(json, Datos.class);
        if (!busqueda.resultado().isEmpty()) {
            DatosLibros datosLibros = busqueda.resultado().get(0);
            Optional<Libros> libroExistente = libroRepository.findByTitulo(datosLibros.titulo());
            if (libroExistente.isPresent()) {
                System.out.println("El libro ya existe en la base de datos.");
                System.out.println(libroExistente.get());
            } else {
                Libros nuevoLibro = new Libros();
                nuevoLibro.setTitulo(datosLibros.titulo());
                nuevoLibro.setIdioma(String.join(", ", datosLibros.idioma()));
                nuevoLibro.setDescargas(datosLibros.descargas());

                if (!datosLibros.autores().isEmpty()) {
                    DatosAutores datosAutor = datosLibros.autores().get(0);
                    Optional<Autores> autorExistente = autorRepository.findByNombre(datosAutor.nombre());
                    Autores autor;
                    if (autorExistente.isPresent()) {
                        autor = autorExistente.get();
                    } else {
                        autor = new Autores();
                        autor.setNombre(datosAutor.nombre());
                        autor.setNacimiento(datosAutor.nacimiento());
                        autor.setFallecimmiento(datosAutor.fallecimiento());
                        autorRepository.save(autor);
                    }
                    nuevoLibro.setAutores(autor);
                }

                libroRepository.save(nuevoLibro);

                System.out.printf("\nTitulo del libro: %s " + "\nNombre del autor: %s " + "\nFecha de nacimiento: %d " +
                                "\nIdioma: %s " + "\nDescargas totales: %d\n",
                        nuevoLibro.getTitulo(), nuevoLibro.getAutores().getNombre(), nuevoLibro.getAutores().getNacimiento(),
                        Validador.obtenerNombreCompletoIdioma(nuevoLibro.getIdioma()), nuevoLibro.getDescargas());

                System.out.println("──────────────────────────────────────────────────");
                System.out.println("El libro se ha guardado correctamente.");
            }
        } else {
            System.out.println("No se encontro el libro.");
        }
    }

    public void listarLibrosRegistrados() {
        List<Libros> libros = libroRepository.findAll().stream()
                .sorted(Comparator.comparing(Libros::getTitulo))
                .collect(Collectors.toList());

        if (!libros.isEmpty()) {
            System.out.println("LISTA DE LIBROS REGISTRADOS:");
            libros.forEach(l -> System.out.printf("***************************************************************************************\n" +
                            "Título del libro: %s\nNombre del autor: %s\nFecha de nacimiento: %d-%d\nIdioma: %s\nDescargas Totales: %d\n",
                    l.getTitulo(), l.getAutores().getNombre(), l.getAutores().getNacimiento(),
                    l.getAutores().getFallecimmiento() != null ? l.getAutores().getFallecimmiento() : 0,
                    Validador.obtenerNombreCompletoIdioma(l.getIdioma()),
                    l.getDescargas()));
        } else {
            System.out.println("──────────────────────────────────────────────────");
            System.out.println("No hay libros registrados en la base de datos.");
        }
    }

    public void listarAutoresRegistrados() {
        List<Autores> autores = autorRepository.findAll().stream()
                .sorted(Comparator.comparing(Autores::getNombre))
                .collect(Collectors.toList());

        if (!autores.isEmpty()) {
            System.out.println("LISTA DE AUTORES REGISTRADOS:");
            autores.forEach(a -> System.out.printf("──────────────────────────────────────────────────\n" +
                            "Nombre del autor: %s\nFecha de nacimiento: %d-%d\nLibros escritos: %s\n",
                    a.getNombre(), a.getNacimiento(), a.getFallecimmiento() != null ? a.getFallecimmiento() : 0,
                    a.getLibros().stream().map(Libros::getTitulo).collect(Collectors.joining(", "))));
        } else {
            System.out.println("──────────────────────────────────────────────────");
            System.out.println("No hay autores registrados en la base de datos.");
        }
    }

    public void listarAutoresVivosPorAño(int año) {
        List<Autores> autores = autorRepository.findAll().stream()
                .filter(autor -> autor.getNacimiento() <= año && (autor.getFallecimmiento() == null || autor.getFallecimmiento() > año))
                .sorted(Comparator.comparing(Autores::getNacimiento))
                .collect(Collectors.toList());

        if (!autores.isEmpty()) {
            System.out.printf("Autores vivos en el año %d:\n", año);
            autores.forEach(a -> System.out.printf("──────────────────────────────────────────────────\n" +
                            "Nombre del autor: %s\nFecha de nacimiento: %d-%d\nLibros escritos: %s\n",
                    a.getNombre(),
                    a.getNacimiento(),
                    a.getFallecimmiento() != null ? a.getFallecimmiento() : 0,
                    a.getLibros().stream().map(Libros::getTitulo).collect(Collectors.joining(", "))));
        } else {
            System.out.println("──────────────────────────────────────────────────");
            System.out.printf("No se encontraron autores vivos en el año %d\n", año);
        }
    }

    public void listarLibrosPorIdioma(String idioma) {
        List<Libros> libros = libroRepository.findAll().stream()
                .filter(libro -> libro.getIdioma().equalsIgnoreCase(idioma))
                .sorted(Comparator.comparing(Libros::getTitulo))
                .collect(Collectors.toList());

        String nombreIdiomaCompleto = Validador.obtenerNombreCompletoIdioma(idioma);

        if (!libros.isEmpty()) {
            System.out.printf("Libros en %s:\n", nombreIdiomaCompleto);
            libros.forEach(l -> System.out.printf("──────────────────────────────────────────────────\n" +
                            "Título del libro: %s\nNombre del autor: %s\nFecha de nacimiento: %d-%d\nDescargas Totales: %d\n",
                    l.getTitulo(),
                    l.getAutores().getNombre(),
                    l.getAutores().getNacimiento(),
                    l.getAutores().getFallecimmiento() != null ? l.getAutores().getFallecimmiento() : 0,
                    l.getDescargas()));
        } else {
            System.out.println("──────────────────────────────────────────────────");
            System.out.printf("No se encontraron libros en %s\n", nombreIdiomaCompleto);
        }
    }


}
