/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoInstruccion;

import olc1_proyecto1_202302220.Estrategia;
import abstractas.Instruccion;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;

/**
 *
 * @author Enner
 */
public class CrearEstrategia extends Instruccion {

    String nombre;
    InstruccionEstrategia instrucciones;

    public CrearEstrategia(String nombre, InstruccionEstrategia instrucciones) {
        super(TipoInstruccion.ESTRATEGIA);
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    @Override
    public void jugar(Ambiente abmiente) {
        //Coloco la estretegia en el entorno
        Estrategia estrategia = new Estrategia(nombre, instrucciones);
        abmiente.guardarEstrategia(nombre, estrategia);
    }
}
