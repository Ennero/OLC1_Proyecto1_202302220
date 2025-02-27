/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composite;

import contracts.IBlock;
import java.util.LinkedList;

/**
 *
 * @author Enner
 */
public class mainStmt implements IBlock{
    
    public LinkedList<runStmt> runlist;
    public mainStmt(LinkedList<runStmt> runlist){
        
    }
    
}
