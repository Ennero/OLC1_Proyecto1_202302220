/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoInstruccion;

import abstractas.Expresion;
import abstractas.Instruccion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;

/**
 *
 * @author Enner
 */
public class InstruccionEstrategia extends Instruccion {

    Expresion inicio;
    public ArrayList<Regla> reglas;

    public InstruccionEstrategia(Expresion inicio, ArrayList<Regla> reglas) {
        super(TipoInstruccion.ESTRATEGIA);
        this.inicio = inicio;
        this.reglas = reglas;
    }

    @Override
    public void jugar(Ambiente ambiente) {
        //Juego la estrategia
        inicio.jugar(ambiente);
        //Y también cada una de sus reglas
        for (Regla regla : reglas) {
            regla.jugar(ambiente);
        }
    }
}
