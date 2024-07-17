package com.cursosalura.Literalura.principal;

import com.cursosalura.Literalura.entities.Autores;
import com.cursosalura.Literalura.entities.Libros;

import com.cursosalura.Literalura.service.ConsumoAPI;
import com.cursosalura.Literalura.service.ConvierteDatos;
import com.cursosalura.Literalura.service.DatosService;
import com.cursosalura.Literalura.service.Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/";

    @Autowired
    private DatosService datosService;

    @Autowired
    public Principal(DatosService datosService) {
        this.datosService = datosService;
    }



    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ****************************************
                    BIENVENIDOS A LITERALURA
                    *****************************************
                    
                    Elija la opción a traves de su número:
                  
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4-  Listar autores vivos en un determinado año
                    5-  Listar libros por idioma 
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    ListarLibrosRegistrados();
                    break;
                case 3:
                    ListarAutoresRegistrados();
                    break;
                case 4:
                    ListarAutoresPorAño();
                    break;
                case 5:
                    ListarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void ListarLibrosRegistrados() {
        System.out.println("****Lista de Libros Registrados****");
        datosService.listarLibrosRegistrados();
    }

    private void ListarAutoresRegistrados() {
        datosService.listarAutoresRegistrados();
    }

    private void ListarAutoresPorAño() {
        System.out.println("Ingrese el año para listar autores vivos: ");
        int año = Validador.validarOpcionMenu(teclado);
        datosService.listarAutoresVivosPorAño(año);
    }

    private void ListarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma para listar libros: ");
        String idioma = Validador.validarIdioma(teclado);
        if(!idioma.equals("N/A")){
            datosService.listarLibrosPorIdioma(idioma);
        }else {
            System.out.println("No se encuentra el idioma digitado.");
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        String tituloLibro = teclado.nextLine();
        String codigoUrl = URL_BASE+"?search="+tituloLibro.replace(" ","+");
        String json = ConsumoAPI.obtenerDatos(codigoUrl);
        datosService.buscarLibroPorTitulo(json);


    }

}
