/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class FloatInfo extends ConstantInfo {
    private static final byte type = 4;
    private float val;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        FloatInfo info = new FloatInfo();
        info.val = dis.readFloat();
        return info;
    }

    @Override
    public int bytes() {
        return 4;
    }

    @Override
    public String str() {
        return "float_info[4](float) " + val;
    }
}
