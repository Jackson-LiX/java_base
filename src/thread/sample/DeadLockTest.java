package thread.sample;

/**
 * Mock the deadlock
 *
 * @author by jacksonli
 */
public class DeadLockTest {
    public static void main(String[] args) {
        new Thread(new Makeup(1, "test1")).start();
        new Thread(new Makeup(2, "test2")).start();
    }
}

class Mirror {

}

class Lipstick {

}

class Makeup implements Runnable {

    private static Lipstick lipstick = new Lipstick();
    private static Mirror mirror = new Mirror();
    private int choice;
    private String girl;

    public Makeup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeup();
    }

    /**
     * 相互持有对方的对象锁
     */
    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girl + "获得镜子");
                }
            }
            // 解决死锁 将同步块拿出来 避免一个同步块里面同时持有多个对象锁
//            synchronized (mirror) {
//                System.out.println(this.girl + "获得镜子");
//            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(this.girl + "获得口红");
                }
            }
            // 解决死锁 将同步块拿出来 避免一个同步块里面同时持有多个对象锁
//            synchronized (lipstick) {
//                System.out.println(this.girl + "获得口红");
//            }
        }
    }
}
