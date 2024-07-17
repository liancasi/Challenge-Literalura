package com.cursosalura.Literalura.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    public static int validarOpcionMenu(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Por favor, ingresa solo números para seleccionar una opción del menú.");
                sc.nextLine();
                System.out.println("Intenta nuevamente. Ingresa el número de la opción deseada: ");
                System.out.print("> ");
            }
        }
    }

    public static int validarEntradaNumerica(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error: Debes ingresar un número válido.");
                sc.nextLine();
                System.out.println("Por favor, ingresa el número nuevamente: ");
                System.out.print("> ");
            }
        }
    }

    public static String validarIdioma(Scanner sc) {
        String idioma = sc.nextLine().trim();
        while (true) {
            if (!idioma.isEmpty()) {
                switch (idioma.toLowerCase()) {
                    case "español":
                    case "espanol":
                        return "es";
                    case "inglés":
                    case "ingles":
                        return "en";
                    case "francés":
                    case "frances":
                        return "fr";
                    default:
                        System.out.println("Idioma no reconocido. Por favor, ingresa 'Español', 'Inglés' o 'Francés'.");
                        idioma = sc.nextLine().trim();
                }
            } else {
                System.out.println("Debes ingresar un idioma para buscar los libros. Intenta nuevamente:");
                idioma = sc.nextLine().trim();
            }
        }
    }

    public static String obtenerNombreCompletoIdioma(String codigoIdioma) {
        switch (codigoIdioma.toLowerCase()) {
            case "es":
                return "Español";
            case "en":
                return "Inglés";
            case "fr":
                return "Francés";
            default:
                return "Idioma desconocido";
        }
    }
}
