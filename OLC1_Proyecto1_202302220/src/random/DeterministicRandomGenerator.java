/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package random;

import java.util.Random;

/**
 *
 * @author Enner
 */
public class DeterministicRandomGenerator implements RandomGenerator{
    
    private final long originalSeed;
    
    private Random random;

    public DeterministicRandomGenerator(long seed) {
        this.originalSeed = seed;
        this.random = new Random(seed);
    }
    
    public static RandomGenerator create(long seed){
        return new DeterministicRandomGenerator(seed);
    }
    
    @Override
    public double nextDouble(){
        return random.nextDouble();
    }
    
    
}
