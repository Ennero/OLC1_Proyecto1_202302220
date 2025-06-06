/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoExpresion;

import abstractas.Expresion;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoExpresion;
import tipos.TipoRetorno;
import tipos.TipoTipo;

/**
 *
 * @author Enner
 */
public class Primitiva extends Expresion {

    Object valor;
    TipoTipo tipo;

    public Primitiva(Object valor, TipoTipo tipo) {
        super(TipoExpresion.PRIMITIVO);
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public TipoRetorno jugar(Ambiente ambiente) {
        switch (tipo) {
            case ENTERO -> {
                return new TipoRetorno(Integer.parseInt(valor.toString()), tipo);
            }
            case FLOTANTE -> {
                return new TipoRetorno(Double.parseDouble(valor.toString()), tipo);
            }
            case BOOLEANO -> {
                return new TipoRetorno(valor.toString().equals("true"), tipo);
            }
            case DECISION -> {
                return new TipoRetorno(valor.toString().equals("C"), tipo);
            }
            case STRING -> {
                return new TipoRetorno(valor.toString(), tipo);
            }
            default -> {
            }
        }
        return null;
    }
}
