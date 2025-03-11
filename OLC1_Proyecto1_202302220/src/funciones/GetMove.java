/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import abstractas.Expresion;
import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoExpresion;
import utilidades.TipoRetorno;
import utilidades.TipoTipo;

/**
 *
 * @author Enner
 */
public class GetMove extends Expresion {
    
   public String lista;
   public String accion;
    
    public GetMove() {
        super(TipoExpresion.FUNCION);
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {

        return new TipoRetorno(entorno.getRondaActual(), TipoTipo.DECISION);
    }
}
   
