package interpreter.bytecode;

public class HaltCode extends ByteCode{

    @Override
    public void init(Object object) {

    }

    @Override
    public String putArg() {
        return "";
    }

    @Override
    public void execute() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
