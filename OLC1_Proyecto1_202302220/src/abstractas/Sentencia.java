/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractas;

import utilidades.TipoSentencia;

/**
 *
 * @author Enner
 */

public abstract class Sentencia {
    TipoSentencia tipoSetencia;
    public Sentencia(TipoSentencia tipoSetencia) {
        this.tipoSetencia = tipoSetencia;
    }
}