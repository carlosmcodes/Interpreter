package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
    private String arg;

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
        Program program = new Program();
        VirtualMachine vm = new VirtualMachine(program);
        vm.push_Lit(Integer.parseInt(arg));


    }
}
