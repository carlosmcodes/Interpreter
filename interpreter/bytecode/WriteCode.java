package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {

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
        int top_of_stack = vm.peek();
        System.out.println(top_of_stack);

    }
}
