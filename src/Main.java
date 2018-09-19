public class Main {


    /** 0000 */
    private static final int FLAG_ONE = 0x1;
    /** 0010 */
    private static final int FLAG_TWO = 0x2;
    /** 0100 */
    private static final int FLAG_FOUR = 0x4;
    /** 1000 */
    private static final int FLAG_EIGHT = 0x8;


    private static int TARGET1 = FLAG_ONE | FLAG_EIGHT;

    private static int TARGET2 = FLAG_ONE | FLAG_TWO | FLAG_EIGHT;

    public static void main(String[] args) {

        test1();
        System.out.println("===================");
        test2();
        System.out.println("===================");
        test3();

    }

    /** 与或运算测试1 */
    private static void test1() {
        int result1 = TARGET1 & FLAG_ONE;
        System.out.println("result = " + result1);
        int result2 = TARGET1 & FLAG_TWO;
        System.out.println("result = " + result2);
        int result4 = TARGET1 & FLAG_FOUR;
        System.out.println("result = " + result4);
        int result8 = TARGET1 & FLAG_EIGHT;
        System.out.println("result = " + result8);
    }

    /** 与或运算测试2 */
    private static void test2() {
        int result1 = TARGET2 & FLAG_ONE;
        System.out.println("result = " + result1);
        int result2 = TARGET2 & FLAG_TWO;
        System.out.println("result = " + result2);
        int result4 = TARGET2 & FLAG_FOUR;
        System.out.println("result = " + result4);
        int result8 = TARGET2 & FLAG_EIGHT;
        System.out.println("result = " + result8);
    }

    /** 异或运算测试 */
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

}
