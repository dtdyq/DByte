/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class StringInfo extends ConstantInfo {
    private static final byte type = 8;
    private short index;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        StringInfo info = new StringInfo();
        info.index = dis.readShort();
        return info;
    }

    @Override
    public int bytes() {
        return 2;
    }

    @Override
    public String str() {
        return "string_info[8](index) " + index;
    }
}
