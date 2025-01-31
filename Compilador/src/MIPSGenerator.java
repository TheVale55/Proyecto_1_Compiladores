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
    private Stack<String> structController; //--> Como los scopes, saber la estructura en la que voy para saber dónde saltar.
    private HashMap<String,String> registerMap; //sin usar aún --> para saber que variable quedó en qué registro.
    private HashMap<String, Stack<String>> registerHandler; //sin usar aún --> saber que registros están disponibles.



    public MIPSGenerator(String fileName) {
        this.fileName = fileName;
        this.textSection = new StringBuilder();
        this.dataSection = new StringBuilder();
        this.structController = new Stack<String>();
        this.registerMap = new HashMap<String,String>();
        this.registerHandler = new HashMap<String, Stack<String>>();



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



    public void createStartTag(String structName) {
        int structIndex = getStructCountIndex(structName);
        int structCount = this.structCounter.get(structIndex);
        this.textSection.append(structName + "Start" + structCount + ":\n");
        this.structController.add(structName + ":" + structCount);
        this.structCounter.set(structIndex, structCount + 1);
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
        return "$t0"; 
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
        return "$t0";  
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



    public void writeCodetoFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(".data\n" + dataSection.toString() + "\n\n" + ".text\n.globl _main_\n\n" + textSection.toString());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
