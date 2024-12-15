import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java_cup.runtime.Symbol;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            FileReader fileReader = new FileReader("test.txt"); //correr desde src
            FileWriter fileWriter = new FileWriter("output.txt"); 
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Lexer lexer = new Lexer(fileReader);
            //Parser parser = new Parser(lexer, null);
            //parser.parse();

            while (true) {
                Symbol token = lexer.next_token();
                if(token.sym == sym.EOF) break;
                bufferedWriter.write(String.format("Token: '%s' en línea %d, columna %d\n", token.value, lexer.yyline(), lexer.yycolumn()));
            }

            fileReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
