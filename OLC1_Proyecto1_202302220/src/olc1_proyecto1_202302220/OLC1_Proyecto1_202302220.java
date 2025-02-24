package olc1_proyecto1_202302220;

import java.io.IOException;
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
        //Inicio el programa con la interfaz gráfica
        System.out.println("Iniciando el programa");
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);

    }

    //Función para realizar el análisis léxico
    public String analisisLexico(String input) throws IOException {
        Lexer lexer = new Lexer(new StringReader(input));

        Symbol token;
        String output = "";

        try {
            while ((token = lexer.next_token()).sym != sym.EOF) {
                // Si no es un error, agregar el token normal al resultado
                output += "Token: " + sym.terminalNames[token.sym]
                        + " -- Valor: '" + token.value
                        + "' -- Línea: " + token.left
                        + " -- Columna: " + token.right + "\n";
            }
        } catch (Error e) {
            // Capturar el error léxico y agregarlo al resultado
            output += "Error léxico: " + e.getMessage() + "\n";
        }

        return output;
    }

}
