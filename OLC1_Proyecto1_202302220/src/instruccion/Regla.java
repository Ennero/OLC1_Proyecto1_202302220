/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import abstractas.Expresion;
import abstractas.Instruccion;
import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoInstruccion;

/**
 *
 * @author Enner
 */
public class Regla extends Instruccion{
    
    public Expresion condicion;
    public Expresion accion;
    
    public Regla(Expresion condicion, Expresion accion){
        super(TipoInstruccion.REGLA);
        this.condicion=condicion;
        this.accion=accion;
    }
    

    @Override
    public void jugar(Entorno entorno){
        if (condicion!=null){
            condicion.jugar(entorno);
        }
        accion.jugar(entorno);
    }
    
}
