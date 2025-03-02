/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import objetos.Estrategia;
import abstractas.Instruccion;
import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoInstruccion;

/**
 *
 * @author Enner
 */

public class CrearEstrategia extends Instruccion {
    public String nombre;
    public InstruccionEstrategia instrucciones;
    public CrearEstrategia(String nombre, InstruccionEstrategia instrucciones) {
        super(TipoInstruccion.ESTRATEGIA);
        this.nombre=nombre;
        this.instrucciones=instrucciones;
    }
    
    @Override
    public void jugar(Entorno entorno){
        Estrategia estrategia = new Estrategia(nombre, instrucciones);
        entorno.guardarEstrategia(nombre, estrategia);
    }
}