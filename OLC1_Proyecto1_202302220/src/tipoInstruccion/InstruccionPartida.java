/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoInstruccion;

import olc1_proyecto1_202302220.Jugadores;
import abstractas.Expresion;
import abstractas.Instruccion;
import olc1_proyecto1_202302220.Puntaje;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;

/**
 *
 * @author Enner
 */
public class InstruccionPartida extends Instruccion {

    Jugadores jugadores;
    Expresion rondas;
    Puntaje puntos;

    public InstruccionPartida(Jugadores jugadores, Expresion rondas, Puntaje puntos) {
        super(TipoInstruccion.PARTIDA);
        this.jugadores = jugadores;
        this.rondas = rondas;
        this.puntos = puntos;
    }

    @Override
    public void jugar(Ambiente ambiente) {
        rondas.jugar(ambiente);
        puntos.cooperacion.jugar(ambiente);
        puntos.defeccion.jugar(ambiente);
        puntos.traidor.jugar(ambiente);
        puntos.traicionado.jugar(ambiente);
    }
}
