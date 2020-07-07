package thread.method;

/**
 * Practice join() method
 *
 * @author jacksonli
 */
public class ThreadJoin{
    public static void main(String[] args) {
        new Thread(new ThreadOne(), "thread1").start();
    }
}

class ThreadOne implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start");
        Thread thread = new Thread(new ThreadTwo(), "thread2");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }
}

class ThreadTwo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start");
        System.out.println(Thread.currentThread().getName() + "end");
    }
}
