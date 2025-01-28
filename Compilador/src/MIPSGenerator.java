import java.io.BufferedWriter;
import java.io.FileWriter;


public class MIPSGenerator {

    private String fileName;
    private StringBuilder textSection;
    private StringBuilder dataSection;


    public MIPSGenerator(String fileName) {
        this.fileName = fileName;
        this.textSection = new StringBuilder();
        this.dataSection = new StringBuilder();
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
