package thread.thread_local;

/**
 * This is the method for sample test of initial method of ThreadLocal
 *
 * @author by jacksonli
 */
public class ThreadLocalInitialMethod {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 200);

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
        threadLocal.set(20);
        System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
    }
}
