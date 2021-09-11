/*
 *
 */

package dyq.bytec.desc;

import dyq.bytec.cp.ClassInfo;
import dyq.bytec.cp.ConstantInfo;
import dyq.bytec.cp.DoubleInfo;
import dyq.bytec.cp.DynamicInfo;
import dyq.bytec.cp.FieldRefInfo;
import dyq.bytec.cp.FloatInfo;
import dyq.bytec.cp.IntegerInfo;
import dyq.bytec.cp.InterfaceMethodRefInfo;
import dyq.bytec.cp.InvokeDynamicInfo;
import dyq.bytec.cp.LongInfo;
import dyq.bytec.cp.MethodHandleInfo;
import dyq.bytec.cp.MethodRefInfo;
import dyq.bytec.cp.MethodTypeInfo;
import dyq.bytec.cp.ModelInfo;
import dyq.bytec.cp.NameAndTypeInfo;
import dyq.bytec.cp.PackageInfo;
import dyq.bytec.cp.StringInfo;
import dyq.bytec.cp.UTF8Info;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ClassDescription {
    private static final Map<Byte, ConstantInfo> tagInfoMap = new HashMap<Byte, ConstantInfo>() {
        {
            put(Byte.valueOf("1"), new UTF8Info());
            put(Byte.valueOf("3"), new IntegerInfo());
            put(Byte.valueOf("4"), new FloatInfo());
            put(Byte.valueOf("5"), new LongInfo());
            put(Byte.valueOf("6"), new DoubleInfo());
            put(Byte.valueOf("7"), new ClassInfo());
            put(Byte.valueOf("8"), new StringInfo());
            put(Byte.valueOf("9"), new FieldRefInfo());
            put(Byte.valueOf("10"), new MethodRefInfo());
            put(Byte.valueOf("11"), new InterfaceMethodRefInfo());
            put(Byte.valueOf("12"), new NameAndTypeInfo());
            put(Byte.valueOf("15"), new MethodHandleInfo());
            put(Byte.valueOf("16"), new MethodTypeInfo());
            put(Byte.valueOf("17"), new DynamicInfo());
            put(Byte.valueOf("18"), new InvokeDynamicInfo());
            put(Byte.valueOf("19"), new ModelInfo());
            put(Byte.valueOf("20"), new PackageInfo());
        }
    };

    private String magicNum;

    private short minorVersion;

    private short majorVersion;

    private short cpCnt;

    private List<ConstantInfo> cpInfos = new ArrayList<>();

    private short thisClassAccessFlag;

    private short thisClassIndex;

    private short superClassIndex;

    private short interfaceCnt;

    private List<Short> interfaces = new ArrayList<>();

    private short fieldCnt;

    private List<FieldDescription> fields = new ArrayList<>();

    private short methodCnt;

    private List<MethodDescription> methods = new ArrayList<>();

    private short attrCnt;

    private List<AttributeDescription> attrs = new ArrayList<>();

    private ClassDescription() {
    }

    public static ClassDescription read(DataInputStream dis) throws IOException {
        ClassDescription cd = new ClassDescription();
        cd.magicNum = Integer.toHexString(dis.readInt());
        cd.minorVersion = dis.readShort();
        cd.majorVersion = dis.readShort();
        cd.cpCnt = dis.readShort();
        cd.cpInfos.add(null);
        for (int i = 1; i < cd.cpCnt; i++) {
            byte type = dis.readByte();
            cd.cpInfos.add(tagInfoMap.get(type).read(dis));
        }
        cd.thisClassAccessFlag = dis.readShort();
        cd.thisClassIndex = dis.readShort();
        cd.superClassIndex = dis.readShort();
        cd.interfaceCnt = dis.readShort();
        if (cd.interfaceCnt != 0) {
            for (int i = 0; i < cd.interfaceCnt; i++) {
                cd.interfaces.add(dis.readShort());
            }
        }
        cd.fieldCnt = dis.readShort();
        if (cd.fieldCnt != 0) {
            for (int i = 0; i < cd.fieldCnt; i++) {
                cd.fields.add(FieldDescription.read(dis));
            }
        }
        cd.methodCnt = dis.readShort();
        if (cd.methodCnt != 0) {
            for (int i = 0; i < cd.methodCnt; i++) {
                cd.methods.add(MethodDescription.read(dis));
            }
        }
        cd.attrCnt = dis.readShort();
        if (cd.attrCnt != 0) {
            for (int i = 0; i < cd.attrCnt; i++) {
                cd.attrs.add(AttributeDescription.read(dis));
            }
        }
        return cd;
    }

    private static String fixed(String s, int len) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < 25 - s.length(); i++) {
            sb.append(" ");
        }
        String lenStr = String.valueOf(len);
        lenStr = lenStr.length() == 1 ? lenStr + " " : lenStr;
        sb.append('[').append(lenStr).append(" bytes]").append(" : ");
        return sb.toString();
    }

    public void print() {
        StringBuilder out = new StringBuilder(fixed("magic number", 4) + this.magicNum + System.lineSeparator());
        out.append(fixed("minor version", 2)).append(this.minorVersion).append(System.lineSeparator());
        out.append(fixed("major version", 2)).append(this.majorVersion).append(System.lineSeparator());

        out.append(fixed("constant pool count", 2)).append(this.cpCnt).append(System.lineSeparator());
        IntStream.range(1, this.cpCnt).forEach(idx -> {
            ConstantInfo info = cpInfos.get(idx);
            out.append(fixed("    constant index " + idx, info.bytes()))
                .append(info.str())
                .append(System.lineSeparator());
        });

        out.append(fixed("this class access flag", 2))
            .append(Integer.toBinaryString(this.thisClassAccessFlag))
            .append(System.lineSeparator());
        out.append(fixed("this class index", 2)).append(this.thisClassIndex).append(System.lineSeparator());
        out.append(fixed("super class index", 2)).append(this.superClassIndex).append(System.lineSeparator());

        out.append(fixed("interface count", 2)).append(this.interfaceCnt).append(System.lineSeparator());
        IntStream.range(0, this.interfaceCnt).forEach(idx -> {
            Short info = interfaces.get(idx);
            out.append(fixed("    constant index " + idx, 2)).append(info).append(System.lineSeparator());
        });

        out.append(fixed("field count", 2)).append(this.fieldCnt).append(System.lineSeparator());
        IntStream.range(0, this.fieldCnt).forEach(idx -> {
            FieldDescription info = fields.get(idx);
            out.append(fixed("    field " + idx, info.bytes())).append(info.str()).append(System.lineSeparator());
        });

        out.append(fixed("method count", 2)).append(this.methodCnt).append(System.lineSeparator());
        IntStream.range(0, this.methodCnt).forEach(idx -> {
            MethodDescription info = methods.get(idx);
            out.append(fixed("    method " + idx, info.bytes())).append(info.str()).append(System.lineSeparator());
        });

        out.append(fixed("class attribute count", 2)).append(this.attrCnt).append(System.lineSeparator());
        IntStream.range(0, this.attrCnt).forEach(idx -> {
            AttributeDescription info = attrs.get(idx);
            out.append(fixed("    attribute " + idx, info.bytes())).append(info.str()).append(System.lineSeparator());
        });

        System.out.println(out);
    }
}
