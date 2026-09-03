/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monterroso.pract1.analizador.backend.modelos;

/**
 *
 * @author seo
 */

//catalogo estricto de los tipos de componentes lexicos validos en el leguaje

public enum TipoToken {
        
    DIRECTIVA,
    PALABRA_RESERVADA,
    COMANDO_IA,
    FUNCION,
    CONECTOR,
    IDENTIFICADOR,
    LITERAL_CADENA,
    LITERAL_ENTERO,
    LITERAL_DECIMAL,
    OPERADOR,
    DELIMITADOR
    
}
