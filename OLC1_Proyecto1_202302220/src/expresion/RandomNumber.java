
package expresion;

import abstractas.Expresion;
import olc1_proyecto1_202302220.Entorno;
import random.DeterministicRandomGenerator;
import random.RandomGenerator;
import utilidades.TipoExpresion;
import utilidades.TipoRetorno;
import utilidades.TipoTipo;

/**
 *
 * @author Enner
 */
public class RandomNumber extends Expresion {
    
    public RandomNumber() {
        super(TipoExpresion.PRIMITIVO);
    }
    
    @Override
    public TipoRetorno jugar(Entorno entorno) {        
        RandomGenerator gen1 = entorno.getRandomGenerator();
        double numerito=gen1.nextDouble();
        System.out.println("Numero aleatorio: "+numerito);
        return new TipoRetorno(numerito, TipoTipo.FLOTANTE);
    }
}
