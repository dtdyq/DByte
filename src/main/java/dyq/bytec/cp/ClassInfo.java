/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassInfo extends ConstantInfo {
    private static final int type = 7;
    private short nameIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        ClassInfo classInfo = new ClassInfo();
        classInfo.nameIndex = dis.readShort();
        return classInfo;
    }

    @Override
    public int bytes() {
        return 2;
    }

    @Override
    public String str() {
        return "class_info[7](nameIndex) "+nameIndex;
    }

}
