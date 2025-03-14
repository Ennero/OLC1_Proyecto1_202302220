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
public class RondaActual extends Expresion {

    public RondaActual() {
        super(TipoExpresion.PRIMITIVO);
    }

    @Override
    public TipoRetorno jugar(Ambiente ambiente) {
        return new TipoRetorno(ambiente.getRondaActual(), TipoTipo.ENTERO);
    }
}
