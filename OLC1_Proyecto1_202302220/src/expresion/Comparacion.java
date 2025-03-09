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
public class Comparacion extends Expresion{
    
    Expresion exp1;
    Expresion exp2;
    String operador;
    public Comparacion(Expresion exp1, String operador, Expresion exp2) {
        super(TipoExpresion.COMPARATIVO);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }

<<<<<<< HEAD
=======
    @Override
    public TipoRetorno jugar(Entorno entorno) {
<<<<<<< HEAD:OLC1_Proyecto1_202302220/src/objetos/Comparacion.java
=======
>>>>>>> 89ae929 (Oa)
    @Override
    public T_Retorno jugar(Entorno entorno) {
=======
>>>>>>> 8cdcdf1 (Regresando):OLC1_Proyecto1_202302220/src/expresion/Comparacion.java
        switch (this.operador) {
            case "==":
                // Igualdad
                return igual(entorno);
            case "!=":
                return null;
            case ">":
                return null;
            case "<":
            return null;
            case ">=":
            return null;
            case "<=":
            return null;
            default:
                return new TipoRetorno(-1, null);
        }
    }

    public TipoRetorno igual(Entorno entorno) {
        TipoRetorno valor1 = exp1.jugar(entorno);
        TipoRetorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == TipoTipo.ENTERO || valor1.tipo == TipoTipo.FLOTANTE) {
            if (valor2.tipo == TipoTipo.ENTERO || valor2.tipo == TipoTipo.FLOTANTE) {
                // 12.0 == 12 -> true | false
                return new TipoRetorno(Double.parseDouble(valor1.valor.toString()) == Double.parseDouble(valor2.valor.toString()), TipoTipo.BOOLEANO);
            }
        }
        return null;
    }
    
    
}
