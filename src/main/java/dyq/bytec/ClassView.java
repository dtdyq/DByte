/*
 *
 */

package dyq.bytec;

import dyq.bytec.desc.ClassDescription;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassView {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("please specify valid args");
            System.exit(-1);
        }
        DataInputStream inputStream = new DataInputStream(new FileInputStream(args[0]));
        ClassDescription.read(inputStream).print();
    }
}
