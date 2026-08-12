/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monterroso.practica1.lf;

/**
 *
 * @author seo
 */
public class PalabrasClave {

    public static TipoToken tipoDePalabra(String palabra) {
        switch (palabra) {
            case "AGENTE":
            case "contexto":
            case "variable":
            case "EJECUTAR":
            case "EXPORTAR":
                return TipoToken.PALABRA_RESERVADA;
            case "PREGUNTAR":
            case "GENERAR":
            case "RESUMIR":
            case "ANALIZAR":
            case "TRADUCIR":
            case "CLASIFICAR":
            case "EXTRAER":
                return TipoToken.COMANDO_IA;
            case "CARGAR":
                return TipoToken.FUNCION;
            case "SOBRE":
            case "DESDE":
            case "EN":
            case "COMO":
                return TipoToken.CONECTOR;
            default:
                return null; // no es palabra clave -> es identificador
        }
    }

    public static boolean esDirectivaValida(String nombre) {
        switch (nombre) {
            case "modelo":
            case "rol":
            case "formato":
                return true;
            default:
                return false;
        }
    }

}
