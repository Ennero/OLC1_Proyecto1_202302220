/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expresion;

import abstractas.Expresion;
import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoExpresion;
import utilidades.TipoRetorno;
import utilidades.TipoTipo;

/**
 *
 * @author Enner
 */

public class Primitiva extends Expresion{
    Object valor;
    TipoTipo tipo;
    public Primitiva(Object valor, TipoTipo tipo) {
        super(TipoExpresion.PRIMITIVO);
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {
        switch (tipo) {
            case ENTERO:
                return new TipoRetorno(Integer.parseInt(valor.toString()), tipo);
            case FLOTANTE:
                return new TipoRetorno(Double.parseDouble(valor.toString()), tipo);
            case BOOLEANO:
                return new TipoRetorno(valor.toString().equals("true"), tipo);
            case DECISION:
                return new TipoRetorno(valor.toString().equals("C"), tipo);
            default:
                break;
        }
        return null;
    }
}