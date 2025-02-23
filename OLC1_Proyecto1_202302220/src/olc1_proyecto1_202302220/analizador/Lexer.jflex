package olc1_proyecto1_202302220.analizador;

import java_cup.runtime.Symbol;

%%
//CONFIGURACIÓN DEL ANALIZADOR LEXICO---------------------------------------------------------
%class Lexer
%public
%unicode
%cup
%line
%column
%char

%{
  //Entiendo que es para el código de java
%}


//DEFINICIÓN DE TOKENS------------------------------------------------------------------

//GENERALES
WS = [ \t\r\n]+

//TIPOS
ACCION = C|D
ENTERO = [0-9]+
FLOTANTE = [0-9]+\.[0-9]*
BOOLEANO = true|false

//IDENTIFICADORES
ID = [A-Za-z_][A-Za-z_0-9]*

//Aquí también debería de haber algo de la lista que no entiendo aun

//REGLAS DE ACCIÓN----------------------------------------------------------------------------------------------------
%%

//PALABRAS RESERVADAS-----

//Funciones del Sistema
"get_move" { return new Symbol(sym.GET_MOVE, yyline, (int) yychar, yytext()); }
"last_move" { return new Symbol(sym.LAST_MOVE, yyline, (int) yychar, yytext()); }
"get_moves_count" { return new Symbol(sym.GET_MOVES_COUNT, yyline, (int) yychar, yytext()); }
"get_last_n_moves" { return new Symbol(sym.GET_LAST_N_MOVES, yyline, (int) yychar, yytext()); }

//Estados del Sistema
"round_number" { return new Symbol(sym.ROUND_NUMBER, yyline, (int) yychar, yytext()); } //Será entero
"opponent_history" { return new Symbol(sym.OPPONENT_HISTORY, yyline, (int) yychar, yytext()); } //Será lista
"self_history" { return new Symbol(sym.SELF_HISTORY, yyline, (int) yychar, yytext()); } //Será lista
"total_rounds"  { return new Symbol(sym.TOTAL_ROUNDS, yyline, (int) yychar, yytext()); } //Será entero
"random" { return new Symbol(sym.RANDOM, yyline, (int) yychar, yytext()); } //Será float

//Puntuacion
"betrayal reward" { return new Symbol(sym.BETRAYAL_REWARD, yyline, (int) yychar, yytext()); } //Será entero
"mutual cooperation" { return new Symbol(sym.MUTUAL_COOPERATION, yyline, (int) yychar, yytext()); } //Será entero
"mutual defection" { return new Symbol(sym.MUTUAL_DEFECTION, yyline, (int) yychar, yytext()); } //Será entero
"betrayal punishment" { return new Symbol(sym.BETRAYAL_PUNISHMENT, yyline, (int) yychar, yytext()); } //Será entero

//Validacion Parametros
"seed"  { return new Symbol(sym.SEED, yyline, (int) yychar, yytext()); } 

//Estructurales
"strategy"  { return new Symbol(sym.STRATEGY, yyline, (int) yychar, yytext()); }
"match"  { return new Symbol(sym.MATCH, yyline, (int) yychar, yytext()); }
"main"  { return new Symbol(sym.MAIN, yyline, (int) yychar, yytext()); }


//definicionPartida+++
"players" { return new Symbol(sym.PLAYERS, yyline, (int) yychar, yytext()); }
"rounds" { return new Symbol(sym.ROUNDS, yyline, (int) yychar, yytext()); }
"scoring" { return new Symbol(sym.SCORING, yyline, (int) yychar, yytext()); }


//Secciones
"initial"  { return new Symbol(sym.INITIAL, yyline, (int) yychar, yytext()); }
"rules"  { return new Symbol(sym.RULES, yyline, (int) yychar, yytext()); }

//Flujo
"if"  { return new Symbol(sym.IF, yyline, (int) yychar, yytext()); }
"then"  { return new Symbol(sym.THEN, yyline, (int) yychar, yytext()); }
"else"  { return new Symbol(sym.ELSE, yyline, (int) yychar, yytext()); }

//Configuración
"scoring"  { return new Symbol(sym.SCORING, yyline, (int) yychar, yytext()); }
"run"  { return new Symbol(sym.RUN, yyline, (int) yychar, yytext()); }
"with"  { return new Symbol(sym.WITH, yyline, (int) yychar, yytext()); }
"seed"  { return new Symbol(sym.SEED, yyline, (int) yychar, yytext()); }

//OPERADORES--------
//Logicas
"&&"  { return new Symbol(sym.AND, yyline, (int) yychar, yytext()); }
"||"  { return new Symbol(sym.OR, yyline, (int) yychar, yytext()); }
"!"  { return new Symbol(sym.NOT, yyline, (int) yychar, yytext()); }

//Comparadores
"=="  { return new Symbol(sym.IGUAL, yyline, (int) yychar, yytext()); }
"!="  { return new Symbol(sym.NO_IGUAL, yyline, (int) yychar, yytext()); }
"<"  { return new Symbol(sym.MENOR, yyline, (int) yychar, yytext()); }
">"  { return new Symbol(sym.MAYOR, yyline, (int) yychar, yytext()); }
"<="  { return new Symbol(sym.MENOR_IGUAL, yyline, (int) yychar, yytext()); }
">="  { return new Symbol(sym.MAYOR_IGUAL, yyline, (int) yychar, yytext()); }

//OTROS----------
"[" { return new Symbol(sym.ABRE_CORCHETE, yyline, (int) yychar, yytext()); }
"]" { return new Symbol(sym.CIERRA_CORCHETE, yyline, (int) yychar, yytext()); }
"{" { return new Symbol(sym.ABRE_LLAVE, yyline, (int) yychar, yytext()); }
"}" { return new Symbol(sym.CIERRA_LLAVE, yyline, (int) yychar, yytext()); }
"(" { return new Symbol(sym.ABRE_PARENTESIS, yyline, (int) yychar, yytext()); }
")" { return new Symbol(sym.CIERRA_PARENTESIS, yyline, (int) yychar, yytext()); }
"," { return new Symbol(sym.COMA, yyline, (int) yychar, yytext()); }
":" { return new Symbol(sym.DOBLEPUNTO, yyline, (int) yychar, yytext()); }

{WS}     { /* Ignorar espacios en blanco */ }

//Comentarios
"//" .*  { /* Ignorar comentario de línea */ }
"/*" ~ "*/" { /* Ignorar comentario de varias líneas */ }

//TIPOS-----
{ACCION} { return new Symbol(sym.ACCION, yyline, (int) yychar, yytext()); }
{ENTERO} { return new Symbol(sym.ENTERO, yyline, (int) yychar, yytext()); }
{FLOTANTE} { return new Symbol(sym.FLOTANTE, yyline, (int) yychar, yytext()); }
{BOOLEANO} { return new Symbol(sym.BOOLEANO, yyline, (int) yychar, yytext()); }

//IDENTIFICADORES-----
{ID} { return new Symbol(sym.ID, yyline, yycolumn, yytext()); }

//SINO ENTONCES ESTO XD
.        { System.err.println("Error lexico en fila " + (yyline+1) + " columna " + (yycolumn+1);}