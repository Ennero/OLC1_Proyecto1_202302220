
package olc1_proyecto1_202302220;

import java.io.StringReader;
import jflexcupexample.analyzers.Lexer;
import jflexcupexample.analyzers.Parser;

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
        // TODO code application logic here
        System.out.println("Iniciando el programa");
        GUI gui= new GUI();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        
        Lexer scanner = new Lexer(new StringReader("3+4*2"));
        Parser parser = new Parser(scanner);
        parser.parse();
    }
    
}
