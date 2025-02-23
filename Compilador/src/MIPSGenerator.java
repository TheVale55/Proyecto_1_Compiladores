import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class MIPSGenerator {

    public static final int IF_COUNTER_INDEX = 0;
    public static final int ELSE_COUNTER_INDEX = 1;
    public static final int WHILE_COUNTER_INDEX = 2;
    public static final int FOR_COUNTER_INDEX = 3;
    public static final int SWITCH_COUNTER_INDEX = 4;
    public static final int CASE_COUNTER_INDEX = 5;
    public static final int DEFAULT_COUNTER_INDEX = 6;

    public static final int STRUCT_TYPE = 0;
    public static final int STRUCT_NUMBER = 1;


    private String fileName;
    private StringBuilder textSection;
    private StringBuilder dataSection;
    private List<Integer> structCounter = Arrays.asList(
        0, 0, 0, 0, 0, 0, 0
    );
    private Stack<String> structController; 
    private HashMap<String,String> registerMap; 
    private HashMap<String, Stack<String>> registerHandler; 



    public MIPSGenerator(String fileName) {
        this.fileName = fileName;
        this.textSection = new StringBuilder();
        this.dataSection = new StringBuilder();
        this.structController = new Stack<String>();
        this.registerMap = new HashMap<String,String>();
        this.registerHandler = new HashMap<String, Stack<String>>();
        registerHandler.putIfAbsent("temporalRegisters", new Stack<String>());
        registerHandler.putIfAbsent("floatRegisters", new Stack<String>());
        registerHandler.putIfAbsent("generalRegisters", new Stack<String>());
        for(int i=0; i<10; i++) registerHandler.get("temporalRegisters").add("$t" + i);
        for(int j=0; j<32; j++) registerHandler.get("floatRegisters").add("$f" + j);
        for(int k=0; k<7; k++) registerHandler.get("generalRegisters").add("$s" + k);
    }



    private int getStructCountIndex(String structName) {
        switch (structName) {
            case "while":
                return WHILE_COUNTER_INDEX;
        
            case "if":
                return IF_COUNTER_INDEX;

            case "for":
                return FOR_COUNTER_INDEX;

            case "else":
                return ELSE_COUNTER_INDEX;

            case "switch":
                return SWITCH_COUNTER_INDEX;

            case "case":
                return CASE_COUNTER_INDEX;

            case "default":
                return DEFAULT_COUNTER_INDEX;
        }
        return -1;
    }



    public String getNewRegister(String registerType) {
        if(registerHandler.get(registerType).isEmpty()) return "$s0"; //aqui realmente se haria manejo de la pila
        return registerHandler.get(registerType).peek(); 
    }




    public void createStartTag(String structName) {
        int structIndex = getStructCountIndex(structName);
        int structCount = this.structCounter.get(structIndex);
        this.textSection.append(structName + "Start" + structCount + ":\n");
        if(!structName.equals("case") && !structName.equals("default")) {
            this.structController.add(structName + ":" + structCount);
        }
        this.structCounter.set(structIndex, structCount + 1);
    }



    public void createFunctionStartTag(String funcName) {
        this.structController.add(funcName);
        this.textSection.append(funcName + ":\n");
    }




    public void createFunctionEndTag() {
        if(!structController.empty()) {
            this.textSection.append(structController.peek() + "END" + ":\n");
            this.structController.pop();
        }
    }



    public void createEndTag() {
        if(!structController.empty()) {
            String[] data = this.structController.peek().split(":");
            this.textSection.append(data[STRUCT_TYPE] + "END" + data[STRUCT_NUMBER] + ":\n");
            this.structController.pop();
        }

    }



    public void breakLastLoopCreated() {
        for(int i = structController.size()-1; i>=0; i--) {
            String[] data = this.structController.get(i).split(":");
            if(data[STRUCT_TYPE].equals("switch") || data[STRUCT_TYPE].equals("for") || data[STRUCT_TYPE].equals("while")) {
                this.textSection.append("j " + data[STRUCT_TYPE] + "END" + data[STRUCT_NUMBER] + "\n");
            }
        }
    }



    public void exitProgram() {
        this.textSection.append("li $v0, 10\nsyscall\n");
    }


    
    public void printInt(int value) {
        this.textSection.append("li $v0, 1\nli $a0, " + value + "\nsyscall\n");
    }
    


    public String readInt() {
        this.textSection.append("li $v0, 5\nsyscall\nmove $t0, $v0\n");
        return getNewRegister("temporalRegisters"); 
    }



    public void printString(String text) {
        this.textSection.append("li $v0, 4\nla $a0, " + text + "\nsyscall\n");
    }
    


    public void readString(String text, int length) {
        this.textSection.append("li $v0, 8\nla $a0, " + text + "\nli $a1, " + length + "\nsyscall\n");
    }



    public void printFloat(float value) {
        this.textSection.append("li $v0, 2\nl.s $f12, " + value + "\nsyscall\n");
    }    



    public String readFloat() {
        this.textSection.append("li $v0, 6\nsyscall\nmov.s $f0, $f12\n");
        return "$f12";  
    }



    public void printChar(char value) {
        this.textSection.append("li $v0, 11\nli $a0, " + (int) value + "\nsyscall\n");
    }



    public String readChar() {
        this.textSection.append("li $v0, 12\nsyscall\nmove $t0, $v0\n");
        return getNewRegister("temporalRegisters");  
    }
    


    public void printBool(boolean value) {
        this.textSection.append("li $v0, 16\nli $a0, " + (value ? 1 : 0) + "\nsyscall\n");
    }



    public String malloc(int size) {
        this.textSection.append("li $v0, 9\nli $a0, " + size + "\nsyscall\nmove $t0, $v0\n");
        return "$t0";  
    }
    


    public void free(String address) {
        this.textSection.append("li $v0, 11\nmove $a0, " + address + "\nsyscall\n");
    }



    public void reserveStackMemory(int size) {
        this.textSection.append("sub $sp, $sp, " + size + "\n");
    }
    


    public void freeStackMemory(int size) {
        this.textSection.append("add $sp, $sp, " + size + "\n");
    }




    public void add(String dest, String src1, String src2) {
        this.textSection.append("add " + dest + ", " + src1 + ", " + src2 + "\n");
    }



    public void sub(String dest, String src1, String src2) {
        this.textSection.append("sub " + dest + ", " + src1 + ", " + src2 + "\n");
    }



    public void mul(String dest, String src1, String src2) {
        this.textSection.append("mul " + dest + ", " + src1 + ", " + src2 + "\n");
    }



    public void div(String dest, String src1, String src2) {
        this.textSection.append("div " + src1 + ", " + src2 + "\n");
        this.textSection.append("mflo " + dest + "\n");
    }



    public void mod(String dest, String src1, String src2) {
        this.textSection.append("div " + src1 + ", " + src2 + "\n");
        this.textSection.append("mfhi " + dest + "\n");
    }



    public void beq(String src1, String src2, String label) {
        this.textSection.append("beq " + src1 + ", " + src2 + ", " + label + "\n");
    }



    public void blt(String src1, String src2, String label) {
        this.textSection.append("blt " + src1 + ", " + src2 + ", " + label + "\n");
    }



    public void bgt(String src1, String src2, String label) {
        this.textSection.append("bgt " + src1 + ", " + src2 + ", " + label + "\n");
    }



    public void ble(String src1, String src2, String label) {
        this.textSection.append("ble " + src1 + ", " + src2 + ", " + label + "\n");
    }



    public void bge(String src1, String src2, String label) {
        this.textSection.append("bge " + src1 + ", " + src2 + ", " + label + "\n");
    }



    public void asignacion(String source, String data) {
        if(!registerMap.containsKey(source)) {
            String register = getNewRegister("temporalRegisters");
            registerMap.put(source, register);
        }
        this.textSection.append("move " + registerMap.get(source) + ", " + data + "\n");
    }



    public void writeCodetoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(".data\n" + dataSection.toString() + "\n\n" + ".text\n.globl _verano_\n\n" + textSection.toString());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
