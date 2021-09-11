/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class InvokeDynamicInfo extends ConstantInfo {
    private static final byte type = 18;
    private short bsMethodAttrIndex;
    private short nameTypeIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        InvokeDynamicInfo info = new InvokeDynamicInfo();
        info.bsMethodAttrIndex = dis.readByte();
        info.nameTypeIndex = dis.readShort();
        return info;
    }

    @Override
    public int bytes() {
        return 4;
    }

    @Override
    public String str() {
        return "invoke_dynamic_info[18](bsMethodAttrIndex,nameAndTypeIndex) " + bsMethodAttrIndex + " " + nameTypeIndex;
    }
}
