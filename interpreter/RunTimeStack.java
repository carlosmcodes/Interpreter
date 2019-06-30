package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    void dump() {
        Program program = new Program();
        String output = "";
        int i = 0;
        while (runTimeStack.size() != 0) {
            ByteCode bc = program.getCode(program.getSize());
            System.out.println(bc + " " + bc.putArg());
            if (output.length() < 1)
                output = output + runTimeStack.get(i).toString() + ",";
            else {
                output = output + "," + runTimeStack.get(i).toString();

            }
            System.out.print("[" + output + "]");

            i++;

        }
    }

    int size() {
        return runTimeStack.size();
    }

    int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    int pop() {
        return runTimeStack.remove(runTimeStack.size());
    }

    void newFrameAt(int offset) {
        int find_Frame = runTimeStack.get(runTimeStack.size() - offset);
        framePointer.push(find_Frame);
    }

    public void popFrame() {
        framePointer.pop();
    }

    int store(int offset) {
        runTimeStack.remove(runTimeStack.size());
        return runTimeStack.get(runTimeStack.size() - offset);
    }

    int load(int offset) {
        int locate = runTimeStack.get(runTimeStack.size() - offset);
        locate = framePointer.search(locate);
        if (locate != -1) {
            runTimeStack.add(locate);
        }
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    Integer push(Integer val) {
        runTimeStack.add(val);
        return val;
    }
}
