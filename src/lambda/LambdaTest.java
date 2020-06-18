package lambda;

/**
 * This is the lambda test class
 *
 * @author by jacksonli
 */
public class LambdaTest {
    public static void main(String[] args) {
        Lambda ab = (a, b) -> a + b;
        System.out.println(ab.getSum(100, 200));
    }
}

interface Lambda {
    int getSum(int a, int b);
}
