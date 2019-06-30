package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

import java.util.Scanner;

public class ReadCode extends ByteCode {

    @Override
    public void init(Object object) {

    }

    @Override
    public String putArg() {
        return "";
    }

    // do nottttt think this is right....
    @Override
    public void execute() {

        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        if (Character.isDigit(val)) {
            Program program = new Program();
            VirtualMachine vm = new VirtualMachine(program);
            vm.push_Lit(val);

        }
    }
}
