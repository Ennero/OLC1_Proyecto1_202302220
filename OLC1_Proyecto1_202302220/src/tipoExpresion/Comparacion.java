/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoExpresion;

import abstractas.Expresion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoExpresion;
import tipos.TipoRetorno;
import tipos.TipoTipo;

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
    public TipoRetorno jugar(Ambiente ambiente) {
        return switch (this.operador) {
            case "==" ->
                igual(ambiente);
            case "!=" ->
                noIgual(ambiente);
            case ">" ->
                mayor(ambiente);
            case "<" ->
                menor(ambiente);
            case ">=" ->
                mayorIgual(ambiente);
            case "<=" ->
                menorIgual(ambiente);
            default ->
                new TipoRetorno(-1, null);
        };
    }

    public TipoRetorno igual(Ambiente ambiente) {
        //System.out.println("comienzo la comparación aqui");
        //if(exp1==null) System.out.println("es nulo desde aquiiiiii");
        TipoRetorno valor1 = exp1.jugar(ambiente);
        //System.out.println("aqui si no hay problemas");
        TipoRetorno valor2 = exp2.jugar(ambiente);
        //System.out.println("aqui si no hay probelmas");
        System.out.println("IGUALO " + "valor 1: " + valor1.valor.toString() + "Valor 2: " + valor2.valor.toString());

        //para flotante o entero
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) == Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }

        //Para las decisiones
        if (valor1.tipo == TipoTipo.DECISION || valor1.tipo == TipoTipo.DECISION) {
            if (valor2.tipo == TipoTipo.DECISION && valor2.tipo == TipoTipo.DECISION) {
                return new TipoRetorno((valor1.valor.toString()).equals(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }

        //para las listas
        if (valor1.tipo == TipoTipo.LISTA && valor2.tipo == TipoTipo.LISTA) {
            ArrayList<?> lista1 = (ArrayList<?>) valor1.valor;
            ArrayList<?> lista2 = (ArrayList<?>) valor2.valor;

            //Si tienen tamaños diferentes de una lo saco
            if (lista1.size() != lista2.size()) {
                return new TipoRetorno(false, TipoTipo.BOOLEANO);
            }

            //Si no entonces hago un ciclo que lo compare todo
            for (int i = 0; i < lista1.size(); i++) {
                if (!lista1.get(i).equals(lista2.get(i))) {
                    //Si no son iguales entonces no son iguales xd
                    return new TipoRetorno(false, TipoTipo.BOOLEANO);
                }
            }
            //Entonces si son iguales
            return new TipoRetorno(true, TipoTipo.BOOLEANO);  // Son iguales
        }

        //Si no no
        return null;
        //return new TipoRetorno(false, TipoTipo.BOOLEANO);
    }

    public TipoRetorno noIgual(Ambiente ambiente) {
        TipoRetorno valor1 = exp1.jugar(ambiente);
        TipoRetorno valor2 = exp2.jugar(ambiente);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) != Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        if (valor1.tipo == TipoTipo.DECISION && valor1.tipo == TipoTipo.DECISION) {
            return new TipoRetorno(Boolean.parseBoolean(valor1.valor.toString()) != Boolean.parseBoolean(valor2.valor.toString()), TipoTipo.BOOLEANO);
        }
        return null;
    }

    public TipoRetorno mayor(Ambiente ambiente) {
        TipoRetorno valor1 = exp1.jugar(ambiente);
        TipoRetorno valor2 = exp2.jugar(ambiente);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) > Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno menor(Ambiente ambiente) {
        TipoRetorno valor1 = exp1.jugar(ambiente);
        TipoRetorno valor2 = exp2.jugar(ambiente);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) < Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno mayorIgual(Ambiente ambiente) {
        TipoRetorno valor1 = exp1.jugar(ambiente);
        TipoRetorno valor2 = exp2.jugar(ambiente);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) >= Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

    public TipoRetorno menorIgual(Ambiente ambiente) {
        TipoRetorno valor1 = exp1.jugar(ambiente);
        TipoRetorno valor2 = exp2.jugar(ambiente);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) <= Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }

}
