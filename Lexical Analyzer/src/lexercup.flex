/* JF1ex exarnole: partial Java language lexer specification */

import java_cup.runtime.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;


/* This class is a simple example lexer. */

/* Lexer base tomado de la página de Cup que requiere sym para utilizarse como Lexer */

/* Este lexer es utilizado por el parser generado por BasicLexerCup (parser.java que se genera) */

%%

%class Lexer
%public
%line
%column
%unicode
%cup

%{
    public static final int ERROR = -1;
    public static final int COMENTARIO = -2;
    public BufferedWriter outputFile;

    // Tabla de símbolos
    HashMap<String, ArrayList<String>> tablaSimbolos = new HashMap<>();

    // Método para agregar un símbolo
    public void agregarSimbolo(String categoria, String simbolo) {
        tablaSimbolos.putIfAbsent(categoria, new ArrayList<>());
        if (!tablaSimbolos.get(categoria).contains(simbolo)) {
            tablaSimbolos.get(categoria).add(simbolo);
        }
    }

    // Método para imprimir la tabla al final
    public void imprimirTablaSimbolos() {
        System.out.println("\nTabla de Símbolos:");
        for (String categoria : tablaSimbolos.keySet()) {
            System.out.println("Categoría: " + categoria);
            for (String simbolo : tablaSimbolos.get(categoria)) {
                System.out.println("  - " + simbolo);
            }
        }
    }

    public void createWriter(String root) throws IOException {
        outputFile = new BufferedWriter(new FileWriter(root));
    }

    public void closeWriter() throws IOException {
        if(outputFile != null) {
            outputFile.close();
        }
    }


    public void writeToken(int tokenNum, Object value) throws IOException {
        if(outputFile != null) {
            String text = "";
            if(tokenNum == ERROR) text += "Error léxico: ";
            else if(tokenNum == COMENTARIO) text += "Comentario: ";
            else text += "Token: " + tokenNum + ", Valor: ";
            text += value + ", línea: " + yyline + ", columna: " + yycolumn + '\n';
            outputFile.write(text);
            outputFile.flush();
        }
    }

%}

%{

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "\\_" ([^_] | "_" [^/] | "\n")* "_/"             
EndOfLineComment = "#" {InputCharacter}* {LineTerminator}?

Identifier = _[a-zA-Z][a-zA-Z0-9]*_

digito = [0-9]
digitoNoCero = [1-9]
DecIntegerLiteral = 0 | -?{digitoNoCero}{digito}*

BoolLiteral = "true" | "false"

FloatLiteral = "0\.0" | -?{digito}+"\."{digito}*{digitoNoCero}

CharLiteral = '((\\.)|[^\\'\r\n])'



%state STRING

%%

/* KEYWORDS */

/* Data Types */
<YYINITIAL> "rodolfo" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.INTEGER, yytext()); return symbol(sym.INTEGER, yytext()); }
<YYINITIAL> "bromista" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.FLOAT, yytext()); return symbol(sym.FLOAT, yytext()); }
<YYINITIAL> "trueno" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.BOOL, yytext()); return symbol(sym.BOOL, yytext()); }
<YYINITIAL> "cupido" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CHAR, yytext()); return symbol(sym.CHAR, yytext()); }
<YYINITIAL> "cometa" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.STRING, yytext()); return symbol(sym.STRING, yytext()); }

/* Main Method */
<YYINITIAL> "_verano_" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MAIN, yytext()); return symbol(sym.MAIN, yytext()); }

/* Control Structures */
<YYINITIAL> "elfo" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.IF, yytext()); return symbol(sym.IF, yytext()); }
<YYINITIAL> "hada" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.ELSE, yytext()); return symbol(sym.ELSE, yytext()); }
<YYINITIAL> "envuelve" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.WHILE, yytext()); return symbol(sym.WHILE, yytext()); }
<YYINITIAL> "duende" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.FOR, yytext()); return symbol(sym.FOR, yytext()); }
<YYINITIAL> "varios" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.SWITCH, yytext()); return symbol(sym.SWITCH, yytext()); }
<YYINITIAL> "historia" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CASE, yytext()); return symbol(sym.CASE, yytext()); }
<YYINITIAL> "ultimo" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.DEFAULT, yytext()); return symbol(sym.DEFAULT, yytext()); }
<YYINITIAL> "corta" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.BREAK, yytext()); return symbol(sym.BREAK, yytext()); }
<YYINITIAL> "envia" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.RETURN, yytext()); return symbol(sym.RETURN, yytext()); }

/* I/O Functions */
<YYINITIAL> "narra" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.PRINT, yytext()); return symbol(sym.PRINT, yytext()); }
<YYINITIAL> "escucha" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.READ, yytext()); return symbol(sym.READ, yytext()); }

/* Block Delimiters */
<YYINITIAL> "abrecuento" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.APERTURA_DE_BLOQUE, yytext()); return symbol(sym.APERTURA_DE_BLOQUE, yytext()); }
<YYINITIAL> "cierracuento" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CIERRE_DE_BLOQUE, yytext()); return symbol(sym.CIERRE_DE_BLOQUE, yytext()); }

