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

public class RondaActual extends Expresion {
    public RondaActual() {
        super(T_Expresion.PRIMITIVO);
    }

    @Override
    public T_Retorno jugar(Entorno entorno) {
        return new T_Retorno(entorno.getRondaActual(), T_Tipo.ENTERO);
    }
}