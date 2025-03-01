/* 1. Package e importaciones*/
package olc1_proyecto1_202302220.analizador;
import java_cup.runtime.Symbol;
// Directivas
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
  //Entiendo que es para el código de java que no pondré xd
%}

//REGEX ------------------------------------------------------------------

//PARA IGNORAR
WS = [ \t\r\n]+

//NUMEROS
ENTERO = [0-9]+
FLOTANTE = {ENTERO}\.{ENTERO}

// Comentarios y espacios en blanco -------
COMENTARIOS = "//"([^\r\n]*)?
COMENTARIOS_MULTILINEA = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

//IDENTIFICADORES
ID = [A-Za-z_][A-Za-z_0-9]*

//REGLAS DE ACCIÓN----------------------------------------------------------------------------------------------------
%%

{WS}     { /* Ignorar espacios en blanco */ }

// PALABRAS RESERVADAS-----

//BLOQUES PRINCIPALES
"strategy"  { return new Symbol(sym.STRATEGY, yyline + 1, (int) yycolumn + 1, yytext()); }
"initial"  { return new Symbol(sym.INITIAL, yyline + 1, (int) yycolumn + 1, yytext()); }
"match"  { return new Symbol(sym.MATCH, yyline + 1, (int) yycolumn + 1, yytext()); }
"main"  { return new Symbol(sym.MAIN, yyline + 1, (int) yycolumn + 1, yytext()); }

//ACCIONES
"C" { return new Symbol(sym.C, yyline + 1, (int) yycolumn + 1, yytext()); }
"D" { return new Symbol(sym.D, yyline + 1, (int) yycolumn + 1, yytext()); }

//RELACIONADO A STRATEGY
"rules"  { return new Symbol(sym.RULES, yyline + 1, (int) yycolumn + 1, yytext()); }
"if"  { return new Symbol(sym.IF, yyline + 1, (int) yycolumn + 1, yytext()); }
"then"  { return new Symbol(sym.THEN, yyline + 1, (int) yycolumn + 1, yytext()); }
"else"  { return new Symbol(sym.ELSE, yyline + 1, (int) yycolumn + 1, yytext()); }

//funciones especiales dentro de strategy
"get_move" { return new Symbol(sym.GET_MOVE, yyline + 1, (int) yycolumn + 1, yytext()); }
"last_move" { return new Symbol(sym.LAST_MOVE, yyline + 1, (int) yycolumn + 1, yytext()); }
"get_moves_count" { return new Symbol(sym.GET_MOVES_COUNT, yyline + 1, (int) yycolumn + 1, yytext()); }
"get_last_n_moves" { return new Symbol(sym.GET_LAST_N_MOVES, yyline + 1, (int) yycolumn + 1, yytext()); }

//RELACIONADO A MATCH
"round_number"  { return new Symbol(sym.ROUND_NUMBER, yyline + 1, (int) yycolumn + 1, yytext()); }
"players" { return new Symbol(sym.PLAYERS, yyline + 1, (int) yycolumn + 1, yytext()); }
"strategies"  { return new Symbol(sym.STRATEGIES, yyline + 1, (int) yycolumn + 1, yytext()); }
"rounds" { return new Symbol(sym.ROUNDS, yyline + 1, (int) yycolumn + 1, yytext()); }
"scoring"  { return new Symbol(sym.SCORING, yyline + 1, (int) yycolumn + 1, yytext()); }


//RELACIONADO A MAIN
"run"  { return new Symbol(sym.RUN, yyline + 1, (int) yycolumn + 1, yytext()); }
"with"  { return new Symbol(sym.WITH, yyline + 1, (int) yycolumn + 1, yytext()); }
"seed"  { return new Symbol(sym.SEED, yyline + 1, (int) yycolumn + 1, yytext()); }

//PUNTAJES
"mutual cooperation" { return new Symbol(sym.MUTUAL_COOPERATION, yyline + 1, (int) yycolumn + 1, yytext()); }
"mutual defection" { return new Symbol(sym.MUTUAL_DEFECTION, yyline + 1, (int) yycolumn + 1, yytext()); }
"betrayal reward" { return new Symbol(sym.BETRAYAL_REWARD, yyline + 1, (int) yycolumn + 1, yytext()); }
"betrayal punishment"  { return new Symbol(sym.BETRAYAL_PUNISHMENT, yyline + 1, (int) yycolumn + 1, yytext()); }

