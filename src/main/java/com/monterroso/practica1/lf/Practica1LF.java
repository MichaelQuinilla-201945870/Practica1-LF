/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.monterroso.practica1.lf;

/**
 *
 * @author seo
 */
public class Practica1LF {

    public static void main(String[] args) {
        String codigo = new LectorArchivo().leerArchivo();
        AnalizadorLexico analizador = new AnalizadorLexico(codigo);
        analizador.analizar();
        System.out.println("anallisis terminado. cantidad de letras procesadas: " + codigo.length());
    }
}
