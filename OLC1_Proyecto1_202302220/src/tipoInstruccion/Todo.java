/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoInstruccion;

import abstractas.Instruccion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoInstruccion;
import tipos.TipoSentencia;

/**
 *
 * @author Enner
 */
public class Todo extends Instruccion {

    //ArrayList<Inicio> todos= new ArrayList<>();
    private ArrayList<Inicio> todos;

    //Constructor
    public Todo(ArrayList<Inicio> todos) {
        super(TipoInstruccion.INICIAL);
        this.todos = (todos != null) ? todos : new ArrayList<>();
    }

    @Override
    public void jugar(Ambiente ambiente) {
        //Recorro todos los inicios
        for (Inicio incios : todos) {
            incios.jugar(ambiente);
        }
    }
}
