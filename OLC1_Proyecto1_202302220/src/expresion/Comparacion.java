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
public class Comparacion extends Expresion {

    Expresion exp1;
    Expresion exp2;
    String operador;

    public Comparacion(Expresion exp1, String operador, Expresion exp2) {
        super(TipoExpresion.COMPARATIVO);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {
        return switch (this.operador) {
            case "==" ->
                igual(entorno);
            case "!=" ->
                noIgual(entorno);
            case ">" ->
                mayor(entorno);
            case "<" ->
                menor(entorno);
            case ">=" ->
                mayorIgual(entorno);
            case "<=" ->
                menorIgual(entorno);
            default ->
                new TipoRetorno(-1, null);
        };
    }

    public TipoRetorno igual(Entorno entorno) {
        //System.out.println("comienzo la comparación aqui");
        //if(exp1==null) System.out.println("es nulo desde aquiiiiii");
        TipoRetorno valor1 = exp1.jugar(entorno);
        //System.out.println("aqui si no hay problemas");
        TipoRetorno valor2 = exp2.jugar(entorno);
        //System.out.println("aqui si no hay probelmas");
        System.out.println("valor 1: "+valor1.valor.toString()+"Valor 2: "+valor2.valor.toString());
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) == Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        if (valor1.tipo == TipoTipo.DECISION || valor1.tipo == TipoTipo.DECISION) {
            if (valor2.tipo == TipoTipo.DECISION && valor2.tipo == TipoTipo.DECISION) {
                return new TipoRetorno((valor1.valor.toString()).equals(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return new TipoRetorno(false, TipoTipo.BOOLEANO);
    }

    public TipoRetorno noIgual(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) != Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno mayor(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) > Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno menor(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) < Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno mayorIgual(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) >= Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno menorIgual(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) <= Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

}