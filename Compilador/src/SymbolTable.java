import java.util.*;

public class SymbolTable {

    public static final int TYPE_INDEX = 0;
    public static final String SEPARATOR = ":";
    public static final List<String> DATA_TYPES = Arrays.asList(
        "int", "float", "char", "bool", "string"
    );
    public static final int FLOAT_TYPE_INDEX = 1;
    public static final int STRING_TYPE_INDEX = 4;
    public static final String EMPTY_STRING = "";
    public static final String MODULE_OPERATOR = "%";

    private Stack<HashMap<String, String>> scopes;


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


    private boolean isDataType(String data) {
        return DATA_TYPES.contains(data);
    }


    public String getType(String key) {
        if(isDataType(key)) {
            return key;
        }
        for(int i=0; i<scopes.size(); i++) {
            if(scopes.get(i).containsKey(key)) {
                String[] info = scopes.get(i).get(key).split(SEPARATOR);
                return info[TYPE_INDEX]; //cambiar indice en el que se pone el tipo
            }
        }
        return EMPTY_STRING; //No existe el tipo en ningun scope
    }


    public boolean verifyType(String varType, String exprFinalType) {
        return varType.equals(exprFinalType);
    } 



    public boolean validateOperation(String rightOperand, String operator, String leftOperand) {
        String rightOperandType = getType(rightOperand);
        String leftOperandType = getType(leftOperand);
        return !(rightOperandType.equals(DATA_TYPES.get(STRING_TYPE_INDEX)) || leftOperandType.equals(DATA_TYPES.get(STRING_TYPE_INDEX)) || 
        ((rightOperandType.equals(DATA_TYPES.get(FLOAT_TYPE_INDEX)) || leftOperandType.equals(DATA_TYPES.get(FLOAT_TYPE_INDEX))) && operator.equals(MODULE_OPERATOR))) && 
        rightOperandType.equals(leftOperandType);
    }


    public void printScope() {
        if(!scopes.empty()) {
            System.out.println(scopes.peek());
            System.out.println(EMPTY_STRING);
        }
    }


}
