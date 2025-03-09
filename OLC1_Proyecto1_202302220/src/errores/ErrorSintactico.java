/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package errores;

/**
 *
 * @author Enner
 */
public class ErrorSintactico {
    int linea;
    int columna;
    Object toke;
    String tipo;

    String error;
    public ErrorSintactico(int linea, int columna, Object toke, String tipo) {
        this.linea = linea;
        this.columna = columna;
        this.toke = toke;
        this.tipo = tipo;
    }

    public ErrorSintactico(String error) {
        this.error = error;
    }

    public String toString() {
        if (error != null) {
            return error;
        }
        return "Error Sintactico en la linea " + linea + " columna " + columna + "no se esperaba " + tipo + " " + toke;
    }
}
