/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class NameAndTypeInfo extends ConstantInfo {
    private static final byte type = 12;
    private short nameIndex;
    private short descIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        NameAndTypeInfo info = new NameAndTypeInfo();
        info.nameIndex = dis.readShort();
        info.descIndex = dis.readShort();
        return info;
    }

    @Override
    public int bytes() {
        return 4;
    }

    @Override
    public String str() {
        return "name_type_info[12](nameIndex,typeIndex) " + nameIndex + " " + descIndex;
    }
}
