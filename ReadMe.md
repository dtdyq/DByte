### DByte

class文件查看工具，可打印class文件结构、字节数和相关信息

输出样例：
```java
public class View implements Cloneable {
    private int val;

    public void setVal(int v) {
        this.val = v;
    }
}
```
```shell
magic number             [4  bytes] : cafebabe
minor version            [2  bytes] : 0
major version            [2  bytes] : 52
constant pool count      [2  bytes] : 25
    constant index 1     [4  bytes] : method_ref_info[10](classIndex,nameAndTypeInfo) 4 20
    constant index 2     [4  bytes] : field_ref_info[9](classIndex,nameAndTypeIndex) 3 21
    constant index 3     [2  bytes] : class_info[7](nameIndex) 22
    constant index 4     [2  bytes] : class_info[7](nameIndex) 23
    constant index 5     [2  bytes] : class_info[7](nameIndex) 24
    constant index 6     [5  bytes] : utf8_info[1](len,data) 3 val
    constant index 7     [3  bytes] : utf8_info[1](len,data) 1 I
    constant index 8     [8  bytes] : utf8_info[1](len,data) 6 <init>
    constant index 9     [5  bytes] : utf8_info[1](len,data) 3 ()V
    constant index 10    [6  bytes] : utf8_info[1](len,data) 4 Code
    constant index 11    [17 bytes] : utf8_info[1](len,data) 15 LineNumberTable
    constant index 12    [20 bytes] : utf8_info[1](len,data) 18 LocalVariableTable
    constant index 13    [6  bytes] : utf8_info[1](len,data) 4 this
    constant index 14    [8  bytes] : utf8_info[1](len,data) 6 LView;
    constant index 15    [8  bytes] : utf8_info[1](len,data) 6 setVal
    constant index 16    [6  bytes] : utf8_info[1](len,data) 4 (I)V
    constant index 17    [3  bytes] : utf8_info[1](len,data) 1 v
    constant index 18    [12 bytes] : utf8_info[1](len,data) 10 SourceFile
    constant index 19    [11 bytes] : utf8_info[1](len,data) 9 View.java
    constant index 20    [4  bytes] : name_type_info[12](nameIndex,typeIndex) 8 9
    constant index 21    [4  bytes] : name_type_info[12](nameIndex,typeIndex) 6 7
    constant index 22    [6  bytes] : utf8_info[1](len,data) 4 View
    constant index 23    [18 bytes] : utf8_info[1](len,data) 16 java/lang/Object
    constant index 24    [21 bytes] : utf8_info[1](len,data) 19 java/lang/Cloneable
this class access flag   [2  bytes] : 100001
this class index         [2  bytes] : 3
super class index        [2  bytes] : 4
interface count          [2  bytes] : 1
    constant index 0     [2  bytes] : 5
field count              [2  bytes] : 1
    field 0              [8  bytes] : field_desc(flag,nameIndex,descIndex,attrs) 2 6 7 0:
method count             [2  bytes] : 2
    method 0             [61 bytes] : method_desc(flag,nameIndex,descIndex,attrs) 1 8 9 1:attribute with name index 10 and 53 bytes
    method 1             [76 bytes] : method_desc(flag,nameIndex,descIndex,attrs) 1 15 16 1:attribute with name index 10 and 68 bytes
class attribute count    [2  bytes] : 1
    attribute 0          [8  bytes] : attribute with name index 18 and 8 bytes
```