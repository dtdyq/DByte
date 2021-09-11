/*
 *
 */

package dyq.bytec.desc;

import dyq.bytec.Info;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodDescription extends Info {
    private short accessFlag;
    private short nameIndex;
    private short descIndex;

    private short attrCnt;

    private List<AttributeDescription> attrs = new ArrayList<>();

    public static MethodDescription read(DataInputStream dis) throws IOException {
        MethodDescription methodDescription = new MethodDescription();
        methodDescription.accessFlag = dis.readShort();
        methodDescription.nameIndex = dis.readShort();
        methodDescription.descIndex = dis.readShort();
        methodDescription.attrCnt = dis.readShort();
        if (methodDescription.attrCnt <= 0) {
            return methodDescription;
        }
        for (int i = 0; i < methodDescription.attrCnt; i++) {
            methodDescription.attrs.add(AttributeDescription.read(dis));
        }
        return methodDescription;
    }

    @Override
    public int bytes() {
        return 8 + attrs.stream().mapToInt(AttributeDescription::bytes).sum();
    }

    @Override
    public String str() {
        return "method_desc(flag,nameIndex,descIndex,attrs) " + accessFlag + " " + nameIndex + " " + descIndex + " "
            + attrCnt + ":" + attrs.stream().map(AttributeDescription::str).collect(Collectors.joining(","));
    }
}
