package olc1_proyecto1_202302220;

import java.io.StringReader;
import olc1_proyecto1_202302220.analizador.Lexer;
import java_cup.runtime.Symbol;
import olc1_proyecto1_202302220.analizador.sym;

/**
 *
 * @author Enner
 */
public class OLC1_Proyecto1_202302220 {
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // Cadena de prueba para el analizador léxico
        String input = "strategy match main if then else 3.14 true [ ] { }";

        // Crear un lector de cadenas para el analizador léxico
        Lexer lexer = new Lexer(new StringReader(input));

        // Procesar cada token generado por el lexer
        Symbol token;
        while ((token = lexer.next_token()).sym != sym.EOF) {
            // Mostrar información del token
            System.out.println("Token: " + sym.terminalNames[token.sym] + 
                               ", Valor: '" + token.value + 
                               "', Línea: " + token.left + 
                               ", Columna: " + token.right);
        }

        System.out.println("Fin del análisis léxico.");
    }
}