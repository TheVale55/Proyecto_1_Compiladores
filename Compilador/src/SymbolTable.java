import java.util.*;

public class SymbolTable {

    private Stack<HashMap<String, ArrayList<String>>> scopes;



    public SymbolTable() {
        this.scopes = new Stack<HashMap<String, ArrayList<String>>>();
    }



    public void addScope() {
        this.scopes.add(new HashMap<String, ArrayList<String>>());
    }



    public void exitScope() {
        this.scopes.pop();
    }



    public void addSymbol(String currentSymbol, String info) {
        if(!this.scopes.isEmpty()) {

            ArrayList<String> symbols;

            if(!this.scopes.peek().containsKey(currentSymbol)) {
                symbols = new ArrayList<String>();
                this.scopes.peek().put(currentSymbol, symbols);
            }
            else {
                symbols = this.scopes.peek().get(currentSymbol);
            }
            symbols.add(info);
        }
    }


    public void printScopes() {
        for (int i=0; i<this.scopes.size(); i++) {
            System.out.println("Scope " + (i+1) + ": " + scopes.get(i));
        }
    }


}
