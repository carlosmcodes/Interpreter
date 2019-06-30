package interpreter.bytecode;

public class LabelCode extends ByteCode {

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
    }
}
