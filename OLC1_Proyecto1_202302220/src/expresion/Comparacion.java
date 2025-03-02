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
    
    public Expresion exp1;
    public Expresion exp2;
    
    public String operador;
    
    public Comparacion(Expresion exp1, String operador, Expresion exp2) {
        super(TipoExpresion.COMPARATIVO);
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }
    
    @Override
    public TipoRetorno jugar(Entorno entorno) {
        return switch (this.operador) {
            case "==" -> igual(entorno);
            case "!=" -> null;
            case ">" -> null;
            case "<" -> null;
            case ">=" -> null;
            case "<=" -> null;
            default -> new TipoRetorno(-1, null);
        }; // Igualdad
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
