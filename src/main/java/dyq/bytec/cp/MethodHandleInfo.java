/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodHandleInfo extends ConstantInfo {
    private static final byte type = 15;
    private byte refKind;
    private short refIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        MethodHandleInfo info = new MethodHandleInfo();
        info.refKind = dis.readByte();
        info.refIndex = dis.readShort();
        return info;
    }

    @Override
    public int bytes() {
        return 3;
    }

    @Override
    public String str() {
        return "method_handle_info[15](refKind,refIndex) " + refKind + " " + refIndex;
    }
}
