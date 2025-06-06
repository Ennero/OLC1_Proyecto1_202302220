/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc1_proyecto1_202302220;

import abstractas.Expresion;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import random.DeterministicRandomGenerator;
import random.RandomGenerator;

/**
 *
 * @author Enner
 */
public class Ambiente {

    //Variables donde guardo las cositas
    Partida partidaActual;
    int rondaActual;
    int totalRondas;
    long seed;
    public String nombre;
    public Map<String, Estrategia> estrategias = new TreeMap<>();
    public Map<String, Partida> partidas = new TreeMap<>();
    private RandomGenerator randomGenerator;

    //Contructor del entorno
    public Ambiente(String nombre) {
        this.nombre = nombre;
    }

    //Cosa de la partida actual
    public void setPartidaActual(Partida partida) {
        this.partidaActual = partida;
    }

    //Obtiene la partida actual
    public Partida getPartidaActual() {
        return this.partidaActual;
    }

    //Coloca el número de ronda actual
    public void setRondaActual(int ronda) {
        this.rondaActual = ronda;
    }

    //Obtiene el númoer de ronda Actual
    public int getRondaActual() {
        return this.rondaActual;
    }

    //Coloca el totol de rondas
    public void setTotalRondas(int ronda) {
        this.totalRondas = ronda;
    }

    //Retorna el total de rodas
    public int getTotalRondas() {
        return this.totalRondas;
    }

    //obtiene la seed
    public double getSeed() {
        return this.seed;
    }

    //pone la seed
    public void setSeed(long seed) {
        this.seed = seed;
    }

    //el random xd
    public RandomGenerator getRandomGenerator() {
        return this.randomGenerator;
    }

    //el random xd
    public void setRandomGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    //Guardo la estrategia que se ejecuta
    public boolean guardarEstrategia(String nombre, Estrategia estrategia) {
        if (!this.estrategias.containsKey(nombre)) {
            // System.out.println("ESTR: " + nombre);
            this.estrategias.put(nombre, estrategia);
            return true;
        }
        return false;
    }

    //Guardo la partida que se ejecuta
    public boolean guardarPartida(String nombre, Partida partida) {
        if (!this.partidas.containsKey(nombre)) {
            this.partidas.put(nombre, partida);
            // System.out.println("Se está guardando la partida");
            return true;
        }
        return false;
    }

    //Se obtiene la partida que se está ejecutando
    public Partida obtenerPartida(String nombre) {
        if (partidas.containsKey(nombre)) {
            // System.out.println("Encuentra la partida");
            return partidas.get(nombre);
        }
        return null;
    }

    //Obtiene la estrategia que se está usando
    public Estrategia obtenerEstrategia(String nombre) {
        if (estrategias.containsKey(nombre)) {
            // System.out.println("Encuentra la estrategia");
            return estrategias.get(nombre);
        }
        return null;
    }

}
