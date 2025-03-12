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
public class OperacionLogica extends Expresion {

    Expresion exp1;
    Expresion exp2;
    String operador;

    public OperacionLogica(Expresion exp1, String operador, Expresion exp2) {
        super(TipoExpresion.LOGICO);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {

        TipoRetorno v1 = exp1.jugar(entorno);
        TipoRetorno v2 = exp2.jugar(entorno);

        if (v1 == null || v2 == null) {
            System.out.println("alguno es nulo al parecer");
            return null;
        }
        boolean b1 = Boolean.parseBoolean(v1.valor.toString());
        boolean b2 = Boolean.parseBoolean(v2.valor.toString());
        System.out.println("el primero es "+ b1 + "y el segundo es " +b2);
        return switch (this.operador) {
            case "&&" ->
                new TipoRetorno(b1 && b2, TipoTipo.BOOLEANO);
            case "||" ->
                new TipoRetorno(b1 && b2, TipoTipo.BOOLEANO);
            default ->
                null;
        };
    }
}
