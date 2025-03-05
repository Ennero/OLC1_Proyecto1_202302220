/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import utilidades.Instruccion;
import objetos.Partida;
import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Instruccion;
import utilidades.T_Retorno;

/**
 *
 * @author Enner
 */

public class CrearPartida extends Instruccion {
    String nombre;
    InstruccionPartida instrucciones;
    public CrearPartida(String nombre, InstruccionPartida instrucciones) {
        super(T_Instruccion.PARTIDA);
        this.nombre = nombre;
        this.instrucciones = instrucciones;
    }

    @Override
    public void jugar(Entorno entorno) {
        String jugador1 = instrucciones.jugadores.jugador1;
        String jugador2 = instrucciones.jugadores.jugador2;
        T_Retorno rondas = instrucciones.rondas.jugar(entorno);
        Partida partida = new Partida(nombre, jugador1, jugador2, rondas.valor, instrucciones.puntos);
        entorno.guardarPartida(nombre, partida);
    }
}