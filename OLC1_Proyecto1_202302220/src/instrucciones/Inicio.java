package instrucciones;

import abstractas.Expresion;
import abstractas.Instruccion;
import expresiones.Primitiva;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import olc1_proyecto1_202302220.Estrategia;
import olc1_proyecto1_202302220.Partida;
import olc1_proyecto1_202302220.Ambiente;
import olc1_proyecto1_202302220.juego;
import tipos.TipoInstruccion;
import tipos.TipoRetorno;
import java.text.DecimalFormat;
import random.DeterministicRandomGenerator;
import random.RandomGenerator;

/**
 *
 * @author Enner
 */
public class Inicio extends Instruccion {

    ArrayList<String> partidas;
    Expresion seed;
    int rondas;
    boolean decision1;
    boolean decision2;
    int cooperacion = 0;
    int defeccion = 0;
    int traidor = 0;
    int traicionado = 0;
    int puntuacion1 = 0;
    int puntuacion2 = 0;
    int cooperacion1 = 0;
    int cooperacion2 = 0;

    Estrategia estrategia1;
    Estrategia estrategia2;

    public Inicio(ArrayList<String> partidas, Expresion seed) {
        super(TipoInstruccion.MAIN);
        this.partidas = partidas;
        this.seed = seed;
    }

    @Override
    public void jugar(Ambiente entorno) {
        for (String nombrPartida : partidas) {
            Partida partida = entorno.obtenerPartida(nombrPartida);
            if (partida != null) {
                ejecutarPartida(entorno, partida);
            }
        }
    }

    public void ejecutarPartida(Ambiente entorno, Partida partida) {
        if (partida != null) {
            this.rondas = (int) partida.rondas;
            entorno.setPartidaActual(partida);
            entorno.setTotalRondas(rondas);

            //Aquí hago la cosita sobre la semilla
            TipoRetorno semilla = seed.jugar(entorno);
            long simillita=Long.parseLong(semilla.valor.toString());
            RandomGenerator gen1=DeterministicRandomGenerator.create(simillita);
            System.out.println("La semilla es: "+ simillita);
            entorno.setRandomGenerator(gen1);

            estrategia1 = entorno.obtenerEstrategia(partida.jugador1);
            System.out.println("Estrategia 1 leida");
            estrategia2 = entorno.obtenerEstrategia(partida.jugador2);
            System.out.println("Estrategia 2 leida");

            // Reiniciar historial y estado de estrategias
            //estrategia1.historial.clear();
            //estrategia2.historial.clear();
            //estrategia1.state = false;
            //estrategia2.state = false;

            System.out.println("Limpieza de estrategias");
            
            // Reiniciar puntuaciones y contadores
            puntuacion1 = 0;
            puntuacion2 = 0;
            cooperacion1 = 0;
            cooperacion2 = 0;

            cooperacion = (int) partida.puntos.cooperacion.jugar(entorno).valor;
            defeccion = (int) partida.puntos.defeccion.jugar(entorno).valor;
            traidor = (int) partida.puntos.traidor.jugar(entorno).valor;
            traicionado = (int) partida.puntos.traicionado.jugar(entorno).valor;
            
            System.out.println("Comienzo de la partida");
            juego.salidaInfo.add("=== PARTIDA ===");
            juego.salidaInfo.add("CONFIGURACION:");
            juego.salidaInfo.add("     Estrategias: " + estrategia1.nombre + " vs " + estrategia2.nombre);
            juego.salidaInfo.add("     Rondas: " + rondas);
            juego.salidaInfo.add("     Scoring: ");
            juego.salidaInfo.add("         Cooperacion Mutua: " + cooperacion);
            juego.salidaInfo.add("         Defeccion Mutua: " + defeccion);
            juego.salidaInfo.add("         Traicion: " + traidor + "/" + traicionado + " (Traidor/Traicionado)");

            juego.salidaInfo.add("DESARROLLO:");
            for (int i = 0; i < rondas; i++) {
                entorno.setRondaActual(i);
                if (i == 0) {
                    decision1 = decisionInicial(entorno, estrategia1);
                    decision2 = decisionInicial(entorno, estrategia2);
                } else {
                    System.out.println("------Validando Reglas------");
                    System.out.println("Ronda " + (i + 1));
                    decision1 = (boolean) validarRegla(entorno, estrategia1);
                    decision2 = (boolean) validarRegla(entorno, estrategia2);

                    System.out.println("decision 1 = " + decision1);
                    System.out.println("decision 2 = " + decision2);

                }
                estrategia1.historial.add(decision1);
                estrategia2.historial.add(decision2);
                formato(i, estrategia1.nombre, estrategia2.nombre);
            }
        }
        juego.salidaInfo.add("RESUMEN:");

        DecimalFormat df = new DecimalFormat("0.00");
        //Parte del primer jugador
        juego.salidaInfo.add("     " + estrategia1.nombre + ":");
        juego.salidaInfo.add("    - Puntuacion final: " + puntuacion1);

        //Aqui calculo de mejor forma los porcentajes
        double porcentajeCoop1 = ((double) cooperacion1 / rondas) * 100;
        double porcentajeDefc1 = ((double) (rondas - cooperacion1) / rondas) * 100;

        juego.salidaInfo.add("    - Cooperaciones: " + df.format(porcentajeCoop1) + "%");
        juego.salidaInfo.add("    - Defecciones: " + df.format(porcentajeDefc1) + "%");

        //Parte del segundo jugador
        juego.salidaInfo.add("     " + estrategia2.nombre + ":");
        juego.salidaInfo.add("    - Puntuacion final: " + puntuacion2);
        
        double porcentajeCoop2 = ((double) cooperacion2 / rondas) * 100;
        double porcentajeDefc2 = ((double) (rondas - cooperacion2) / rondas) * 100;

        juego.salidaInfo.add("    - Cooperaciones: " + df.format(porcentajeCoop2) + "%");
        juego.salidaInfo.add("    - Defecciones: " + df.format(porcentajeDefc2) + "%");
    }

