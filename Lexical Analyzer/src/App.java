import java.io.FileReader;


public class App {
    public static void main(String[] args) throws Exception {
        try {
            Lexer lexer = new Lexer(new FileReader("C:/Users/joshu/OneDrive/Desktop/Proyecto_1_Compiladores/Lexical Analyzer/src/test.txt")); //correr desde src
            Parser parser = new Parser(lexer);

            lexer.createWriter("C:/Users/joshu/OneDrive/Desktop/Proyecto_1_Compiladores/Lexical Analyzer/src/output.txt");
            parser.parse();

            lexer.closeWriter();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//compilar archivos antes de correr el main: javac -cp "lib/*" src/*.java -d bin
//luego dirigirse a src para correr el archivo

