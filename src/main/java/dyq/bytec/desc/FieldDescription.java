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

public class FieldDescription extends Info {
    private short accessFlag;
    private short nameIndex;
    private short descIndex;
    private short attrCnt;
    private List<AttributeDescription> attrs = new ArrayList<>();

    public static FieldDescription read(DataInputStream dis) throws IOException {
        FieldDescription fieldDescription = new FieldDescription();
        fieldDescription.accessFlag = dis.readShort();
        fieldDescription.nameIndex = dis.readShort();
        fieldDescription.descIndex = dis.readShort();
        fieldDescription.attrCnt = dis.readShort();
        if (fieldDescription.attrCnt <= 0) {
            return fieldDescription;
        }
        for (int i = 0; i < fieldDescription.attrCnt; i++) {
            fieldDescription.attrs.add(AttributeDescription.read(dis));
        }
        return fieldDescription;
    }

    @Override
    public int bytes() {
        return 8 + attrs.stream().mapToInt(AttributeDescription::bytes).sum();
    }

    @Override
    public String str() {
        return "field_desc(flag,nameIndex,descIndex,attrs) " + accessFlag + " " + nameIndex + " " + descIndex + " "
            + attrCnt + ":" + attrs.stream().map(AttributeDescription::str).collect(Collectors.joining(","));
    }
}
