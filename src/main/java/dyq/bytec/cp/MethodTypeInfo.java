/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodTypeInfo extends ConstantInfo {
    private static final byte type = 16;
    private short descIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        MethodTypeInfo info = new MethodTypeInfo();
        info.descIndex = dis.readShort();
        return info;
    }

    @Override
    public int bytes() {
        return 2;
    }

    @Override
    public String str() {
        return "method_type_info[16](descIndex) " + descIndex;
    }
}
