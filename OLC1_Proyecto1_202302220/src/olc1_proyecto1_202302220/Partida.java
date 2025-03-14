/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc1_proyecto1_202302220;

/**
 *
 * @author Enner
 */
public class Partida {
    String nombre;
    public String jugador1;
    public String jugador2;
    public Object rondas;
    public Puntaje puntos;
    public Partida(String nombre, String jugador1, String jugador2, Object rondas, Puntaje puntos) {
        this.nombre = nombre;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondas = rondas;
        this.puntos = puntos;
    }
}
