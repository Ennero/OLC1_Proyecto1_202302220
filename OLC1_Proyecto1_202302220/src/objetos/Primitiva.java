/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import utilidades.Expresion;
import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Expresion;
import utilidades.T_Retorno;
import utilidades.T_Tipo;

/**
 *
 * @author Enner
 */

public class Primitiva extends Expresion{
    Object valor;
    T_Tipo tipo;
    public Primitiva(Object valor, T_Tipo tipo) {
        super(T_Expresion.PRIMITIVO);
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public T_Retorno jugar(Entorno entorno) {
        switch (tipo) {
            case ENTERO -> {
                return new T_Retorno(Integer.parseInt(valor.toString()), tipo);
            }
            case FLOTANTE -> {
                return new T_Retorno(Double.parseDouble(valor.toString()), tipo);
            }
            case BOOLEANO -> {
                return new T_Retorno(valor.toString().equals("true"), tipo);
            }
            case DECISION -> {
                return new T_Retorno(valor.toString().equals("C"), tipo);
            }
            default -> {
            }
        }
        return null;
    }
}