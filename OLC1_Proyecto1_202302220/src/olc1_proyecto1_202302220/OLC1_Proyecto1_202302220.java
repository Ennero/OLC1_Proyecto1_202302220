package olc1_proyecto1_202302220;

import abstractas.Instruccion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import olc1_proyecto1_202302220.analizador.Lexer;
import java_cup.runtime.Symbol;
import olc1_proyecto1_202302220.analizador.sym;
import java.util.LinkedList;
import java_cup.runtime.Scanner;
import olc1_proyecto1_202302220.analizador.Parser;
import random.DeterministicRandomGenerator;
import random.RandomGenerator;
import javax.swing.JOptionPane;

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
    public static String salidita = "";
    public static GUI gui = new GUI();

    public static void main(String[] args) throws Exception {
        //Inicio el programa con la interfaz gráfica
        System.out.println("Iniciando el programa");

        gui.setVisible(true);
        gui.setLocationRelativeTo(null);

    }

    public static int contador1 = 0;
    public static int contador2 = 0;

    //Función para el análisis léxico
    static public void analisisLexico(String input) throws IOException {
        Lexer lexer = new Lexer(new StringReader(input));
        Symbol token;
        contador2 = 0;
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
        salidita = "";

        tokens.clear();
        errores.clear();
        Parser.erroresSintacticos.clear();

        analisisLexico(input);
        Parser parser = new Parser(lexer);

        try {
            parser.parse();
        } catch (Exception e) {
            System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
        }

        // Si hay errores sintácticos, detener la ejecución
        if (!Parser.erroresSintacticos.isEmpty()) {
            errores.addAll(Parser.erroresSintacticos);
            throw new Exception("Errores sintácticos detectados. No se puede continuar con la ejecución.");
        }

        // Si no hay errores, continuar con la ejecución
        Entorno global = new Entorno("global");
        String SALIDA = "";
        for (Instruccion instruccion : parser.sentencias) {
            try {
                instruccion.jugar(global);
                for (String salida : utilidades.Salida.salidaInfo) {
                    SALIDA += salida + "\n";
                }
            } catch (Exception e) {
                gui.SintacError();
            }
        }
        System.out.println(SALIDA);
        salidita = SALIDA;
    }

    static public void analisito(String input) throws Exception {
        Lexer lexer = new Lexer(new StringReader(input));
        salidita = "";

        // Limpiar listas antes de analizar
        tokens.clear();
        OLC1_Proyecto1_202302220.errores.clear();
        Parser.erroresSintacticos.clear();

        // Realizar análisis léxico
        analisisLexico(input);

        // Ejecutar análisis sintáctico
        Parser parser = new Parser(lexer);

        try {
            parser.parse();
        } catch (Exception e) {
            System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
        }

        // Agregar errores sintácticos detectados
        OLC1_Proyecto1_202302220.errores.addAll(Parser.erroresSintacticos);
    }
}
