/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractas;

import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoExpresion;
import tipos.TipoRetorno;
import tipos.TipoSentencia;

/**
 *
 * @author Enner
 */
public abstract class Expresion extends Sentencia {

    TipoExpresion tipoExpresion;

    public Expresion(TipoExpresion tipoExpresion) {
        super(TipoSentencia.EXPRESION);
        this.tipoExpresion = tipoExpresion;
    }

    public abstract TipoRetorno jugar(Ambiente ambiente);
}
