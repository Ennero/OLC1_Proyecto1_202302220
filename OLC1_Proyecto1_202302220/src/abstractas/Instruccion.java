/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractas;

import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;
import tipos.TipoSentencia;

/**
 *
 * @author Enner
 */
public abstract class Instruccion extends Sentencia {
    
    TipoInstruccion tipoInstruccion;
    public Instruccion(TipoInstruccion tipoInstruccion) {
        super(TipoSentencia.INSTRUCCION);
        this.tipoInstruccion = tipoInstruccion;
    }
    public abstract void jugar(Ambiente entorno);
    
}
