package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {

        program = new ArrayList<>();
    }

    ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    void addCode(ByteCode s) {

        program.add(s);
    }

    public int jump(String arg) {
        String findMatch = "";
        int find;
        ByteCode param_Match;
        for (int i = 0; i < program.size(); i++) {
            param_Match = program.get(i);
            findMatch = param_Match.putArg();
            if (arg.equals(findMatch)) {
                return i;
            }

        }
        return -1;
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {
        Program addressFromProgram = new Program();
        int locator;
        String findArgLocation = "";
        for (int i = 0; i < addressFromProgram.getSize(); i++) {
            ByteCode getAdditionalArgs = addressFromProgram.getCode(i);
            findArgLocation = getAdditionalArgs.putArg();
            locator = jump(findArgLocation);
            addressFromProgram.getCode(locator);
            getAdditionalArgs.init(locator);

        }
    }
}
