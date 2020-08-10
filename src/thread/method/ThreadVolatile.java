package thread.method;

/**
 * Test the volatile of Thread
 *
 * @author by jacksonli
 */
public class ThreadVolatile {
    private volatile static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (number == 0) {

            }
        }).start();
        Thread.sleep(1000);
        number = 1;
    }
}
