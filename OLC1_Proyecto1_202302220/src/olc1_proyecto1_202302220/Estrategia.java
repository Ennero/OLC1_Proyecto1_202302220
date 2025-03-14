/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc1_proyecto1_202302220;

import instrucciones.InstruccionEstrategia;
import java.util.ArrayList;

/**
 *
 * @author Enner
 */
public class Estrategia {
    
    public String nombre;
    public InstruccionEstrategia instrucciones;
    public ArrayList<Boolean> historial = new ArrayList<>(); 
    public boolean state;
    public Estrategia (String nombre, InstruccionEstrategia instrucciones){
        this.nombre = nombre;
        this.instrucciones=instrucciones;
    }
    
}
