package thread;

/**
 * Create thread by extends thread class
 * @author by jacksonli
 */
public class CreateThreadExtendsThread extends Thread{

    /**
     * Override the run method of Thread class
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Basketball");
        }
    }

    public static void main(String[] args) {
        // 1. Create sub thread class
        Thread thread = new CreateThreadExtendsThread();
        // 2. Call the start method of sub thread class
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Music");
        }
    }
}
