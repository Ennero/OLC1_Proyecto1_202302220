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

public class RondaActual extends Expresion {
    public RondaActual() {
        super(TipoExpresion.PRIMITIVO);
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {
        return new TipoRetorno(entorno.getRondaActual()+1, TipoTipo.ENTERO);
    }
}