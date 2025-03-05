/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import utilidades.T_Sentencia;

/**
 *
 * @author Enner
 */

public abstract class Sentencia {
    T_Sentencia tipoSetencia;
    public Sentencia(T_Sentencia tipoSetencia) {
        this.tipoSetencia = tipoSetencia;
    }
}