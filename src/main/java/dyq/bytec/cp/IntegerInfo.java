/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class IntegerInfo extends ConstantInfo {
    private static final byte type = 3;
    private int val;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        IntegerInfo info = new IntegerInfo();
        info.val = dis.readInt();
        return info;
    }

    @Override
    public int bytes() {
        return 4;
    }

    @Override
    public String str() {
        return "integer_info[3](integer) " + val;
    }
}
