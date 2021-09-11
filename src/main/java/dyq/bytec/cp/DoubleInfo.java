/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class DoubleInfo extends ConstantInfo {
    private static final byte type = 6;
    private double val;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        DoubleInfo info = new DoubleInfo();
        info.val = dis.readDouble();
        return info;
    }

    @Override
    public int bytes() {
        return 8;
    }

    @Override
    public String str() {
        return "double_info[6](double) " + val;
    }
}
