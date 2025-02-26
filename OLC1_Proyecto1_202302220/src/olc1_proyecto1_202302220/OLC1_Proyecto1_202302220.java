package olc1_proyecto1_202302220;

import java.io.IOException;
import java.io.StringReader;
import olc1_proyecto1_202302220.analizador.Lexer;
import java_cup.runtime.Symbol;
import olc1_proyecto1_202302220.analizador.sym;
import java.util.LinkedList;
import olc1_proyecto1_202302220.analizador.Parser;

/**
 *
 * @author Enner
 */
public class OLC1_Proyecto1_202302220 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    //Creo la linkedList que tendrá todo los datos de los tokens
    static public LinkedList<String[]> tokens = new LinkedList<>();
    static public LinkedList<String[]> errores = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        //Inicio el programa con la interfaz gráfica
        System.out.println("Iniciando el programa");
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);

    }

    
    
    //Función para el análisis léxico
    static public void analisisLexico(String input) throws IOException {
        Lexer lexer = new Lexer(new StringReader(input));
        Symbol token;
        int contador = 0;
        while ((token = lexer.next_token()).sym != sym.EOF) {
            // Incrementa el contador
            contador++;
            // Crea un nuevo arreglo para el token
            String[] arreglo = new String[5];
            arreglo[0] = Integer.toString(contador);
            arreglo[1] = sym.terminalNames[token.sym];
            arreglo[2] = token.value.toString();
            arreglo[3] = Integer.toString(token.left);
            arreglo[4] = Integer.toString(token.right);

            // Si es un error, agregar al arreglo de errores
            if (sym.terminalNames[token.sym].equals("ERROR_LEXICO")) {
                errores.add(arreglo);
                break;
            } else {
                // Si no es un error, agregar al arreglo de tokens
                tokens.add(arreglo);
            }
        }
    }
    

    //Función para el análisis sintáctico
    static public void analisisSintactico(String input) throws Exception{
        Lexer lexer = new Lexer(new StringReader(input));
        Parser parser = new Parser(lexer);
        parser.parse();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

    



