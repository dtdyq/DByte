/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UTF8Info extends ConstantInfo {
    private static final byte type = 1;
    private short len;
    private String data;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        UTF8Info info = new UTF8Info();
        info.len = dis.readShort();
        byte[] bytes = new byte[info.len];
        dis.read(bytes, 0, info.len);
        info.data = new String(bytes, StandardCharsets.UTF_8);
        return info;
    }

    @Override
    public int bytes() {
        return 2 + data.getBytes().length;
    }

    @Override
    public String str() {
        return "utf8_info[1](len,data) " + len + " " + data;
    }
}
