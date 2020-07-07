package thread.implementation;

import java.util.concurrent.*;

/**
 * Create thread by implements callable interface
 *
 * @author jacksonli
 */
public class CreateThreadImplementsCallable implements Callable<Integer> {

    /**
     * Override the call method of Callable interface
     *
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThreadImplementsCallable thread = new CreateThreadImplementsCallable();
        // create executor service
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // submit executor
        Future<Integer> result = executorService.submit(thread);
        // get result
        int result1 = result.get();
        System.out.println(result1);
        // close service
        executorService.shutdownNow();
    }
}
