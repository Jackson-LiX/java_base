package thread.implementation;

/**
 * Create thread by implements runnable interface
 *
 * @author jacksonli
 */
public class CreateThreadImplementsRunnable implements Runnable{
    private int ticketNumber = 99;
    private String winner;

    /**
     * Override the run method of Runnable interface
     */
    @Override
    public void run() {
        // Mock get ticket from internet
//        while (true) {
//            if (ticketNumber <= 0) {
//                break;
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " ----> " + ticketNumber--);
//        }

        // Mock tortoise and rabbit game
        for (int step = 1; step <= 100; step++) {
            if (Thread.currentThread().getName().equals("rabbit") && step % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + step);
            boolean gameOverFlag = gameOver(step);
            if (gameOverFlag) {
                break;
            }
        }

    }

    /**
     * Judge the game is over or not
     *
     * @param step
     * @return boolean
     */
    private boolean gameOver(int step) {
        if (winner != null) {
            return true;
        } else {
            if (step == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner --->" + Thread.currentThread().getName());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CreateThreadImplementsRunnable thread = new CreateThreadImplementsRunnable();
        // Mock get ticket from internet
//        new Thread(thread, "thread1").start();
//        new Thread(thread, "thread2").start();
//        new Thread(thread, "thread3").start();

        // Mock tortoise and rabbit game
        new Thread(thread, "tortoise").start();
        new Thread(thread, "rabbit").start();
    }
}
