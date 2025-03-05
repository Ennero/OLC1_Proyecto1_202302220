/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import utilidades.Expresion;
import utilidades.Instruccion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Instruccion;

/**
 *
 * @author Enner
 */


public class InstruccionEstrategia extends Instruccion{
    Expresion inicio;
    public ArrayList<Regla> reglas;
    public InstruccionEstrategia (Expresion inicio, ArrayList<Regla> reglas) {
        super(T_Instruccion.ESTRATEGIA);
        this.inicio = inicio;
        this.reglas = reglas;
    }

    @Override
    public void jugar(Entorno entorno) {
        inicio.jugar(entorno);
        for (Regla regla : reglas) {
            regla.jugar(entorno);
        }
    }
}