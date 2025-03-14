/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instrucciones;

import olc1_proyecto1_202302220.Jugadores;
import abstractas.Expresion;
import abstractas.Instruccion;
import olc1_proyecto1_202302220.Puntos;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;

/**
 *
 * @author Enner
 */

public class InstruccionPartida extends Instruccion{
    Jugadores jugadores; 
    Expresion rondas; 
    Puntos puntos;
    public InstruccionPartida(Jugadores jugadores, Expresion rondas, Puntos puntos) {
        super(TipoInstruccion.PARTIDA);
        this.jugadores = jugadores;
        this.rondas = rondas;
        this.puntos = puntos;
    }

    @Override
    public void jugar(Ambiente entorno) {
        rondas.jugar(entorno);
        puntos.cooperacion.jugar(entorno);
        puntos.defeccion.jugar(entorno);
        puntos.traidor.jugar(entorno);
        puntos.traicionado.jugar(entorno);
    }
}