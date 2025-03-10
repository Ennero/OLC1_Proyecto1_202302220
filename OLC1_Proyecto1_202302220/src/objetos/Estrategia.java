/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import instruccion.InstruccionEstrategia;
import java.util.ArrayList;

/**
 *
 * @author Enner
 */
public class Estrategia {
    
    public String nombre;
    public ArrayList<Object> historial;
    public InstruccionEstrategia instrucciones;
    public Estrategia (String nombre, InstruccionEstrategia instrucciones){
        this.nombre = nombre;
        this.instrucciones=instrucciones;
    }
    
}
