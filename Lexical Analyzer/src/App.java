import java.io.FileReader;


public class App {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new FileReader("Lexical Analyzer/src/test.txt")); 
            lexer.createWriter("Lexical Analyzer/src/output.txt");

            Parser parser = new Parser(lexer);
            parser.parse();

            lexer.closeWriter();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//compilar archivos antes de correr el main (debe estar en la carpeta Lexical Analyzer): javac -cp "lib/*" src/*.java -d bin
//Para correr el archivo, debe estar en Proyecto_1_Compiladores
