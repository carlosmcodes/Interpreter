package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class CallCode extends ByteCode {

    private String args;

    @Override
    public void init(Object object) {
        args = object.toString();
    }

    @Override
    public String putArg() {
        return args;
    }

    @Override
    public void execute() {
        Program program = new Program();
        VirtualMachine vm = new VirtualMachine(program);
        program.resolveAddrs();
    }
}