/* Parentheses and Brackets */
<YYINITIAL> "abreregalo" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.PARENTESIS_APERTURA, yytext()); return symbol(sym.PARENTESIS_APERTURA, yytext()); }
<YYINITIAL> "cierraregalo" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.PARENTESIS_CIERRE, yytext()); return symbol(sym.PARENTESIS_CIERRE, yytext()); }
<YYINITIAL> "abreempaque" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CORCHETE_APERTURA, yytext()); return symbol(sym.CORCHETE_APERTURA, yytext()); }
<YYINITIAL> "cierraempaque" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CORCHETE_CIERRE, yytext()); return symbol(sym.CORCHETE_CIERRE, yytext()); }

/* Assignment and Expression Delimiters */
<YYINITIAL> "entrega" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.ASIGNACION, yytext()); return symbol(sym.ASIGNACION, yytext()); }
<YYINITIAL> "finregalo" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.END_EXPR, yytext()); return symbol(sym.END_EXPR, yytext()); } 
<YYINITIAL> "sigue" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.DOS_PUNTOS, yytext()); return symbol(sym.DOS_PUNTOS, yytext()); }

/* Arithmetic */
<YYINITIAL> "navidad" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.SUMA, yytext()); return symbol(sym.SUMA, yytext()); }
<YYINITIAL> "intercambio" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.RESTA, yytext()); return symbol(sym.RESTA, yytext()); }
<YYINITIAL> "reyes" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.DIVISION, yytext()); return symbol(sym.DIVISION, yytext()); }
<YYINITIAL> "nochebuena" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MULTIPLICACION, yytext()); return symbol(sym.MULTIPLICACION, yytext()); }
<YYINITIAL> "magos" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MODULO, yytext()); return symbol(sym.MODULO, yytext()); }
<YYINITIAL> "adviento" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.POTENCIA, yytext()); return symbol(sym.POTENCIA, yytext()); }

/* Relational */
<YYINITIAL> "snowball" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MENOR, yytext()); return symbol(sym.MENOR, yytext()); }
<YYINITIAL> "evergreen" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MENOR_IGUAL, yytext()); return symbol(sym.MENOR_IGUAL, yytext()); }
<YYINITIAL> "minstix" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MAYOR, yytext()); return symbol(sym.MAYOR, yytext()); }
<YYINITIAL> "upatree" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.MAYOR_IGUAL, yytext()); return symbol(sym.MAYOR_IGUAL, yytext()); }
<YYINITIAL> "mary" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.IGUALDAD, yytext()); return symbol(sym.IGUALDAD, yytext()); }
<YYINITIAL> "openslae" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.DIFERENTE, yytext()); return symbol(sym.DIFERENTE, yytext()); }

/* Logical */
<YYINITIAL> "melchor" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CONJUNCION, yytext()); return symbol(sym.CONJUNCION, yytext()); }
<YYINITIAL> "gaspar" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.DISYUNCION, yytext()); return symbol(sym.DISYUNCION, yytext()); }
<YYINITIAL> "baltazar" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.NEGACION, yytext()); return symbol(sym.NEGACION, yytext()); }

/* Unary */
<YYINITIAL> "quien" { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.INCREMENTO, yytext()); return symbol(sym.INCREMENTO, yytext()); }
<YYINITIAL> "grinch" { writeToken(sym.DECREMENTO, yytext()); return symbol(sym.DECREMENTO, yytext()); }

/* Identifiers */
<YYINITIAL> {Identifier} { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.IDENTIFICADOR, yytext()); return symbol(sym.IDENTIFICADOR, yytext()); }

/* Literals */
<YYINITIAL> {DecIntegerLiteral} { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.INT_LITERAL, Integer.parseInt(yytext())); return symbol(sym.INT_LITERAL, Integer.parseInt(yytext())); }


<YYINITIAL> {BoolLiteral} { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.BOOL_LITERAL, yytext()); return symbol(sym.BOOL_LITERAL, yytext()); }


<YYINITIAL> {FloatLiteral} { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); }

<YYINITIAL> {CharLiteral} { agregarSimbolo("Palabras clave", yytext()); writeToken(sym.CHAR_LITERAL, yytext()); return symbol(sym.CHAR_LITERAL, yytext()); }

/* String literals */
<YYINITIAL> \" { string.setLength(0); yybegin(STRING); }

<STRING> {
    \" { yybegin(YYINITIAL); writeToken(sym.STRING_LITERAL, string.toString()); return symbol(sym.STRING_LITERAL, string.toString()); }

    [^\r\n\"\\]+ { string.append(yytext()); }

    \\t { string.append("\t"); }

    \\n { string.append("\n"); }

    \\r { string.append("\r"); }

    \\\" { string.append("\""); }

    \\\\ { string.append("\\"); }
}

<YYINITIAL> "," { writeToken(sym.COMMA, yytext()); return symbol(sym.COMMA, yytext()); }

/* Ignore comments */
<YYINITIAL> {Comment} { writeToken(COMENTARIO, yytext()); }

/* Ignore white space */
<YYINITIAL> {WhiteSpace} { /* Ignore white space */ }

<YYINITIAL> <<EOF>> { return symbol(sym.EOF, yytext()); }

[^] { writeToken(ERROR, yytext()); }
 

/* ejecutar desde Lexical Analyzer */
/* java -cp lib/jflex-full-1.9.1.jar jflex.Main src/lexercup.flex */
