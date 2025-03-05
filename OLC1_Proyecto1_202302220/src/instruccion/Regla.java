/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instruccion;

import utilidades.Expresion;
import utilidades.Instruccion;
import olc1_proyecto1_202302220.Entorno;
import utilidades.T_Instruccion;

/**
 *
 * @author Enner
 */
public class Regla extends Instruccion {
    Expresion condicion;
    Expresion acion;
    public Regla(Expresion condicion, Expresion acion) {
        super(T_Instruccion.REGLA);
        this.condicion = condicion;
        this.acion = acion;
    }

    @Override
    public void jugar(Entorno entorno) {
        if (condicion != null) {
            condicion.jugar(entorno);
        }
        acion.jugar(entorno);
    }
}
