/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import abstractas.Instruccion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoInstruccion;
import utilidades.TipoSentencia;

/**
 *
 * @author Enner
 */
public class Todo extends Instruccion{
    
    //ArrayList<Inicio> todos= new ArrayList<>();
    private ArrayList<Inicio> todos;
    
    public Todo(ArrayList<Inicio>  todos) {
        super(TipoInstruccion.INICIAL);
        this.todos = (todos != null) ? todos : new ArrayList<>();
    }
     @Override
    public void jugar(Entorno entorno) {
        for (Inicio incios: todos){
            incios.jugar(entorno);
        }
    }
}
