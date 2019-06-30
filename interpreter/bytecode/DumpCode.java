package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {

    @Override
    public void init(Object object) {

    }

    @Override
    public String putArg() {
        return "";
    }

    @Override
    public void execute() {
        Program program = new Program();
        VirtualMachine vm = new VirtualMachine(program);
        vm.dumpRTS();
    }
}
