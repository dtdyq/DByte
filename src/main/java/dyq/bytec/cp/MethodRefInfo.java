/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodRefInfo extends ConstantInfo {
    private static final byte type = 10;
    private short classIndex;
    private short nameTypeIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        MethodRefInfo info = new MethodRefInfo();
        info.classIndex = dis.readShort();
        info.nameTypeIndex = dis.readShort();
        return info;
    }

    @Override
    public int bytes() {
        return 4;
    }

    @Override
    public String str() {
        return "method_ref_info[10](classIndex,nameAndTypeInfo) " + classIndex + " " + nameTypeIndex;
    }
}
