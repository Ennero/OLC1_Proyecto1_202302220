/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoExpresion;

import abstractas.Expresion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoRetorno;
import tipos.TipoTipo;

/**
 *
 * @author Enner
 */
public class Lista extends Expresion {

    ArrayList<Expresion> elementos;

    public Lista(ArrayList<Expresion> lista) {
        super(tipos.TipoExpresion.LISTA);
        this.elementos = lista;
    }

    @Override
    public TipoRetorno jugar(Ambiente ambiente) {
        ArrayList<Boolean> valores = new ArrayList<>();
        for (Expresion exp : elementos) {
            TipoRetorno resultado = exp.jugar(ambiente);

            //Voy añadiendo lo booleanos
            if (resultado.tipo == TipoTipo.DECISION) {
                valores.add((Boolean) resultado.valor);
            } else {
                return null;
            }
        }
        return new TipoRetorno(valores, TipoTipo.LISTA);
    }
}
