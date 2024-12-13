/* JF1ex exarnole: partial Java language lexer specification*/
import java_cup.runtime.* ;

    /*
    *   This class is a simple example lexer.
    */

    /* 
        Lexer base tomado de la página de Cup que requiere sym para utilizarse como Lexer
        Este lexer es utilizado por por el parser generado por BasicLexerCup (parser.java que se genera) 
    */

%% 
%class LexerCupV
%public 
%unicode
%cup
%line
%column

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

//comentarios
Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "\\_" [^*] ~"_/" | "\\_" "_"+ "/" //Verificar que se este mapeando correctamente el '\' :c

EndOfLineComment = "#" {InputCharacter}* {LineTerminator}?
//DocumentationComment = "/**" {CommentContent} "*"+ "/"
//CommentContent = ([^*] | \*+ [^ / *])* 

Identifier = [_][:jletter:][:jletterdigit:]*_

// Literals
Digit = [0-9]
NonZeroDigit = [1-9]
DecIntegerLiteral = 0 | {NonZeroDigit}{Digit}*
Identifier = _[:jletter:]+[:jletterdigit:]*_


digito = [0-9]
digitoNoCero = [1-9]
DecIntergerLiteral = 0 | -?{digitoNoCero}{digito}*




%state STRING

%%

/* KEYWORDS */

/* Data Types */
<YYINITIAL> "rodolfo" { return symbol(sym.INTEGER); }
<YYINITIAL> "bromista" { return symbol(sym.FLOAT); }
<YYINITIAL> "trueno" { return symbol(sym.BOOL); }
<YYINITIAL> "cupido" { return symbol(sym.CHAR); }
<YYINITIAL> "cometa" { return symbol(sym.STRING); }

/* Main Method */
<YYINITIAL> "_verano_" { return symbol(sym.MAIN); }

/* Control Structures */
<YYINITIAL> "elfo" { return symbol(sym.IF); }
<YYINITIAL> "hada" { return symbol(sym.ELSE); }
<YYINITIAL> "envuelve" { return symbol(sym.WHILE); }
<YYINITIAL> "duende" { return symbol(sym.FOR); }
<YYINITIAL> "varios" { return symbol(sym.SWITCH); }
<YYINITIAL> "historia" { return symbol(sym.CASE); }
<YYINITIAL> "ultimo" { return symbol(sym.DEFAULT); }
<YYINITIAL> "corta" { return symbol(sym.BREAK); }
<YYINITIAL> "envia" { return symbol(sym.RETURN); }

/* I/O Functions */
<YYINITIAL> "narra" { return symbol(sym.PRINT); }
<YYINITIAL> "escucha" { return symbol(sym.READ); }

/* Block Delimiters */
<YYINITIAL> "abrecuento" { return symbol(sym.APERTURA_DE_BLOQUE); }
<YYINITIAL> "cierracuento" { return symbol(sym.CIERRRE_DE_BLOQUE); }

/* Parentheses and Brackets */
<YYINITIAL> "abreregalo" { return symbol(sym.PARENTESIS_APERTURA); }
<YYINITIAL> "cierraregalo" { return symbol(sym.PARENTESIS_CIERRRE); }
<YYINITIAL> "abreempaque" { return symbol(sym.CORCHETE_APERTURA); }
<YYINITIAL> "cierraempaque" { return symbol(sym.CORCHETE_CIERRE); }

/* Assignment and Expression Delimiters */
<YYINITIAL> "entrega" { return symbol(sym.ASIGNACION); }
<YYINITIAL> "finregalo" { return symbol(sym.END_EXPR); }
<YYINITIAL> "sigue" { return symbol(sym.DOS_PUNTOS); }

/* Arithmetic */
<YYINITIAL> "navidad" { return symbol(sym.SUMA); }
<YYINITIAL> "intercambio" { return symbol(sym.RESTA); }
<YYINITIAL> "reyes" { return symbol(sym.DIV); }
<YYINITIAL> "nochebuena" { return symbol(sym.MULTIPLICACION); }
<YYINITIAL> "magos" { return symbol(sym.MODULO); }
<YYINITIAL> "adviento" { return symbol(sym.POTENCIA); }

/* Relational */
<YYINITIAL> "snowball" { return symbol(sym.MENOR); }
<YYINITIAL> "evergreen" { return symbol(sym.MENOR_IGUAL); }
<YYINITIAL> "minstix" { return symbol(sym.MAYOR); }
<YYINITIAL> "upatree" { return symbol(sym.MAYOR_IGUAL); }
<YYINITIAL> "mary" { return symbol(sym.IGUALDAD); }
<YYINITIAL> "openslae" { return symbol(sym.DIFERENTE); }

/* Logical */
<YYINITIAL> "melchor" { return symbol(sym.CONJUNCION); }
<YYINITIAL> "gaspar" { return symbol(sym.DISYUNCION); }
<YYINITIAL> "baltazar" { return symbol(sym.NEGACION); }

/* Unary */
<YYINITIAL> "quien" { return symbol(sym.INCREMENTO); }
<YYINITIAL> "grinch" { return symbol(sym.DECREMENTO); }

/* Identifiers */
<YYINITIAL> {Identifier} { return symbol(sym.IDENTIFICADOR, yytext()); }

/* Literals */
<YYINITIAL> {DecIntegerLiteral} { return symbol(sym.INT_LITERAL, Integer.parseInt(yytext())); }

/* String literals */
<YYINITIAL> \" { string.setLength(0); yybegin(STRING); }

<STRING> {
    \" { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString()); }
    [^\r\n"\\]+ { string.append(yytext()); }
    \\t { string.append("\t"); }
    \\n { string.append("\n"); }
    \\r { string.append("\r"); }
    \\" { string.append("\""); }
    \\\\ { string.append("\\"); }
}

/* Ignore comments */
<YYINITIAL> {Comment} { /* Ignore comments */ }

/* Ignore white space */
<YYINITIAL> {WhiteSpace} { /* Ignore white space */ }

/* Error Fallback */
//[^]                     { throw new Error("Illegal character <" + yytext() + ">"); }
