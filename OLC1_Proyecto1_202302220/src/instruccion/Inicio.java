
package instruccion;

import utilidades.Expresion;
import utilidades.Instruccion;
import objetos.Estrategia;
import objetos.Partida;
import olc1_proyecto1_202302220.Entorno;
import utilidades.Salida;
import utilidades.T_Instruccion;

/**
 *
 * @author Enner
 */
public class Inicio extends Instruccion{
    Object partida;
    int rondas;
    boolean decision1;
    boolean decision2;
    int cooperacion = 0;
    int defeccion = 0;
    int traidor = 0;
    int traicionado = 0;
    int puntuacion1 = 0;
    int puntuacion2 = 0;
    int cooperacion1 =0;
    int cooperacion2 =0;

    Estrategia estrategia1;
    Estrategia estrategia2;
    public Inicio(Object partida) {
        super(T_Instruccion.MAIN);
        this.partida = partida;
    }

    @Override
    public void jugar(Entorno entorno) {
        Partida partida = entorno.obtenerPartida(this.partida.toString());
        if (partida != null) {
            this.rondas = (int) partida.rondas;
            entorno.setPartidaActual(partida);

            estrategia1 = entorno.obtenerEstrategia(partida.jugador1);
            estrategia2 = entorno.obtenerEstrategia(partida.jugador2);

            cooperacion = (int) partida.puntos.cooperacion.jugar(entorno).valor;
            defeccion = (int) partida.puntos.defeccion.jugar(entorno).valor;
            traidor = (int) partida.puntos.traidor.jugar(entorno).valor;
            traicionado = (int) partida.puntos.traicionado.jugar(entorno).valor;

            Salida.salidaInfo.add("=== PARTIDA ===");
            Salida.salidaInfo.add("CONFIGURACION:");
            Salida.salidaInfo.add("     Estrategias: " + estrategia1.nombre + " vs " + estrategia2.nombre);
            Salida.salidaInfo.add("     Rondas: " + rondas);
            Salida.salidaInfo.add("     Scoring: ");
            Salida.salidaInfo.add("         Cooperacion Mutua: " + cooperacion);
            Salida.salidaInfo.add("         Defeccion Mutua: " + defeccion);
            Salida.salidaInfo.add("         Traicion: " + traidor + "/" + traicionado + " (Traidor/Traicionado)");
            
            Salida.salidaInfo.add("DESARROLLO:");
            for (int i = 0; i < rondas; i++) {
                entorno.setRondaActual(i);
                if (i == 0) {
                    decision1 = decisionInicial(entorno, estrategia1);
                    decision2 = decisionInicial(entorno, estrategia2);
                    formato(i, estrategia1.nombre, estrategia2.nombre);
                } else {
                    decision1 = (boolean) validarRegla(entorno, estrategia1);
                    decision2 = (boolean) validarRegla(entorno, estrategia2);
                    formato(i, estrategia1.nombre, estrategia2.nombre);
                }
            }
        }
        Salida.salidaInfo.add("RESUMEN:");
        
        //Parte del primer jugador
        Salida.salidaInfo.add("     "+estrategia1.nombre + ":");
        Salida.salidaInfo.add("    - Puntuacion final: "+ puntuacion1);
        Salida.salidaInfo.add("    - Cooperaciones: "+ Math.round(cooperacion1/rondas)*100 + "%");
        Salida.salidaInfo.add("    - Defecciones: "+ Math.round((rondas-cooperacion1)/rondas)*100 + "%");
        
        //Parte del segundo jugador
        Salida.salidaInfo.add("     "+estrategia2.nombre + ":");
        Salida.salidaInfo.add("    - Puntuacion final: "+ puntuacion2);
        Salida.salidaInfo.add("    - Cooperaciones: "+ Math.round(cooperacion2/rondas)*100 + "%");
        Salida.salidaInfo.add("    - Defecciones: "+ Math.round((rondas-cooperacion2)/rondas)*100 + "%");

        
    }

    public boolean decisionInicial(Entorno entorno, Estrategia estrategia) {
        Expresion decisionInicial = estrategia.instrucciones.inicio;
        return (boolean) decisionInicial.jugar(entorno).valor;
    }

    public Object validarRegla(Entorno entorno, Estrategia estrategia) {
        Object decisonDefault = null;

        for (Regla regla : estrategia.instrucciones.reglas) {
            if (regla.condicion != null && (boolean) regla.condicion.jugar(entorno).valor) {
                // regla if CONDICION then ACCION 
                return regla.acion.jugar(entorno).valor;
            } else if (regla.condicion == null) {
                decisonDefault = regla.acion.jugar(entorno).valor;
            }
        }
        return decisonDefault;
    }

    
    //Funcion para que escriba la cosa como debe de ser de bonita
    public void formato(int i, String estrategia1, String estrategia2) {
        if (decision1 && decision2) {
            Salida.salidaInfo.add("     Ronda: " + (i+1) + ": " + estrategia1 + " = COOPERATE" + " , " + estrategia2 + " = COOPERATE (" + cooperacion + "-" + cooperacion + ")");
            puntuacion1 += cooperacion;
            puntuacion2 += cooperacion;
            cooperacion1++;
            cooperacion2++;
            
        } else if (!decision1 && !decision2) {
            Salida.salidaInfo.add("     Ronda: " + (i+1) + ": " + estrategia1 + " = DEFECT" + " , " + estrategia2 + " = DEFECT (" + defeccion + "-" + defeccion + ")");
            puntuacion1 += defeccion;
            puntuacion2 += defeccion;
            
        } else if (!decision1 && decision2) {
            Salida.salidaInfo.add("     Ronda: " + (i+1) + ": " + estrategia1 + " = DEFECT" + " , " + estrategia2 + " = COOPERATE (" + traidor + "-" + traicionado + ")");
            puntuacion1 += traidor;
            puntuacion2 += traicionado;
            cooperacion2++;
            
        } else {
            Salida.salidaInfo.add("     Ronda: " + (i+1) + ": " + estrategia1 + " = COOPERATE" + " , " + estrategia2 + " = DEFECT (" + traicionado + "-" + traidor + ")");
            puntuacion1 += traicionado;
            puntuacion2 += traidor;
            cooperacion1++;
        }
    }
}
