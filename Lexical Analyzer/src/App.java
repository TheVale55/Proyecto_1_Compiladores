import java.io.FileReader;

import java_cup.runtime.Symbol;


public class App {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new FileReader("Lexical Analyzer/src/test.txt")); 
            lexer.createWriter("Lexical Analyzer/src/output.txt");

            Symbol token;
            while ((token = lexer.next_token()).sym != sym.EOF) {

                System.out.println("Token: " + token.sym + ", Value: " + token.value);
            }

            lexer.closeWriter();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//compilar archivos antes de correr el main (debe estar en la carpeta Lexical Analyzer): javac -cp "lib/*" src/*.java -d bin
//Para correr el archivo, debe estar en Proyecto_1_Compiladores
