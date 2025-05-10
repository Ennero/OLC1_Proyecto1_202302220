package tipoInstruccion;

import abstractas.Expresion;
import abstractas.Instruccion;
import tipoExpresion.Primitiva;
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

    //Declaro todo
    ArrayList<String> partidas;
    Expresion seed;
    int rondas;
    boolean decision1;
    boolean decision2;
    int cooperacion = 0;
    int defeccion = 0;
    int traidor = 0;
    int traicionado = 0;
    int p1 = 0;
    int p2 = 0;
    int coop1 = 0;
    int coop2 = 0;

    Estrategia estrategia1;
    Estrategia estrategia2;

    public Inicio(ArrayList<String> partidas, Expresion seed) {
        super(TipoInstruccion.MAIN);
        this.partidas = partidas;
        this.seed = seed;
    }

    @Override
    public void jugar(Ambiente ambiente) {
        for (String nombrPartida : partidas) {
            Partida partida = ambiente.obtenerPartida(nombrPartida);
            if (partida != null) {
                ejecutarPartida(ambiente, partida);
            }
        }
    }

    //Parte para ejecutar la partida
    public void ejecutarPartida(Ambiente ambiente, Partida partida) {
        if (partida != null) {
            this.rondas = (int) partida.rondas;
            ambiente.setPartidaActual(partida);
            ambiente.setTotalRondas(rondas);

            //Aquí hago la cosita sobre la semilla
            TipoRetorno semilla = seed.jugar(ambiente);
            long simillita = Long.parseLong(semilla.valor.toString());
            RandomGenerator gen1 = DeterministicRandomGenerator.create(simillita);
            System.out.println("La semilla es: " + simillita);
            ambiente.setRandomGenerator(gen1);

            estrategia1 = ambiente.obtenerEstrategia(partida.jugador1);
            System.out.println("Estrategia 1 leida");
            estrategia2 = ambiente.obtenerEstrategia(partida.jugador2);
            System.out.println("Estrategia 2 leida");

            // Reiniciar historial y estado de estrategias
            //estrategia1.historial.clear();
            //estrategia2.historial.clear();
            //estrategia1.state = false;
            //estrategia2.state = false;
            System.out.println("Limpieza de estrategias");

            // Reiniciar puntuaciones y contadores
            p1 = 0;
            p2 = 0;
            coop1 = 0;
            coop2 = 0;

            //Obtengo los puntos de las partidas
            cooperacion = (int) partida.puntos.cooperacion.jugar(ambiente).valor;
            defeccion = (int) partida.puntos.defeccion.jugar(ambiente).valor;
            traidor = (int) partida.puntos.traidor.jugar(ambiente).valor;
            traicionado = (int) partida.puntos.traicionado.jugar(ambiente).valor;

            // Mostrar configuración de la partida
            juego.salidona.add("=== INICIO DE PARTIDA ===");
            juego.salidona.add("Configuración:");
            juego.salidona.add("  Estrategias: " + estrategia1.nombre + " vs " + estrategia2.nombre);
            juego.salidona.add("  Rondas: " + rondas);
            juego.salidona.add("  Puntuación:");
            juego.salidona.add("    Cooperación mutua: " + cooperacion);
            juego.salidona.add("    Defección mutua: " + defeccion);
            juego.salidona.add("    Traición: " + traidor + "/" + traicionado + " (Traidor/Traicionado)");

            // Desarrollo de la partida
            juego.salidona.add("Desarrollo:");
            for (int i = 0; i < rondas; i++) {
                ambiente.setRondaActual(i);
                if (i == 0) {
                    decision1 = decisionInicial(ambiente, estrategia1);
                    decision2 = decisionInicial(ambiente, estrategia2);
                } else {
                    System.out.println("  Validando reglas - Ronda " + (i + 1));
                    decision1 = (boolean) validarRegla(ambiente, estrategia1);
                    decision2 = (boolean) validarRegla(ambiente, estrategia2);
                    System.out.println("    Decisión " + estrategia1.nombre + ": " + decision1);
                    System.out.println("    Decisión " + estrategia2.nombre + ": " + decision2);
                }
                estrategia1.historial.add(decision1);
                estrategia2.historial.add(decision2);
                formato(i, estrategia1.nombre, estrategia2.nombre);
            }

            // Resumen de la partida
            juego.salidona.add("=== RESUMEN DE PARTIDA ===");
            DecimalFormat df = new DecimalFormat("0.00");

            juego.salidona.add("  " + estrategia1.nombre + ":");
            juego.salidona.add("    Puntuación final: " + p1);
            double porcentajeCoop1 = ((double) coop1 / rondas) * 100;
            double porcentajeDefc1 = ((double) (rondas - coop1) / rondas) * 100;
            juego.salidona.add("    Cooperaciones: " + df.format(porcentajeCoop1) + "%");
            juego.salidona.add("    Defecciones: " + df.format(porcentajeDefc1) + "%");

            juego.salidona.add("  " + estrategia2.nombre + ":");
            juego.salidona.add("    Puntuación final: " + p2);
            double porcentajeCoop2 = ((double) coop2 / rondas) * 100;
            double porcentajeDefc2 = ((double) (rondas - coop2) / rondas) * 100;
            juego.salidona.add("    Cooperaciones: " + df.format(porcentajeCoop2) + "%");
            juego.salidona.add("    Defecciones: " + df.format(porcentajeDefc2) + "%");

        }
    }

    //Decision Inicial
    public boolean decisionInicial(Ambiente ambiente, Estrategia estrategia) {
        Expresion decisionInicial = estrategia.instrucciones.inicio;
        //estrategia.historial.add(decisionInicial.jugar(ambiente).valor);
        return (boolean) decisionInicial.jugar(ambiente).valor;
    }

    public Object validarRegla(Ambiente ambiente, Estrategia estrategia) {
        Object determinada = null;
        //Aquí agarro el arreglo y lo pongo al revez porque se recoje al revez xd
        ArrayList<Regla> reglaOrdenada = new ArrayList<>(estrategia.instrucciones.reglas);
        Collections.reverse(reglaOrdenada);
        for (Regla regla : reglaOrdenada) {
            //Activo la estrategia
            estrategia.state = true;
            System.out.println("Aqui comienzo con las condiciones");
            if (regla.condicion != null && (boolean) regla.condicion.jugar(ambiente).valor) {
                System.out.println("Aqui ejecuto la solución");
                //Desactivo la estrategia
                estrategia.state=true;                
                Object reglita=regla.acion.jugar(ambiente).valor;
                estrategia.state=false;
                return reglita;
            } else if (regla.condicion == null) {
                //Activo la estrategia
                estrategia.state = true;
                determinada = regla.acion.jugar(ambiente).valor;
                //Desactivo la estrategia
                estrategia.state = false;
            }
            estrategia.state = false;
        }
        return determinada; //Después puede que lo cambie para que se false porque no estoy seguro de como debería de funcionar
    }

    //Funcion para que escriba la cosa como debe de ser de bonita
    public void formato(int numeroRonda, String nombreEstrategia1, String nombreEstrategia2) {
        String resultado;
        String accionJugador1 = decision1 ? "COOPERATE" : "DEFECT";
        String accionJugador2 = decision2 ? "COOPERATE" : "DEFECT";
        String puntuacion;

        if (decision1 && decision2) {
            puntuacion = cooperacion + "-" + cooperacion;
            p1 += cooperacion;
            p2 += cooperacion;
            coop1++;
            coop2++;
        } else if (!decision1 && !decision2) {
            puntuacion = defeccion + "-" + defeccion;
            p1 += defeccion;
            p2 += defeccion;
        } else if (!decision1 && decision2) {
            puntuacion = traidor + "-" + traicionado;
            p1 += traidor;
            p2 += traicionado;
            coop2++;
        } else {
            puntuacion = traicionado + "-" + traidor;
            p1 += traicionado;
            p2 += traidor;
            coop1++;
        }

        resultado = String.format("    Ronda: %d: %s = %s, %s = %s (%s)",
                numeroRonda + 1, nombreEstrategia1, accionJugador1, nombreEstrategia2, accionJugador2, puntuacion);

        juego.salidona.add(resultado);
    }
}
