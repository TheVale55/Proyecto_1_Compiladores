import java.io.FileReader;


public class App {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new FileReader("Lexical Analyzer/src/test.txt")); 
            lexer.createWriter("Lexical Analyzer/src/ReporteLexemas.txt");

            Parser parser = new Parser(lexer);
            parser.createWriter("Lexical Analyzer/src/ReporteSintaxis.txt");
            parser.parse();

            lexer.closeWriter();
            parser.closeWriter();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

//Para correr el archivo, debe estar en Proyecto_1_Compiladores
