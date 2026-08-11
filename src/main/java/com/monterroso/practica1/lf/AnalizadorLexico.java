/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monterroso.practica1.lf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seo
 */
public class AnalizadorLexico {

    private final String codigoFuente;
    private int pos = 0; //sera el indice del caracter que se esta evaluando en el momento dentro de codigofuente
    private int fila = 1;
    private int columna = 1;
    private final List<Token> tokens = new ArrayList<>();
    private final List<ErrorLexico> errores = new ArrayList<>();

    public AnalizadorLexico(String codigoFuente) {
        this.codigoFuente = codigoFuente;  // todo el texto del .pz, leido completo, como una sola cadena larga
    }

    public void analizar() {
        
        while (!finDeArchivo()) {
            
            char actual = charActual();
            if (actual == '\n') {
                avanzar();
                fila++;
                columna = 1;
                continue;
            }
            if (Character.isWhitespace(actual)) {
                avanzar();
                columna++;
                continue;
            }
            
            avanzar();
            columna++;
        }
    }
    
    // palabra clave, directivas, consumidores...

    private char charActual() {
        return codigoFuente.charAt(pos);
    }

    private boolean finDeArchivo() {
        return pos >= codigoFuente.length();  //para saber si el arvhico ya termino
    }

    private void avanzar() {
        pos++;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public List<ErrorLexico> getErrores() {
        return errores;
    }

}
