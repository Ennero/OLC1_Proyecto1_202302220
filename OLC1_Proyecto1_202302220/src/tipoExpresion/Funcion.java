package tipoExpresion;

import abstractas.Expresion;
import java.util.ArrayList;
import olc1_proyecto1_202302220.Estrategia;
import olc1_proyecto1_202302220.Ambiente;
import tipos.TipoExpresion;
import tipos.TipoRetorno;
import tipos.TipoTipo;

/**
 *
 * @author Enner
 */
public class Funcion extends Expresion {

    public String funcion;
    public Expresion expresion1;
    public Expresion expresion2;

    public Funcion(String funcion, Expresion exp1, Expresion exp2) {
        super(TipoExpresion.FUNCION);
        this.funcion = funcion;
        this.expresion1 = exp1;
        this.expresion2 = exp2;
    }

    @Override
    public TipoRetorno jugar(Ambiente ambiente) {

        System.out.println("dentro de jugar");

        //Aqui hago un switch case dependiento de que hay dentro de cada una de las funciones
        switch (funcion) {
            case "get_move" -> {
                return getMove(ambiente);
            }
            case "last_move" -> {
                return lastMove(ambiente);
            }
            case "get_moves_count" -> {
                return getMovesCount(ambiente);
            }
            case "get_last_n_moves" -> {
                return getLastNMoves(ambiente);
            }
            default -> {
                return null;
            }
        }
    }

    public TipoRetorno getMove(Ambiente ambiente) {
        Estrategia estrategia1 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador1);
        Estrategia estrategia2 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador2);

        System.out.println("Estoy dentro de getMove");
        //la ronda que quiero buscar
        System.out.println(expresion1.jugar(ambiente));
        int rondonda = (int) expresion2.jugar(ambiente).valor;
        String funcioncita = (String) (expresion1.jugar(ambiente).valor);
        System.out.println(funcioncita);

        if (rondonda < 0 || rondonda >= ambiente.getRondaActual()) {
            return null;
        }
        if (rondonda < 0 || rondonda >= ambiente.getRondaActual()
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
        //Para que me de error
        return null;
    }

    public TipoRetorno lastMove(Ambiente ambiente) {
        Estrategia estrategia1 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador1);
        Estrategia estrategia2 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador2);

        String funcioncita = String.valueOf(expresion1.jugar(ambiente).valor);

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
        System.out.println("LAST_MOVE es nulo");
        return null;
    }

    public TipoRetorno getMovesCount(Ambiente ambiente) {
        Estrategia estrategia1 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador1);
        Estrategia estrategia2 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador2);

        System.out.println("Estrategia1 " + estrategia1.state);
        System.out.println("Estrategia2 " + estrategia2.state);

        String funcioncita = String.valueOf(expresion1.jugar(ambiente).valor);
        Object decisionObj = expresion2.jugar(ambiente).valor;

        if (!(decisionObj instanceof Boolean)) {
            System.out.println("EL BOOLEANO DE MOVESCOUNT ESTÁ MALLLLL");
        }

        boolean decision = (boolean) decisionObj;
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
            if (decisionini == decision) {  // Filtramos los valores correctos
                contador++;
            }
        }
        System.out.println("De la cuenta se obtuvo: " + funcioncita + ", " + decision + "un total de " + contador);
        return new TipoRetorno(contador, TipoTipo.ENTERO);
    }

    public TipoRetorno getLastNMoves(Ambiente ambiente) {

        Estrategia estrategia1 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador1);
        Estrategia estrategia2 = ambiente.obtenerEstrategia(ambiente.getPartidaActual().jugador2);

        String funcioncita = String.valueOf(expresion1.jugar(ambiente).valor);
        int numero = (int) expresion2.jugar(ambiente).valor;

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
