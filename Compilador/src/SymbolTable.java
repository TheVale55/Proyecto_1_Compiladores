import java.util.*;

/** Maneja la tabla de símbolos con variables, funciones y ámbitos. */
public class SymbolTable {

    public static final int TYPE_INFO = 0;
    public static final String SEPARATOR = ":";
    public static final List<String> DATA_TYPES = Arrays.asList(
        "int", "float", "char", "bool", "string"
    );
    public static final int FLOAT_TYPE_INDEX = 1;
    public static final int STRING_TYPE_INDEX = 4;
    public static final int INT_TYPE_INDEX = 0;
    public static final String EMPTY_STRING = "";
    public static final String MODULE_OPERATOR = "%";
    public static final int FUNCTION_PARAMS_INDEX = 2;
    public static final int IGNORABLE_INDEX_COUNT = 2;


    private Stack<HashMap<String, String>> localScopes;
    private HashMap<String, String> globalScope;
    private String actualFunction;


    /** Constructor de la tabla de símbolos. */
    public SymbolTable() {
        this.localScopes = new Stack<HashMap<String, String>>();
        this.globalScope = new HashMap<String, String>();
        this.actualFunction = EMPTY_STRING;
    }



    /** Define la función actual. */
    public void setActualFunction (String funcName) {
        this.actualFunction = funcName;
    }



    /** Obtiene la función actual. */
    public String getActualFunction() {
        return this.actualFunction;
    }



    /** Agrega un nuevo ámbito. */
    public void addScope() {
        this.localScopes.add(new HashMap<String, String>());
    }



    /** Elimina el ámbito actual. */
    public void exitScope() {
        this.localScopes.pop();
    }

    /** Agrega un símbolo global. */
    public boolean addGlobalSymbol(String currentSymbol, String info) {
        if(!this.globalScope.containsKey(currentSymbol)) {
            this.globalScope.put(currentSymbol, info);
            return true;
        }
        return false;
    }



    /** Agrega un símbolo al ámbito actual. */
    public boolean addSymbol(String currentSymbol, String info) {
        if(!this.localScopes.isEmpty() && !this.localScopes.peek().containsKey(currentSymbol)) {
            this.localScopes.peek().put(currentSymbol, info);
            return true;
        } 
        return false;
    }

    /** Verifica si un símbolo está en el ámbito local. */
    public boolean isInLocalScope(String key) {
        for(int i=0; i<localScopes.size(); i++) {
            if(localScopes.get(i).containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    /** Verifica si una cadena es un tipo de dato válido. */
    public boolean isDataType(String data) {
        return DATA_TYPES.contains(data);
    }

    /** Obtiene el tipo de un símbolo. */
    public String getType(String key) {
        if(isDataType(key)) {
            return key;
        }
        for(int i=0; i<localScopes.size(); i++) {
            if(localScopes.get(i).containsKey(key)) {
                String[] info = localScopes.get(i).get(key).split(SEPARATOR);
                return info[TYPE_INFO]; 
            }
        }
        return EMPTY_STRING; 
    }

    /** Verifica si dos tipos coinciden. */
    public boolean verifyType(String type1, String type2) {
        return type1.equals(type2);
    } 

    /** Valida operaciones entre operandos. */
    public boolean validateOperation(String rightOperand, String operator, String leftOperand) {
        String rightOperandType = getType(rightOperand);
        String leftOperandType = getType(leftOperand);
        return !(rightOperandType.equals(DATA_TYPES.get(STRING_TYPE_INDEX)) || leftOperandType.equals(DATA_TYPES.get(STRING_TYPE_INDEX)) || 
        ((rightOperandType.equals(DATA_TYPES.get(FLOAT_TYPE_INDEX)) || leftOperandType.equals(DATA_TYPES.get(FLOAT_TYPE_INDEX))) && operator.equals(MODULE_OPERATOR))) && 
        rightOperandType.equals(leftOperandType);
    }

    /**  Verifica si una llamada a función es válida. */
    public boolean verifyFunctionCall(String function, String data) {
        if(!globalScope.containsKey(function)) {
            return false;
        }

        String [] params = data.split(SEPARATOR);
        String[] functionInfo = globalScope.get(function).split(SEPARATOR);

        if(functionInfo.length - IGNORABLE_INDEX_COUNT != params.length) {
            return false;
        }

        for(int i = FUNCTION_PARAMS_INDEX; i<functionInfo.length; i++) {
            if(!functionInfo[i].equals(getType(params[i - IGNORABLE_INDEX_COUNT]))) {
                return false;
            }
        }
        return true;
    } 

    /** Verifica si la declaración de un arreglo es válida.  */
    public boolean verifyArrayDeclaration(String type, String data) {
        String[] values = data.split(SEPARATOR);
        for(int i=0; i<values.length; i++) {
            if(!type.equals(values[i])) {
                return false;
            }
        }
        return true;
    }

    /**  Verifica si el índice de un arreglo es un entero. */ 
    public boolean isIndexInteger(String index) {
        return getType(index).equals(DATA_TYPES.get(INT_TYPE_INDEX));
    }

    /** Imprime el ámbito local actual. */
    public void printScope() {
        if(!localScopes.empty()) {
            System.out.println(localScopes.peek());
            System.out.println(EMPTY_STRING);
        }
    }
    /** Imprime la tabla de símbolos global. */
    public void printGlobalScope() {
            System.out.println(globalScope);
            System.out.println(EMPTY_STRING);
    }


}
