/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class DynamicInfo extends ConstantInfo {
    private static final byte type = 17;
    private short bsMethodAttrIndex;
    private short nameTypeIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        DynamicInfo info = new DynamicInfo();
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
        return "dynamic_info[17](bsMethodAttrIndex,nameAndTypeIndex) " + bsMethodAttrIndex + " " + nameTypeIndex;
    }
}
