/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

/**
 *
 * @author Enner
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    
    
    //Creo la linkedList que tendrá todo los datos de los tokens
    static public LinkedList<String[]> tokens = new LinkedList<>();
    static public LinkedList<String[]> errores = new LinkedList<>();
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        System.out.println("Iniciando el programa");
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        
    }
    
    
    
    //Función para el análisis léxico
    static public void analisisLexico(String input) throws IOException {
        Lexer lexer = new Lexer(new StringReader(input));
        Symbol token;
        int contador1 = 0;
        int contador2 = 0;
        while ((token = lexer.next_token()).sym != sym.EOF) {
            // Incrementa el contador

            // Si es un error, agregar al arreglo de errores
            if (sym.terminalNames[token.sym].equals("ERROR_LEXICO")) {
                // Crea un nuevo arreglo para el token
                contador1++;
                String[] arreglo = new String[5];
                arreglo[0] = Integer.toString(contador1);
                arreglo[1] = sym.terminalNames[token.sym];
                arreglo[2] = token.value.toString();
                arreglo[3] = Integer.toString(token.left);
                arreglo[4] = Integer.toString(token.right);

                errores.add(arreglo);
                //break;
            } else {
                contador2++;
                // Crea un nuevo arreglo para el token
                String[] arreglo = new String[5];
                arreglo[0] = Integer.toString(contador2);
                arreglo[1] = sym.terminalNames[token.sym];
                arreglo[2] = token.value.toString();
                arreglo[3] = Integer.toString(token.left);
                arreglo[4] = Integer.toString(token.right);

                // Si no es un error, agregar al arreglo de tokens
                tokens.add(arreglo);
            }
        }
    }

    //Función para el análisis sintáctico
    static public void analisisSintactico(String input) throws Exception {
        Lexer lexer = new Lexer(new StringReader(input));
        Parser parser = new Parser(lexer);
        parser.parse();

    }
    
}
