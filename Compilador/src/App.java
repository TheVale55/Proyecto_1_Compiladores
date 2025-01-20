import java.io.FileReader;


public class App {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer(new FileReader("Compilador/src/test.txt")); 
            lexer.createWriter("Compilador/src/ReporteLexemas.txt");

            Parser parser = new Parser(lexer);

            parser.createSyntaxWriter("Compilador/src/ReporteSintaxis.txt");
            parser.createSemanticWriter("Compilador/src/ReporteSemantica.txt");
            parser.parse();

            lexer.closeWriter();
            parser.closeSyntaxWriter();
            parser.closeSemanticWriter();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

//Para correr el archivo, debe estar en Proyecto_1_Compiladores
//javac -cp "lib/*" src/*.java -d bin