    public boolean decisionInicial(Ambiente entorno, Estrategia estrategia) {
        Expresion decisionInicial = estrategia.instrucciones.inicio;
        //estrategia.historial.add(decisionInicial.jugar(entorno).valor);
        return (boolean) decisionInicial.jugar(entorno).valor;
    }

    public Object validarRegla(Ambiente entorno, Estrategia estrategia) {
        Object determinada = null;

        ArrayList<Regla> reglaOrdenada = new ArrayList<>(estrategia.instrucciones.reglas);
        Collections.reverse(reglaOrdenada);
        for (Regla regla : reglaOrdenada) {

            estrategia.state = true;
            System.out.println("Aqui comienzo con las condiciones");
            if (regla.condicion != null && (boolean) regla.condicion.jugar(entorno).valor) {
                // regla if CONDICION then ACCION 
                System.out.println("Aqui ejecuto la solución");
                estrategia.state=false;
                return regla.acion.jugar(entorno).valor;
            } else if (regla.condicion == null) {
                estrategia.state=true;
                determinada = regla.acion.jugar(entorno).valor;
                estrategia.state=false;
            }
            estrategia.state = false;
        }
        return determinada; //Después puede que lo cambie para que se false porque no estoy seguro de como debería de funcionar
    }

    //Funcion para que escriba la cosa como debe de ser de bonita
    public void formato(int i, String estrategia1, String estrategia2) {
        if (decision1 && decision2) {
            juego.salidaInfo.add("     Ronda: " + (i + 1) + ": " + estrategia1 + " = COOPERATE" + " , " + estrategia2 + " = COOPERATE (" + cooperacion + "-" + cooperacion + ")");
            puntuacion1 += cooperacion;
            puntuacion2 += cooperacion;
            cooperacion1++;
            cooperacion2++;

        } else if (!decision1 && !decision2) {
            juego.salidaInfo.add("     Ronda: " + (i + 1) + ": " + estrategia1 + " = DEFECT" + " , " + estrategia2 + " = DEFECT (" + defeccion + "-" + defeccion + ")");
            puntuacion1 += defeccion;
            puntuacion2 += defeccion;

        } else if (!decision1 && decision2) {
            juego.salidaInfo.add("     Ronda: " + (i + 1) + ": " + estrategia1 + " = DEFECT" + " , " + estrategia2 + " = COOPERATE (" + traidor + "-" + traicionado + ")");
            puntuacion1 += traidor;
            puntuacion2 += traicionado;
            cooperacion2++;

        } else {
            juego.salidaInfo.add("     Ronda: " + (i + 1) + ": " + estrategia1 + " = COOPERATE" + " , " + estrategia2 + " = DEFECT (" + traicionado + "-" + traidor + ")");
            puntuacion1 += traicionado;
            puntuacion2 += traidor;
            cooperacion1++;
        }
    }
}
