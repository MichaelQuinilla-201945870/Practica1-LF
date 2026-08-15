package com.monterroso.practica1.lf;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author seo
 */
public class GeneradorReportes {


    public void generarReporteTokens(List<Token> tokens, String rutaSalida) {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><meta charset=\"UTF-8\"><title>Reporte de Tokens</title>")
                .append(estilos())
                .append("</head><body>")
                .append("<h1>Reporte de Tokens</h1>")
                .append("<p>Total de tokens reconocidos: ").append(tokens.size()).append("</p>")
                .append("<table><tr><th>#</th><th>Lexema</th><th>Tipo</th><th>Fila</th><th>Columna</th></tr>");

        for (Token t : tokens) {
            html.append("<tr><td>").append(t.getNumero()).append("</td>")
                    .append("<td>").append(escaparHtml(t.getLexema())).append("</td>")
                    .append("<td>").append(t.getTipo()).append("</td>")
                    .append("<td>").append(t.getFila()).append("</td>")
                    .append("<td>").append(t.getColumna()).append("</td></tr>");
        }

        html.append("</table></body></html>");
        escribirArchivo(rutaSalida, html.toString());
    }

    private String estilos() {
        return "<style>"
                + "body{font-family:Arial,sans-serif;margin:24px;}"
                + "table{border-collapse:collapse;width:100%;}"
                + "th,td{border:1px solid #ccc;padding:6px 10px;text-align:left;}"
                + "th{background:#2c3e50;color:white;}"
                + "tr:nth-child(even){background:#f5f5f5;}"
                + "</style>";
    }

    private String escaparHtml(String texto) {
        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private void escribirArchivo(String ruta, String contenido) {
        try {
            Files.writeString(Path.of(ruta), contenido);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir el reporte: " + e.getMessage());
        }
    }

    public void generarReporteErrores(List<ErrorLexico> errores, String rutaSalida) {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><meta charset=\"UTF-8\"><title>Reporte de Errores</title>")
                .append(estilos())
                .append("</head><body>")
                .append("<h1>Reporte de Errores L\u00e9xicos</h1>");

        if (errores.isEmpty()) {
            html.append("<p>No se encontraron errores l\u00e9xicos.</p>");
        } else {
            html.append("<p>Total de errores encontrados: ").append(errores.size()).append("</p>")
                    .append("<table><tr><th>Lexema / Car\u00e1cter</th><th>Descripci\u00f3n</th><th>Fila</th><th>Columna</th></tr>");
            for (ErrorLexico e : errores) {
                html.append("<tr><td>").append(escaparHtml(e.getLexema())).append("</td>")
                        .append("<td>").append(escaparHtml(e.getDescripcion())).append("</td>")
                        .append("<td>").append(e.getFila()).append("</td>")
                        .append("<td>").append(e.getColumna()).append("</td></tr>");
            }
            html.append("</table>");
        }

        html.append("</body></html>");
        escribirArchivo(rutaSalida, html.toString());
    }
    
}
