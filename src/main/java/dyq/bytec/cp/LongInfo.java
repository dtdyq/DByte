/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class LongInfo extends ConstantInfo {
    private static final byte type = 5;
    private long val;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        LongInfo info = new LongInfo();
        info.val = dis.readLong();
        return info;
    }

    @Override
    public int bytes() {
        return 8;
    }

    @Override
    public String str() {
        return "long_info[5](long) " + val;
    }

}
