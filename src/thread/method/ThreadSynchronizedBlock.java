package thread.method;

/**
 * Test synchronized method
 *
 * @author jacksonli
 */
public class ThreadSynchronizedBlock implements Runnable{
    private int ticketNumber = 99;
    private boolean flag = true;

    /**
     * Override the run method of Runnable interface
     */
    @Override
    public void run() {
        // Mock get ticket from internet
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
        }
    }

    /**
     * Check the ticket number
     */
    public void test() {
        while (true) {
            // synchronized code block
            synchronized (this) {
                if (ticketNumber <= 0) {
                    flag = false;
                    return;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // There will be negative
                // when the ticket number is 0 , A enter and sleep
                // then B enter, but the number is also 0, the number has not minus, because A is sleep
                // B sleep, the A and B awake, the number 0 minus twice
                System.out.println(Thread.currentThread().getName() + " ----> " + ticketNumber--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadSynchronized thread = new ThreadSynchronized();
        // Mock get ticket from internet
        new Thread(thread, "thread1").start();
        new Thread(thread, "thread2").start();
        new Thread(thread, "thread3").start();
    }
}
