package thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is the test class of Timer
 *
 * @author by jacksonli
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 5秒后执行一次
//        timer.schedule(new Task(), 5000);
        // 5秒后开始每五秒执行一次
//        timer.schedule(new Task(), 5000, 5000);
        // 确定时间开始每5秒执行一次
        timer.schedule(new Task(), new Date(), 5000);
    }
}

class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println("Hello Timer");
    }
}
