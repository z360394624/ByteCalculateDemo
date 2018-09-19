# Java位运算应用

常见的问运算包括：与(&)、或(|)、非(~)、异或(^)、左位移(<<)、右位移(>>或>>>)

- 与运算：运算符两边操作数同为1时结果为1，否则为0。例：```1010 & 1100 = 1000```，多位运算时按位与；
- 或运算：运算符两边操作数同为0时结果为0，否则为1。例：```1010 | 1100 = 1110```,多位运算同上；
- 非运算：对运算符右边的操作数按位取反，1变0，0变1。例：```~1010 = 0101```；
- 异或运算：运算符两边操作数按位同为1或0时结果为0，不同时为1。例：```1010^1100 = 0110```；
- 左位移运算：左丢弃最高位，0补最低位。例：```1010<<2 = 1000```,丢弃前两位10，低位补0；
- 右位移运算：(>>)"有符号"右移，符号为正，高位补0，符号为负高位补1。(>>>)"无符号"右移，无论正负，高位补0；



### 与或运算应用
包含关系判断
##### 定义：    
    
        /** 0000 */
        private static final int FLAG_ONE = 0x1;
        /** 0010 */
        private static final int FLAG_TWO = 0x2;
        /** 0100 */
        private static final int FLAG_FOUR = 0x4;
        /** 1000 */
        private static final int FLAG_EIGHT = 0x8;
    
        /** 1000 */
        private static int TARGET1 = FLAG_ONE | FLAG_EIGHT;
        
        /** 1010 */
        private static int TARGET2 = FLAG_ONE | FLAG_TWO | FLAG_EIGHT;
        
        
1. FLAG_ONE、FLAG_TWO、FLAG_FOUR、FLAG_EIGHT 二进制的值分别为0000、0010、0100、1000    
2. TARGET1与TARGET2为或运算结果

##### 测试方法：
        
        private static void test1() {
            int result1 = TARGET1 & FLAG_ONE;
            System.out.println("result1 = " + result1);
            int result2 = TARGET1 & FLAG_TWO;
            System.out.println("result2 = " + result2);
            int result4 = TARGET1 & FLAG_FOUR;
            System.out.println("result4 = " + result4);
            int result8 = TARGET1 & FLAG_EIGHT;
            System.out.println("result8 = " + result8);
        }

result1、result2、result4、result8结果表示了TARGET1与四个FLAG值的与运算    
##### 结果验证位：    
        
        result1 = 1
        result2 = 0
        result4 = 0
        result8 = 8
        
TARGET1是FLAG_ONE与FLAG_EIGHT的或运算结果，所以对应的result1、result8都不为0    
##### 原理：    
        
        1111 | 0000 = 1111
        1111 & 0000 = 0000
        1111 & 1111 = 1111
        
        1010 | 0101 = 1111
        1111 & 1010 = 1010
        1111 & 0101 = 0101
        
        a | b = c
        c & a = a
        c & b = b
        
### 异或运算应用
变量值交换
##### 测试方法：
        
        private static void test3() {
            int var1 = FLAG_ONE;
            int var2 = FLAG_TWO;
            System.out.println("var1 = " + var1 + "; var2 = " + var2);
            // 交换var1和var2的值
            var1 = var1 ^ var2;
            // a ^ a = 0
            // b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
            var2 = var1 ^ var2;
            // a = a ^ (a ^ b) = (a ^ a) ^ b = 0 ^ b = b
            var1 = var2 ^ var1;
            System.out.println("==========swicth===========");
            System.out.println("var1 = " + var1 + "; var2 = " + var2);
        }
        
##### 原理：
        
        a ^ a = 0
        a ^ 0 = a 