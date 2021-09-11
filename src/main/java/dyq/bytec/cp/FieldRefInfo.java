/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class FieldRefInfo extends ConstantInfo {
    private static final byte type = 9;
    private short classIndex;
    private short nameTypeIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        FieldRefInfo info = new FieldRefInfo();
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
        return "field_ref_info[9](classIndex,nameAndTypeIndex) " + classIndex + " " + nameTypeIndex;
    }
}
