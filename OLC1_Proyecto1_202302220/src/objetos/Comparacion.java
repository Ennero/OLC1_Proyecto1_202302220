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
public class Comparacion extends Expresion{
    
    Expresion exp1;
    Expresion exp2;
    String operador;
    public Comparacion(Expresion exp1, String operador, Expresion exp2) {
        super(T_Expresion.COMPARATIVO);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }

<<<<<<< HEAD
=======
    @Override
    public TipoRetorno jugar(Entorno entorno) {
=======
>>>>>>> 89ae929 (Oa)
    @Override
    public T_Retorno jugar(Entorno entorno) {
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
                return new T_Retorno(-1, null);
        }
    }

    public T_Retorno igual(Entorno entorno) {
        T_Retorno valor1 = exp1.jugar(entorno);
        T_Retorno valor2 = exp2.jugar(entorno);
        if (valor1.tipo == T_Tipo.ENTERO || valor1.tipo == T_Tipo.FLOTANTE) {
            if (valor2.tipo == T_Tipo.ENTERO || valor2.tipo == T_Tipo.FLOTANTE) {
                // 12.0 == 12 -> true | false
                return new T_Retorno(Double.parseDouble(valor1.valor.toString()) == Double.parseDouble(valor2.valor.toString()), T_Tipo.BOOLEANO);
            }
        }
        return null;
    }
    
    
}
