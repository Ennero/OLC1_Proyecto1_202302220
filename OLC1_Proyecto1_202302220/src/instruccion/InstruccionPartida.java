/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import objetos.Jugadores;
import utilidades.Expresion;
import utilidades.Instruccion;
import objetos.Puntos;
import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Instruccion;

/**
 *
 * @author Enner
 */

public class InstruccionPartida extends Instruccion{
    Jugadores jugadores; 
    Expresion rondas; 
    Puntos puntos;
    public InstruccionPartida(Jugadores jugadores, Expresion rondas, Puntos puntos) {
        super(T_Instruccion.PARTIDA);
        this.jugadores = jugadores;
        this.rondas = rondas;
        this.puntos = puntos;
    }

    @Override
    public void jugar(Entorno entorno) {
        rondas.jugar(entorno);
        puntos.cooperacion.jugar(entorno);
        puntos.defeccion.jugar(entorno);
        puntos.traidor.jugar(entorno);
        puntos.traicionado.jugar(entorno);
    }
}