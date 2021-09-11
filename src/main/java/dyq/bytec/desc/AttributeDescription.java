/*
 *
 */

package dyq.bytec.desc;

import dyq.bytec.Info;

import java.io.DataInputStream;
import java.io.IOException;

public class AttributeDescription extends Info {
    private short nameIndex;
    private int len;
    private byte[] data;

    public static AttributeDescription read(DataInputStream dis) throws IOException {
        AttributeDescription info = new AttributeDescription();
        info.nameIndex = dis.readShort();
        info.len = dis.readInt();
        byte[] bytes = new byte[info.len];
        dis.read(bytes, 0, info.len);
        info.data = bytes;
        return info;
    }

    @Override
    public int bytes() {
        return 6 + data.length;
    }

    @Override
    public String str() {
        return "attribute with name index " + nameIndex + " and " + bytes() + " bytes";
    }
}
