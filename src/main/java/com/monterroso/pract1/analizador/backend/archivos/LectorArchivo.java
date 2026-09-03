/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monterroso.pract1.analizador.archivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author seo
 */



public class LectorArchivo {

    public String leerArchivo() {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo .pz: ");
        String ruta = teclado.nextLine().trim(); // trim() elimina espacios accidentales al inicio o final de la ruta ingresada
        
        
        // validacion de la extension del archivos
        if (!ruta.endsWith(".pz")) {    
            System.out.println("Advertencia: el archivo no tiene extensión .pz");
        }

        Path path = Path.of(ruta);
        
        if (!Files.exists(path)) {            
            throw new RuntimeException("El archivo no existe: " + ruta);
        }

        try {
            
            return Files.readString(path); // lee el archivo completo y lo retorna como una sola cadena para facilitar
            
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo: " + e.getMessage());
        }
    }

}
