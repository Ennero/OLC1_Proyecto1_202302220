/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Instruccion;
import utilidades.T_Sentencia;

/**
 *
 * @author Enner
 */
public abstract class Instruccion extends Sentencia {
    
    T_Instruccion tipoInstruccion;
    public Instruccion(T_Instruccion tipoInstruccion) {
        super(T_Sentencia.INSTRUCCION);
        this.tipoInstruccion = tipoInstruccion;
    }
    public abstract void jugar(Entorno entorno);
    
}
