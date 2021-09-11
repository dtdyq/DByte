/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class PackageInfo extends ConstantInfo {
    private static final int type = 20;
    private short nameIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        PackageInfo classInfo = new PackageInfo();
        classInfo.nameIndex = dis.readShort();
        return classInfo;
    }

    @Override
    public int bytes() {
        return 2;
    }

    @Override
    public String str() {
        return "package_info[20](nameIndex) " + nameIndex;
    }

}