"random" { return new Symbol(sym.RANDOM, yyline + 1, (int) yycolumn + 1, yytext()); }

//LISTA DE HISTORIAL
"opponent_history" { return new Symbol(sym.OPPONENT_HISTORY, yyline + 1, (int) yycolumn + 1, yytext()); }
"self_history" { return new Symbol(sym.SELF_HISTORY, yyline + 1, (int) yycolumn + 1, yytext()); }

//BOOLEANOS
"true" { return new Symbol(sym.TRUE, yyline + 1, (int) yycolumn + 1, yytext()); }
"false" { return new Symbol(sym.FALSE, yyline + 1, (int) yycolumn + 1, yytext()); }

//VALORES
{ENTERO} { return new Symbol(sym.ENTERO, yyline + 1, (int) yycolumn + 1, (yytext())); }   //parsear despues
{FLOTANTE} { return new Symbol(sym.FLOTANTE, yyline + 1, (int) yycolumn + 1, (yytext())); }  //parsear despues
{ID} { return new Symbol(sym.ID, yyline + 1, yycolumn + 1, yytext()); }


// OPERADORES--------
// Lógicas
"&&"  { return new Symbol(sym.AND, yyline + 1, (int) yycolumn + 1, yytext()); }
"||"  { return new Symbol(sym.OR, yyline + 1, (int) yycolumn + 1, yytext()); }
"!"  { return new Symbol(sym.NOT, yyline + 1, (int) yycolumn + 1, yytext()); }

// Comparadores
"=="  { return new Symbol(sym.IGUAL, yyline + 1, (int) yycolumn + 1, yytext()); }
"!="  { return new Symbol(sym.NO_IGUAL, yyline + 1, (int) yycolumn + 1, yytext()); }
"<"  { return new Symbol(sym.MENOR, yyline + 1, (int) yycolumn + 1, yytext()); }
">"  { return new Symbol(sym.MAYOR, yyline + 1, (int) yycolumn + 1, yytext()); }
"<="  { return new Symbol(sym.MENOR_IGUAL, yyline + 1, (int) yycolumn + 1, yytext()); }
">="  { return new Symbol(sym.MAYOR_IGUAL, yyline + 1, (int) yycolumn + 1, yytext()); }

// OTROS----------
"[" { return new Symbol(sym.ABRE_CORCHETE, yyline + 1, (int) yycolumn + 1, yytext()); }
"]" { return new Symbol(sym.CIERRA_CORCHETE, yyline + 1, (int) yycolumn + 1, yytext()); }
"{" { return new Symbol(sym.ABRE_LLAVE, yyline + 1, (int) yycolumn + 1, yytext()); }
"}" { return new Symbol(sym.CIERRA_LLAVE, yyline + 1, (int) yycolumn + 1, yytext()); }
"(" { return new Symbol(sym.ABRE_PARENTESIS, yyline + 1, (int) yycolumn + 1, yytext()); }
")" { return new Symbol(sym.CIERRA_PARENTESIS, yyline + 1, (int) yycolumn + 1, yytext()); }
"," { return new Symbol(sym.COMA, yyline + 1, (int) yycolumn + 1, yytext()); }
":" { return new Symbol(sym.DOS_PUNTOS, yyline + 1, (int) yycolumn + 1, yytext()); }

{COMENTARIOS} { /* Ignorar comentario de línea */ }
{COMENTARIOS_MULTILINEA} { /* Ignorar comentario de varias líneas */ }

// SINO ENTONCES ESTO XD DEBE DE LANZAR UN EXCEPCION O ALGO MAS+++++6+2+5+5+52+252+652+6246+
.    { return new Symbol(sym.ERROR_LEXICO, yyline + 1, yycolumn + 1, yytext()); }
//{ throw new Error("Error léxico en fila " + (yyline + 1) + " columna " + (yycolumn + 1)); }
