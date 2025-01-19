/* JF1ex exarnole: partial Java language lexer specification */

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


    public void writeToken(int tokenNum, Object value) throws IOException {
        if(outputFile != null) {
            String text = "";
            if(tokenNum == ERROR) text += "Error léxico: ";
            else if(tokenNum == COMENTARIO) text += "Comentario: ";
            else text += "Token: " + tokenNum + ", Valor: ";
            text += value + ", línea: " + (yyline + 1) + ", columna: " + (yycolumn + 1) + '\n';
            outputFile.write(text);
            outputFile.flush();
        }
    }

%}

%{

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
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
<YYINITIAL> "rodolfo" { writeToken(sym.INTEGER, yytext()); return symbol(sym.INTEGER, yytext()); }
<YYINITIAL> "bromista" { writeToken(sym.FLOAT, yytext()); return symbol(sym.FLOAT, yytext()); }
<YYINITIAL> "trueno" { writeToken(sym.BOOL, yytext()); return symbol(sym.BOOL, yytext()); }
<YYINITIAL> "cupido" { writeToken(sym.CHAR, yytext()); return symbol(sym.CHAR, yytext()); }
<YYINITIAL> "cometa" { writeToken(sym.STRING, yytext()); return symbol(sym.STRING, yytext()); }

/* Main Method */
<YYINITIAL> "_verano_" { writeToken(sym.MAIN, yytext()); return symbol(sym.MAIN, yytext()); }

/* Control Structures */
<YYINITIAL> "elfo" { writeToken(sym.IF, yytext()); return symbol(sym.IF, yytext()); }
<YYINITIAL> "hada" { writeToken(sym.ELSE, yytext()); return symbol(sym.ELSE, yytext()); }
<YYINITIAL> "envuelve" { writeToken(sym.WHILE, yytext()); return symbol(sym.WHILE, yytext()); }
<YYINITIAL> "duende" { writeToken(sym.FOR, yytext()); return symbol(sym.FOR, yytext()); }
<YYINITIAL> "varios" { writeToken(sym.SWITCH, yytext()); return symbol(sym.SWITCH, yytext()); }
<YYINITIAL> "historia" { writeToken(sym.CASE, yytext()); return symbol(sym.CASE, yytext()); }
<YYINITIAL> "ultimo" { writeToken(sym.DEFAULT, yytext()); return symbol(sym.DEFAULT, yytext()); }
<YYINITIAL> "corta" { writeToken(sym.BREAK, yytext()); return symbol(sym.BREAK, yytext()); }
<YYINITIAL> "envia" { writeToken(sym.RETURN, yytext()); return symbol(sym.RETURN, yytext()); }

/* I/O Functions */
<YYINITIAL> "narra" { writeToken(sym.PRINT, yytext()); return symbol(sym.PRINT, yytext()); }
<YYINITIAL> "escucha" { writeToken(sym.READ, yytext()); return symbol(sym.READ, yytext()); }

/* Block Delimiters */
<YYINITIAL> "abrecuento" { writeToken(sym.APERTURA_DE_BLOQUE, yytext()); return symbol(sym.APERTURA_DE_BLOQUE, yytext()); }
<YYINITIAL> "cierracuento" { writeToken(sym.CIERRE_DE_BLOQUE, yytext()); return symbol(sym.CIERRE_DE_BLOQUE, yytext()); }

/* Parentheses and Brackets */
<YYINITIAL> "abreregalo" { writeToken(sym.PARENTESIS_APERTURA, yytext()); return symbol(sym.PARENTESIS_APERTURA, yytext()); }
<YYINITIAL> "cierraregalo" { writeToken(sym.PARENTESIS_CIERRE, yytext()); return symbol(sym.PARENTESIS_CIERRE, yytext()); }
<YYINITIAL> "abreempaque" { writeToken(sym.CORCHETE_APERTURA, yytext()); return symbol(sym.CORCHETE_APERTURA, yytext()); }
<YYINITIAL> "cierraempaque" { writeToken(sym.CORCHETE_CIERRE, yytext()); return symbol(sym.CORCHETE_CIERRE, yytext()); }

/* Assignment and Expression Delimiters */
<YYINITIAL> "entrega" { writeToken(sym.ASIGNACION, yytext()); return symbol(sym.ASIGNACION, yytext()); }
<YYINITIAL> "finregalo" { writeToken(sym.END_EXPR, yytext()); return symbol(sym.END_EXPR, yytext()); } 
<YYINITIAL> "sigue" { writeToken(sym.DOS_PUNTOS, yytext()); return symbol(sym.DOS_PUNTOS, yytext()); }

/* Arithmetic */
<YYINITIAL> "navidad" { writeToken(sym.SUMA, yytext()); return symbol(sym.SUMA, yytext()); }
<YYINITIAL> "intercambio" { writeToken(sym.RESTA, yytext()); return symbol(sym.RESTA, yytext()); }
<YYINITIAL> "reyes" { writeToken(sym.DIVISION, yytext()); return symbol(sym.DIVISION, yytext()); }
<YYINITIAL> "nochebuena" { writeToken(sym.MULTIPLICACION, yytext()); return symbol(sym.MULTIPLICACION, yytext()); }
<YYINITIAL> "magos" { writeToken(sym.MODULO, yytext()); return symbol(sym.MODULO, yytext()); }
<YYINITIAL> "adviento" { writeToken(sym.POTENCIA, yytext()); return symbol(sym.POTENCIA, yytext()); }

/* Relational */
<YYINITIAL> "snowball" { writeToken(sym.MENOR, yytext()); return symbol(sym.MENOR, yytext()); }
<YYINITIAL> "evergreen" { writeToken(sym.MENOR_IGUAL, yytext()); return symbol(sym.MENOR_IGUAL, yytext()); }
<YYINITIAL> "minstix" { writeToken(sym.MAYOR, yytext()); return symbol(sym.MAYOR, yytext()); }
<YYINITIAL> "upatree" { writeToken(sym.MAYOR_IGUAL, yytext()); return symbol(sym.MAYOR_IGUAL, yytext()); }
<YYINITIAL> "mary" { writeToken(sym.IGUALDAD, yytext()); return symbol(sym.IGUALDAD, yytext()); }
<YYINITIAL> "openslae" { writeToken(sym.DIFERENTE, yytext()); return symbol(sym.DIFERENTE, yytext()); }

/* Logical */
<YYINITIAL> "melchor" { writeToken(sym.CONJUNCION, yytext()); return symbol(sym.CONJUNCION, yytext()); }
<YYINITIAL> "gaspar" { writeToken(sym.DISYUNCION, yytext()); return symbol(sym.DISYUNCION, yytext()); }
<YYINITIAL> "baltazar" { writeToken(sym.NEGACION, yytext()); return symbol(sym.NEGACION, yytext()); }

/* Unary */
<YYINITIAL> "quien" { writeToken(sym.INCREMENTO, yytext()); return symbol(sym.INCREMENTO, yytext()); }
<YYINITIAL> "grinch" { writeToken(sym.DECREMENTO, yytext()); return symbol(sym.DECREMENTO, yytext()); }

/* Identifiers */
<YYINITIAL> {Identifier} { writeToken(sym.IDENTIFICADOR, yytext()); return symbol(sym.IDENTIFICADOR, yytext()); }

/* Literals */
<YYINITIAL> {DecIntegerLiteral} { writeToken(sym.INT_LITERAL, Integer.parseInt(yytext())); return symbol(sym.INT_LITERAL, Integer.parseInt(yytext())); }


<YYINITIAL> {BoolLiteral} { writeToken(sym.BOOL_LITERAL, yytext()); return symbol(sym.BOOL_LITERAL, yytext()); }


<YYINITIAL> {FloatLiteral} { writeToken(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); return symbol(sym.FLOAT_LITERAL, Float.parseFloat(yytext())); }

<YYINITIAL> {CharLiteral} { writeToken(sym.CHAR_LITERAL, yytext()); return symbol(sym.CHAR_LITERAL, yytext()); }

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

. { writeToken(ERROR, yytext()); }
 

/* ejecutar desde Compilador */
/* java -cp lib/jflex-full-1.9.1.jar jflex.Main src/lexercup.flex */
