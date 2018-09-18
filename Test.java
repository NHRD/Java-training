public class Test{

    private int b = 3;

    public static void main(String[] args) {
        Test sum = new Test(1);
        sum = sum.testing();
        System.out.println(sum);
    }

    public Test(int size) {
        b = b + size;
    }

    public boolean someTest()  {
        return false;
    }

    public int testing() {
        if (!sometest()) {
            int a = 3;
            a = a + b;
        }
        return a;
    }

}