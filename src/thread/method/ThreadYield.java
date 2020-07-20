package thread.method;

/**
 * Practice yield() method
 *
 * @author jacksonli
 */
public class ThreadYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "end");
    }

    public static void main(String[] args) {
        // The thread will pause
        ThreadYield yield = new ThreadYield();
        new Thread(yield, "thread1").start();
        new Thread(yield, "thread2").start();
    }
}
