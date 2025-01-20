import java.util.*;

public class SymbolTable {

    private Stack<HashMap<String, String>> scopes;
    public static final int TYPE_INDEX = 0;


    public SymbolTable() {
        this.scopes = new Stack<HashMap<String, String>>();
    }



    public void addScope() {
        this.scopes.add(new HashMap<String, String>());
    }



    public void exitScope() {
        this.scopes.pop();
    }



    public void addSymbol(String currentSymbol, String info) {
        if(!this.scopes.isEmpty() && !this.scopes.peek().containsKey(currentSymbol)) {
           
            this.scopes.peek().put(currentSymbol, info);

        }
    }


    public String getType(String key) {
        for(int i=0; i<scopes.size(); i++) {
            if(scopes.get(i).containsKey(key)) {
                String[] info = scopes.get(i).get(key).split(":");
                return info[TYPE_INDEX]; //cambiar indice en el que se pone el tipo
            }
        }
        return "Null"; //No existe el valor en ningun scope
    }


    public boolean verifyType(String type, String data) {
        String [] values = data.split(":");
        for(int i=0; i<values.length; i++) {
            if(!(values[i].equals(type) || getType(values[i]).equals(type))) {
                return false;
            }
        }
        return true;
    } 



    public void printScope() {
        if(!scopes.empty()) {
            System.out.println(scopes.peek());
            System.out.println("");
        }
    }


}
