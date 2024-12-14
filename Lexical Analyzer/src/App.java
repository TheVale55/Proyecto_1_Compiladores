import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            FileReader fileReader = new FileReader("test.txt");
            
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
