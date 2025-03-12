
package funciones;

import abstractas.Expresion;
import expresion.History;
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
    public History exp1;
    public Expresion exp2;

    public Funcion(String funcion, History exp1, Expresion exp2) {
        super(TipoExpresion.FUNCION);
        this.funcion = funcion;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public TipoRetorno jugar(Entorno entorno) {
        
        //Aqui hago un switch case dependiento de que hay dentro de cada una de las funciones
        switch (funcion){
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
            default ->{
                return null;
            }
        }
    }
    
    public TipoRetorno getMove(Entorno entorno){
        Estrategia estrategia1 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador1);
        Estrategia estrategia2 = entorno.obtenerEstrategia(entorno.getPartidaActual().jugador2);
        
        //la ronda que quiero buscar
        System.out.println(exp1.history);
        int rondonda =(int) exp2.jugar(entorno).valor;
        String funcioncita= exp1.history;
        
        
        if(rondonda <0 || rondonda >=entorno.getRondaActual()) return null;
        
        if (funcioncita.equals("opponent_history")){
            if (!estrategia1.state && estrategia2.state){
                boolean valor= estrategia1.historial.get(rondonda);
                return new TipoRetorno(valor,TipoTipo.DECISION);
                
            }
            if(!estrategia2.state && estrategia1.state){
                boolean valor= estrategia2.historial.get(rondonda);
                return new TipoRetorno(valor,TipoTipo.DECISION);
            }
        }
        if (funcioncita.equals("self_history")){
            if (!estrategia1.state && estrategia2.state){
                boolean valor= estrategia2.historial.get(rondonda);
                return new TipoRetorno(valor,TipoTipo.DECISION);
                
            }
            if(!estrategia2.state && estrategia1.state){
                boolean valor= estrategia1.historial.get(rondonda);
                return new TipoRetorno(valor,TipoTipo.DECISION);
            }
        }
        return null;        
    }
    
    
    public TipoRetorno lastMove(Entorno entorno){
        Estrategia estrategia1= entorno.obtenerEstrategia(entorno.getPartidaActual().jugador1);
        Estrategia estrategia2= entorno.obtenerEstrategia(entorno.getPartidaActual().jugador2);
        
        String funcioncita=String.valueOf(exp1.jugar(entorno).valor);
        
        if (funcioncita.equals("opponent_history")){
            if (!estrategia1.state && estrategia2.state && !estrategia1.historial.isEmpty()){
                boolean valor= estrategia1.historial.get(estrategia1.historial.size()-1);
                return new TipoRetorno(valor,TipoTipo.DECISION);
                
            }
            if(!estrategia2.state && estrategia1.state && !estrategia2.historial.isEmpty()){
                boolean valor= estrategia2.historial.get(estrategia2.historial.size()-1);
                return new TipoRetorno(valor,TipoTipo.DECISION);
            }
        }
        if (funcioncita.equals("self_history")){
            if (!estrategia1.state && estrategia2.state && !estrategia2.historial.isEmpty()){
                boolean valor= estrategia2.historial.get(estrategia2.historial.size()-1);
                return new TipoRetorno(valor,TipoTipo.DECISION);
                
            }
            if(!estrategia2.state && estrategia1.state && !estrategia1.historial.isEmpty()){
                boolean valor= estrategia1.historial.get(estrategia1.historial.size()-1);
                return new TipoRetorno(valor,TipoTipo.DECISION);
            }
        }
        
        
        
        
        
        
        return null;
        
    }
    
    public TipoRetorno getMovesCount(Entorno entorno){
        return null;
    }
    
    
    public TipoRetorno getLastNMoves(Entorno entorno){
        return null;
    }
    
    
    
    
    
    
    
}
