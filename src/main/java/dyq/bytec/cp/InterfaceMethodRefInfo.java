/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class InterfaceMethodRefInfo extends ConstantInfo {
    private static final byte type = 11;
    private short classIndex;
    private short nameTypeIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        InterfaceMethodRefInfo info = new InterfaceMethodRefInfo();
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
        return "interface_method_ref_info[11](classIndex,nameAndTypeIndex) " + classIndex + " " + nameTypeIndex;
    }
}
