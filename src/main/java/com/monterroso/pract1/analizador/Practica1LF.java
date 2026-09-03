/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.monterroso.pract1.analizador;


import com.monterroso.pract1.analizador.backend.archivos.GeneradorReportes;
import com.monterroso.pract1.analizador.backend.archivos.LectorArchivo;
import com.monterroso.pract1.analizador.backend.modelos.ErrorLexico;
import com.monterroso.pract1.analizador.backend.modelos.Token;
import com.monterroso.pract1.analizador.backend.motor.AnalizadorLexico;
import java.util.List;

/**
 *
 * @author seo
 */
public class Practica1LF {

    public static void main(String[] args) {
        
        String codigo = new LectorArchivo().leerArchivo();
        AnalizadorLexico analizador = new AnalizadorLexico(codigo);
        analizador.analizar();

        List<Token> tokens = analizador.getTokens();
        List<ErrorLexico> errores = analizador.getErrores();

        System.out.println();
        System.out.println("=== TOKENS RECONOCIDOS (" + tokens.size() + ") ===");
        System.out.printf("%-4s %-30s %-20s %-6s %-8s%n", "#", "Lexema", "Tipo", "Fila", "Columna");
        for (Token t : tokens) {
            System.out.printf("%-4d %-30s %-20s %-6d %-8d%n", t.getNumero(), t.getLexema(), t.getTipo(), t.getFila(), t.getColumna());
        }
        

        System.out.println();
        System.out.println("== ERRORES LÉXICOS (" + errores.size() + ") ==");
        if (errores.isEmpty()) {
            System.out.println("No se encontraron errores léxicos.");
        } else {
            System.out.printf("%-25s %-30s %-6s %-8s%n", "Lexema", "Descripción", "Fila", "Columna");
            for (ErrorLexico e : errores) {
                System.out.printf("%-25s %-30s %-6d %-8d%n", e.getLexema(), e.getDescripcion(), e.getFila(), e.getColumna());
            }
        }
        
        GeneradorReportes reportes = new GeneradorReportes();
        reportes.generarReporteTokens(tokens, "reporte_tokens.html");
        reportes.generarReporteErrores(errores, "reporte_errores.html");
        
        System.out.println(" Reportes generados en la carpeta donde se ejecuto el programa");
    }
    
}
