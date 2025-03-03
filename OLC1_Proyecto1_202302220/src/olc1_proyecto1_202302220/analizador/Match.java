/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package olc1_proyecto1_202302220.analizador;

/**
 *
 * @author Enner
 */
public class Match {
    public String strategies;
    public int rounds;
    public int[] scoring;
    
    public Match(String strategies, int rounds,int[] scoring ){
        this.scoring=scoring;
        this.rounds=rounds;
        this.strategies=strategies;
    }
    
}
