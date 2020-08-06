package thread.cooperation;

/**
 * This is the sample implement of signal light for producer/consumer model
 *
 * @author by jacksonli
 */
public class ProducerConsumerSignalLight {
    public static void main(String[] args) {
        SignalLight signalLight = new SignalLight();
        new Thread(new ProducerForSignalLight(signalLight)).start();
        new Thread(new ConsumerForSignalLight(signalLight)).start();
    }
}

class ProducerForSignalLight implements Runnable {

    private final SignalLight signalLight;

    public ProducerForSignalLight(SignalLight signalLight) {
        this.signalLight = signalLight;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                signalLight.product("test" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerForSignalLight implements Runnable {

    private final SignalLight signalLight;

    public ConsumerForSignalLight(SignalLight signalLight) {
        this.signalLight = signalLight;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                signalLight.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SignalLight {

    private String name;

    /**
     * When the signal is true, the producer product, the consumer wait
     * When the signal is false, the consumer consume, the producer wait
     */
    private boolean signal = true;

    /**
     * Product
     *
     * @param name the product name
     * @throws InterruptedException when the wait() occupy exception
     */
    public synchronized void product(String name) throws InterruptedException {
        // The producer wait
        if (!signal) {
            this.wait();
        }
        // Start to product
        Thread.sleep(500);
        this.name = name;
        System.out.println("product " + name);
        this.notify();
        // Stop the producer
        this.signal = false;
    }

    /**
     * Consume
     *
     * @throws InterruptedException when the wait() occupy exception
     */
    public synchronized void consume() throws InterruptedException {
        // The consumer wait
        if (signal) {
            this.wait();
        }
        // Start to consume
        Thread.sleep(500);
        System.out.println("consume " + name);
        this.notify();
        // Stop the consumer
        this.signal = true;
    }

}
