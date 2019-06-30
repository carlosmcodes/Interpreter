package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
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
        int second_level = vm.popRunStack();
        int top_level = vm.popRunStack();
        int sum;
        switch (arg) {
            case "+":
                sum = second_level + top_level;
                vm.push_Lit(sum);
                break;
            case "-":
                sum = second_level - top_level;
                vm.push_Lit(sum);
                break;
            case "/":
                sum = second_level / top_level;
                vm.push_Lit(sum);
                break;
            case "*":
                sum = second_level * top_level;
                vm.push_Lit(sum);
                break;
            case "==":
                sum = second_level ^ top_level;
                if (sum == 0) {
                    sum = 1;
                    vm.push_Lit(1);

                } else {
                    sum = 0;
                    vm.push_Lit(0);
                }
                break;
            case "!=":
                if(second_level != top_level)
                    vm.push_Lit(1);
                else
                    vm.push_Lit(0);
                break;
            case "<=":
                if(second_level <= top_level)
                    vm.push_Lit(1);
                else
                    vm.push_Lit(0);
                break;
            case ">":
                if(second_level > top_level)
                    vm.push_Lit(1);
                else
                    vm.push_Lit(0);
                break;
            case ">=":
                if(second_level >= top_level)
                    vm.push_Lit(1);
                else
                    vm.push_Lit(0);
                break;
            case "<":
                if(second_level < top_level)
                    vm.push_Lit(1);
                else
                    vm.push_Lit(0);
                break;
            case "|":
                // wut
                break;
            case "&":
                // same as addition??? idk man halp
                break;
        }


    }
}
