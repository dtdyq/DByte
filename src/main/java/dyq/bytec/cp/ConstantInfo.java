/*
 *
 */

package dyq.bytec.cp;

import dyq.bytec.Info;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class ConstantInfo extends Info {
    public abstract ConstantInfo read(DataInputStream dis) throws IOException;

}
