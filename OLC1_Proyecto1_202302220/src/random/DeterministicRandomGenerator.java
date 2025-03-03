
package random;

import java.util.Random;
import java.util.random.RandomGenerator;

/**
 *
 * @author Enner
 */
public class DeterministicRandomGenerator implements RandomGenerator{
    private long originalSeed;
    
    private Random random;
    
    private DeterministicRandomGenerator(long seed){
        this.originalSeed=seed;
        this.random=new Random(seed);
    }
    
    public static RandomGenerator create(long seed){
        return new DeterministicRandomGenerator(seed);
    }
    
    @Override
    public double nextDouble(){
        return random.nextDouble();
    }

    @Override
    public double nextDouble(double bound) {
        return RandomGenerator.super.nextDouble(bound); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public long nextLong() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
