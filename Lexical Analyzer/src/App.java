import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        try {
            // Crear el lexer con el archivo de entrada
            Lexer lexer = new Lexer(new FileReader("Lexical Analyzer/src/test.txt")); 
            lexer.createWriter("Lexical Analyzer/src/ReporteLexemas.txt");

            // Crear el parser usando el lexer
            Parser parser = new Parser(lexer);

            // Ejecutar el análisis
            parser.parse();

            // Cerrar el archivo de reporte de tokens
            lexer.closeWriter();

            // Mostrar tabla de símbolos al final
            System.out.println("\nAnálisis completado. Tabla de símbolos generada:");
            parser.imprimirTablaSimbolos(); // Llama al método para imprimir la tabla

        } catch (Exception e) {
            // Manejar errores y mostrar traza
            System.err.println("Ocurrió un error durante el análisis:");
            e.printStackTrace();
        }
    }
}

// Compilar antes de ejecutar:
// javac -cp "lib/*" src/*.java -d bin

// Ejecutar después de compilar:
// java -cp "lib/*:bin" App
