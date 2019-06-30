package interpreter.bytecode;

import interpreter.Program;

public class GotoCode extends ByteCode {

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
        program.resolveAddrs();
    }
}
