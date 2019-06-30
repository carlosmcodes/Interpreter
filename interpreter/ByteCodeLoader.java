
package interpreter;

import com.sun.org.apache.bcel.internal.classfile.Code;
import interpreter.bytecode.ArgsCode;
import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program programWithCodes = new Program();
        String keyAndValue = "";
        String stringsplit = "";
        String additionalArgs[];

        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                keyAndValue = byteSource.readLine();
                stringsplit = keyAndValue;
                if (keyAndValue == null)
                    break;
                if (!keyAndValue.contains(" ")) {
                    keyAndValue = CodeTable.getClassName(keyAndValue);
                    Class runTimeBlueprintByteCode = Class.forName("interpreter.bytecode." + keyAndValue);
                    ByteCode classByteCode = (ByteCode) runTimeBlueprintByteCode.getDeclaredConstructor().newInstance();
                    programWithCodes.addCode(classByteCode);


                } else {

                    keyAndValue = keyAndValue.substring(0, keyAndValue.indexOf(" "));
                    keyAndValue = CodeTable.getClassName(keyAndValue);
                    Class runTimeBlueprintByteCode = Class.forName("interpreter.bytecode." + keyAndValue);
                    ByteCode classByteCode = (ByteCode) runTimeBlueprintByteCode.getDeclaredConstructor().newInstance();
                    programWithCodes.addCode(classByteCode);

                    additionalArgs = stringsplit.split(" ");
                    switch (additionalArgs.length) {
                        case 2:
                            classByteCode.init(additionalArgs[1]);
                            break;
                        case 3:
                            classByteCode.init(additionalArgs[1] + " " + additionalArgs[2]);
                            break;
                    }


                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return programWithCodes;
    }
}
