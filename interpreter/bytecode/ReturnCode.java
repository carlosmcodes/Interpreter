package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    String arg;

    @Override
    public void init(Object object) {
        arg = object.toString();
    }

    @Override
    public String putArg() {
        return arg;
    }

    @Override
    public void execute() {
    }
}
