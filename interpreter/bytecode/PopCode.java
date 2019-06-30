package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    String popAmount;

    @Override
    public void init(Object object) {
        popAmount = object.toString();
    }

    @Override
    public String putArg() {
        return popAmount;
    }

    @Override
    public void execute() {
        Program program = new Program();
        VirtualMachine vm = new VirtualMachine(program);
        for (int i = 0; i < Integer.parseInt(popAmount); i++) vm.popRunStack();


    }
}
