/* JF1ex exarnole: partial Java language lexer specification */

import java_cup.runtime.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public void createWriter(String root) throws IOException {
        outputFile = new BufferedWriter(new FileWriter(root));
    }

    public void closeWriter() throws IOException {
        if(outputFile != null) {
            outputFile.close();
        }
    }

    public void writeToken(int tokenNum) throws IOException {
        if(outputFile != null) {
            if(tokenNum == ERROR) outputFile.write("Error léxico: " +yytext() + ", línea: " + yyline + ", columna: " + yycolumn + '\n');
            else if(tokenNum == COMENTARIO) outputFile.write("Comentario: " +yytext() + ", línea: " + yyline + ", columna: " + yycolumn + '\n');
            else outputFile.write("Token: " + tokenNum + ", Valor: " +yytext() + ", línea: " + yyline + ", columna: " + yycolumn + '\n');
            outputFile.flush();
        }
    }

%}

%{

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

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
<YYINITIAL> "rodolfo" { writeToken(sym.INTEGER); return symbol(sym.INTEGER, yytext()); }
<YYINITIAL> "bromista" { writeToken(sym.FLOAT); return symbol(sym.FLOAT, yytext()); }
<YYINITIAL> "trueno" { writeToken(sym.BOOL); return symbol(sym.BOOL, yytext()); }
<YYINITIAL> "cupido" { writeToken(sym.CHAR); return symbol(sym.CHAR, yytext()); }
<YYINITIAL> "cometa" { writeToken(sym.STRING); return symbol(sym.STRING, yytext()); }

/* Main Method */
<YYINITIAL> "_verano_" { writeToken(sym.MAIN); return symbol(sym.MAIN, yytext()); }

/* Control Structures */
<YYINITIAL> "elfo" { writeToken(sym.IF); return symbol(sym.IF, yytext()); }
<YYINITIAL> "hada" { writeToken(sym.ELSE); return symbol(sym.ELSE, yytext()); }
<YYINITIAL> "envuelve" { writeToken(sym.WHILE); return symbol(sym.WHILE, yytext()); }
<YYINITIAL> "duende" { writeToken(sym.FOR); return symbol(sym.FOR, yytext()); }
<YYINITIAL> "varios" { writeToken(sym.SWITCH); return symbol(sym.SWITCH, yytext()); }
<YYINITIAL> "historia" { writeToken(sym.CASE); return symbol(sym.CASE, yytext()); }
<YYINITIAL> "ultimo" { writeToken(sym.DEFAULT); return symbol(sym.DEFAULT, yytext()); }
<YYINITIAL> "corta" { writeToken(sym.BREAK); return symbol(sym.BREAK, yytext()); }
<YYINITIAL> "envia" { writeToken(sym.RETURN); return symbol(sym.RETURN, yytext()); }

/* I/O Functions */
<YYINITIAL> "narra" { writeToken(sym.PRINT); return symbol(sym.PRINT, yytext()); }
<YYINITIAL> "escucha" { writeToken(sym.READ); return symbol(sym.READ, yytext()); }

/* Block Delimiters */
<YYINITIAL> "abrecuento" { writeToken(sym.APERTURA_DE_BLOQUE); return symbol(sym.APERTURA_DE_BLOQUE, yytext()); }
<YYINITIAL> "cierracuento" { writeToken(sym.CIERRE_DE_BLOQUE); return symbol(sym.CIERRE_DE_BLOQUE, yytext()); }

/* Parentheses and Brackets */
<YYINITIAL> "abreregalo" { writeToken(sym.PARENTESIS_APERTURA); return symbol(sym.PARENTESIS_APERTURA, yytext()); }
<YYINITIAL> "cierraregalo" { writeToken(sym.PARENTESIS_CIERRE); return symbol(sym.PARENTESIS_CIERRE, yytext()); }
<YYINITIAL> "abreempaque" { writeToken(sym.CORCHETE_APERTURA); return symbol(sym.CORCHETE_APERTURA, yytext()); }
<YYINITIAL> "cierraempaque" { writeToken(sym.CORCHETE_CIERRE); return symbol(sym.CORCHETE_CIERRE, yytext()); }

/* Assignment and Expression Delimiters */
<YYINITIAL> "entrega" { writeToken(sym.ASIGNACION); return symbol(sym.ASIGNACION, yytext()); }
<YYINITIAL> "finregalo" { writeToken(sym.END_EXPR); return symbol(sym.END_EXPR, yytext()); } 
<YYINITIAL> "sigue" { writeToken(sym.DOS_PUNTOS); return symbol(sym.DOS_PUNTOS, yytext()); }

/* Arithmetic */
<YYINITIAL> "navidad" { writeToken(sym.SUMA); return symbol(sym.SUMA, yytext()); }
<YYINITIAL> "intercambio" { writeToken(sym.RESTA); return symbol(sym.RESTA, yytext()); }
<YYINITIAL> "reyes" { writeToken(sym.DIVISION); return symbol(sym.DIVISION, yytext()); }
<YYINITIAL> "nochebuena" { writeToken(sym.MULTIPLICACION); return symbol(sym.MULTIPLICACION, yytext()); }
<YYINITIAL> "magos" { writeToken(sym.MODULO); return symbol(sym.MODULO, yytext()); }
<YYINITIAL> "adviento" { writeToken(sym.POTENCIA); return symbol(sym.POTENCIA, yytext()); }

/* Relational */
<YYINITIAL> "snowball" { writeToken(sym.MENOR); return symbol(sym.MENOR, yytext()); }
<YYINITIAL> "evergreen" { writeToken(sym.MENOR_IGUAL); return symbol(sym.MENOR_IGUAL, yytext()); }
<YYINITIAL> "minstix" { writeToken(sym.MAYOR); return symbol(sym.MAYOR, yytext()); }
<YYINITIAL> "upatree" { writeToken(sym.MAYOR_IGUAL); return symbol(sym.MAYOR_IGUAL, yytext()); }
<YYINITIAL> "mary" { writeToken(sym.IGUALDAD); return symbol(sym.IGUALDAD, yytext()); }
<YYINITIAL> "openslae" { writeToken(sym.DIFERENTE); return symbol(sym.DIFERENTE, yytext()); }

/* Logical */
<YYINITIAL> "melchor" { writeToken(sym.CONJUNCION); return symbol(sym.CONJUNCION, yytext()); }
<YYINITIAL> "gaspar" { writeToken(sym.DISYUNCION); return symbol(sym.DISYUNCION, yytext()); }
<YYINITIAL> "baltazar" { writeToken(sym.NEGACION); return symbol(sym.NEGACION, yytext()); }

/* Unary */
<YYINITIAL> "quien" { writeToken(sym.INCREMENTO); return symbol(sym.INCREMENTO, yytext()); }
<YYINITIAL> "grinch" { writeToken(sym.DECREMENTO); return symbol(sym.DECREMENTO, yytext()); }

/* Identifiers */
<YYINITIAL> {Identifier} { writeToken(sym.IDENTIFICADOR); return symbol(sym.IDENTIFICADOR, yytext()); }

/* Literals */
<YYINITIAL> {DecIntegerLiteral} { writeToken(sym.INT_LITERAL); return symbol(sym.INT_LITERAL, Integer.parseInt(yytext())); }


<YYINITIAL> {BoolLiteral} { writeToken(sym.BOOL_LITERAL); return symbol(sym.BOOL_LITERAL, yytext()); }


<YYINITIAL> {FloatLiteral} { writeToken(sym.FLOAT_LITERAL); return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); }

<YYINITIAL> {CharLiteral} { writeToken(sym.CHAR_LITERAL); return symbol(sym.CHAR_LITERAL, yytext()); }

/* String literals */
<YYINITIAL> \" { string.setLength(0); yybegin(STRING); }

<STRING> {
    \" { yybegin(YYINITIAL); writeToken(sym.STRING_LITERAL); return symbol(sym.STRING_LITERAL, string.toString()); }

    [^\r\n\"\\]+ { string.append(yytext()); }

    \\t { string.append("\t"); }

    \\n { string.append("\n"); }

    \\r { string.append("\r"); }

    \\\" { string.append("\""); }

    \\\\ { string.append("\\"); }
}

/* Ignore comments */
<YYINITIAL> {Comment} { writeToken(-2); }

/* Ignore white space */
<YYINITIAL> {WhiteSpace} { /* Ignore white space */ }

<YYINITIAL> <<EOF>> { return symbol(sym.EOF, yytext()); }

[^] { writeToken(-1); }
 

/* ejecutar desde Lexical Analyzer */
/* java -cp lib/jflex-full-1.9.1.jar jflex.Main src/lexercup.flex */
