/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Expresion;
import utilidades.T_Retorno;
import utilidades.T_Sentencia;

/**
 *
 * @author Enner
 */
public abstract class Expresion extends Sentencia{
    T_Expresion tipoExpresion;
    public Expresion(T_Expresion tipoExpresion) {
        super(T_Sentencia.EXPRESION);
        this.tipoExpresion = tipoExpresion;
    }

    public abstract T_Retorno jugar(Entorno entorno);
}
