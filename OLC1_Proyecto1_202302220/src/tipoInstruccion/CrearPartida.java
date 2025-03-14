/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoInstruccion;

import abstractas.Instruccion;
import olc1_proyecto1_202302220.Partida;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;
import tipos.TipoRetorno;

/**
 *
 * @author Enner
 */
public class CrearPartida extends Instruccion {

    String nombre;
    InstruccionPartida instrucciones;

    public CrearPartida(String nombre, InstruccionPartida instrucciones) {
        super(TipoInstruccion.PARTIDA);
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    @Override
    public void jugar(Ambiente ambiente) {
        //Haciendo que la partida tenga todo lo necesario
        String jugador1 = instrucciones.jugadores.jugador1;
        String jugador2 = instrucciones.jugadores.jugador2;
        TipoRetorno rondas = instrucciones.rondas.jugar(ambiente);
        Partida partida = new Partida(nombre, jugador1, jugador2, rondas.valor, instrucciones.puntos);
        ambiente.guardarPartida(nombre, partida);
    }
}
