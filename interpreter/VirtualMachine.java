package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    public VirtualMachine(Program program) {

        this.program = program;
    }

    void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute();

            //runStack.dump(); // Used to dump runstack state.
            pc++;
        }

    }

    public int popRunStack() {
        return runStack.pop();
    }

    public void newFrame_andInsert(int offset) {
        runStack.newFrameAt(offset);
    }

    public void push_Lit(int integer) {
        runStack.push(integer);
    }

    public void load_from_RTS(int offset) {
        runStack.load(offset);
    }

    public void store_from_RTS(int offset) {
        runStack.store(offset);
    }

    public int sizeOf_RTS() {
        return runStack.size();
    }

    public int peek() {
        return runStack.peek();
    }

    public void dumpRTS() {
        runStack.dump();
    }
}
