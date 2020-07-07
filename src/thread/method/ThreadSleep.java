package thread.method;

/**
 * Practice sleep() method
 *
 * @author jacksonli
 */
public class ThreadSleep implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadSleep());
        t.start();
        System.out.println("main start");
    }
}
