/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractas;

import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoExpresion;
import utilidades.TipoRetorno;
import utilidades.TipoSentencia;

/**
 *
 * @author Enner
 */
public abstract class Expresion extends Sentencia{
    public TipoExpresion tipoExpresion;
    public Expresion(TipoExpresion tipoExpresion) {
        super(TipoSentencia.EXPRESION);
        this.tipoExpresion = tipoExpresion;
    }

    public abstract TipoRetorno jugar(Entorno entorno);
}
