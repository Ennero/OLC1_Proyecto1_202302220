
package expresiones;

import abstractas.Expresion;
import olc1_proyecto1_202302220.Ambiente;
import random.DeterministicRandomGenerator;
import random.RandomGenerator;
import tipos.TipoExpresion;
import tipos.TipoRetorno;
import tipos.TipoTipo;

/**
 *
 * @author Enner
 */
public class RandomNumber extends Expresion {
    
    public RandomNumber() {
        super(TipoExpresion.PRIMITIVO);
    }
    
    @Override
    public TipoRetorno jugar(Ambiente entorno) {        
        RandomGenerator gen1 = entorno.getRandomGenerator();
        double numerito=gen1.nextDouble();
        System.out.println("Numero aleatorio: "+numerito);
        return new TipoRetorno(numerito, TipoTipo.FLOTANTE);
    }
}
