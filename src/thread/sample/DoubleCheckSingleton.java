package thread.sample;

/**
 * Implement the singleton pattern
 *
 * @author by jacksonli
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {};

    public static DoubleCheckSingleton getInstance() {
        if (null != instance) {
            return instance;
        }
        synchronized (DoubleCheckSingleton.class) {
            if (null == instance) {
                instance = new DoubleCheckSingleton();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(DoubleCheckSingleton.getInstance());
        });
        thread.start();
        System.out.println(DoubleCheckSingleton.getInstance());
    }
}
