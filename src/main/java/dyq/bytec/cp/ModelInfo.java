/*
 *
 */

package dyq.bytec.cp;

import java.io.DataInputStream;
import java.io.IOException;

public class ModelInfo extends ConstantInfo {
    private static final int type = 19;
    private short nameIndex;

    public ConstantInfo read(DataInputStream dis) throws IOException {
        ModelInfo classInfo = new ModelInfo();
        classInfo.nameIndex = dis.readShort();
        return classInfo;
    }

    @Override
    public int bytes() {
        return 2;
    }

    @Override
    public String str() {
        return "model_info[19](nameIndex) " + nameIndex;
    }

}
