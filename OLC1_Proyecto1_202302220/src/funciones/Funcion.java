package funciones;

import abstractas.Expresion;
import java.util.ArrayList;
import objetos.Estrategia;
import olc1_proyecto1_202302220.Entorno;
import utilidades.TipoExpresion;
import utilidades.TipoRetorno;
import utilidades.TipoTipo;

/**
 *
 * @author Enner
 */
public class Funcion extends Expresion {

    public String funcion;
    public Expresion exp1;
    public Expresion exp2;

    public Funcion(String funcion, Expresion exp1, Expresion exp2) {
        super(TipoExpresion.FUNCION);
        this.funcion = funcion;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {

        System.out.println("dentro de jugar");

        //Aqui hago un switch case dependiento de que hay dentro de cada una de las funciones
        switch (funcion) {
            case "get_move" -> {
                return getMove(entorno);
            }
            case "last_move" -> {
                return lastMove(entorno);
            }
            case "get_moves_count" -> {
                return getMovesCount(entorno);
            }
            case "get_last_n_moves" -> {
                return getLastNMoves(entorno);
            }
            default -> {
                return null;
            }
        }
    }

    public TipoRetorno getMove(Entorno entorno) {
        Estrategia estrategia1 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador1);
        Estrategia estrategia2 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador2);

        System.out.println("Estoy dentro de getMove");
        //la ronda que quiero buscar
        System.out.println(exp1.jugar(entorno));
        int rondonda = (int) exp2.jugar(entorno).valor;
        String funcioncita = (String) (exp1.jugar(entorno).valor);
        System.out.println(funcioncita);

        if (rondonda < 0 || rondonda >= entorno.getRondaActual()) {
            return null;
        }
        if (rondonda < 0 || rondonda >= entorno.getRondaActual()
                || rondonda >= estrategia1.historial.size() || rondonda >= estrategia2.historial.size()) {
            return null;
        }

        if (funcioncita.equals("opponent_history")) {
            if (!estrategia1.state && estrategia2.state) {
                boolean valor = estrategia1.historial.get(rondonda);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
            if (!estrategia2.state && estrategia1.state) {
                boolean valor = estrategia2.historial.get(rondonda);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
        }
        if (funcioncita.equals("self_history")) {
            if (!estrategia1.state && estrategia2.state) {
                boolean valor = estrategia2.historial.get(rondonda);  // Debe ser estrategia1, no estrategia2
                System.out.println("El valor de la funcion Get_Move (self_history): " + valor);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
            if (!estrategia2.state && estrategia1.state) {
                boolean valor = estrategia1.historial.get(rondonda);  // Debe ser estrategia2, no estrategia1
                System.out.println("El valor de la funcion Get_Move (self_history): " + valor);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
        }
        return null;
    }

    public TipoRetorno lastMove(Entorno entorno) {
        Estrategia estrategia1 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador1);
        Estrategia estrategia2 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador2);

        String funcioncita = String.valueOf(exp1.jugar(entorno).valor);

        if (funcioncita.equals("opponent_history")) {
            if (!estrategia1.state && estrategia2.state && !estrategia1.historial.isEmpty()) {
                boolean valor = estrategia1.historial.get(estrategia1.historial.size() - 1);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
            if (!estrategia2.state && estrategia1.state && !estrategia2.historial.isEmpty()) {
                boolean valor = estrategia2.historial.get(estrategia2.historial.size() - 1);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
        }
        if (funcioncita.equals("self_history")) {
            if (!estrategia1.state && estrategia2.state && !estrategia1.historial.isEmpty()) {
                boolean valor = estrategia2.historial.get(estrategia2.historial.size() - 1);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
            if (!estrategia2.state && estrategia1.state && !estrategia2.historial.isEmpty()) {
                boolean valor = estrategia1.historial.get(estrategia1.historial.size() - 1);
                return new TipoRetorno(valor, TipoTipo.DECISION);
            }
        }
        return null;
    }

    public TipoRetorno getMovesCount(Entorno entorno) {
        Estrategia estrategia1 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador1);
        Estrategia estrategia2 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador2);

        String funcioncita = String.valueOf(exp1.jugar(entorno).valor);
        boolean decision = (boolean) exp2.jugar(entorno).valor;

        Estrategia estrategiaSeleccionada = null;

        if (funcioncita.equals("opponent_history")) {
            if (!estrategia1.state && estrategia2.state) {
                estrategiaSeleccionada = estrategia1;
            } else if (!estrategia2.state && estrategia1.state) {
                estrategiaSeleccionada = estrategia2;
            }
        } else if (funcioncita.equals("self_history")) {
            if (!estrategia1.state && estrategia2.state) {
                estrategiaSeleccionada = estrategia2;
            } else if (!estrategia2.state && estrategia1.state) {
                estrategiaSeleccionada = estrategia1;
            }
        }

        if (estrategiaSeleccionada == null || estrategiaSeleccionada.historial.isEmpty()) {
            return new TipoRetorno(0, TipoTipo.ENTERO);
        }

        //Aqui voy a comenzar a hallar las veces que se repite cada uno
        int contador = 0;
        for (boolean decisionini : estrategiaSeleccionada.historial) {
            contador++;
        }
        return new TipoRetorno(contador, TipoTipo.ENTERO);
    }

    public TipoRetorno getLastNMoves(Entorno entorno) {

        Estrategia estrategia1 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador1);
        Estrategia estrategia2 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador2);

        String funcioncita = String.valueOf(exp1.jugar(entorno).valor);
        int numero = (int) exp2.jugar(entorno).valor;

        Estrategia estrategiaSeleccionada = null;

        if (funcioncita.equals("opponent_history")) {
            if (!estrategia1.state && estrategia2.state) {
                estrategiaSeleccionada = estrategia1;
            } else if (!estrategia2.state && estrategia1.state) {
                estrategiaSeleccionada = estrategia2;
            }
        } else if (funcioncita.equals("self_history")) {
            if (!estrategia1.state && estrategia2.state) {
                estrategiaSeleccionada = estrategia2;
            } else if (!estrategia2.state && estrategia1.state) {
                estrategiaSeleccionada = estrategia1;
            }
        }

        int tamaño = estrategiaSeleccionada.historial.size();
        int puntoInicial = Math.max(0, tamaño - numero);

        //Ahora obtengo los último N movimientos
        ArrayList<Boolean> ultimosMovimientos = new ArrayList(estrategiaSeleccionada.historial.subList(puntoInicial, tamaño));

        return new TipoRetorno(ultimosMovimientos, TipoTipo.LISTA);
    }
}
