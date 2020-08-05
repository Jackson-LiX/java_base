package thread.cooperation;

/**
 * This is the sample implement of management method for producer/consumer model
 *
 * @author by jacksonli
 */
public class ProducerConsumerManagementMethod {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}

class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Product
        for (int i = 0; i < 100; i++) {
            System.out.println("Product-->" + i + " product");
            buffer.push(new Product(i));
        }
    }
}

class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Consume
        for (int i = 0; i < 100; i++) {
            System.out.println("Consume-->" + buffer.pop().id + " product");
        }
    }
}

class Buffer {

    private Product[] products = new Product[10];
    private int count = 0;

    /**
     * Product
     *
     * @param product
     */
    public synchronized void push(Product product) {
        // The buffer is full, not able to product
        if (count == products.length) {
            try {
                // The thread will release when consumer notify producer
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // The buffer is not full, able to product
        products[count] = product;
        count++;
        // The buffer is not empty, notify the consumer
        this.notify();
    }

    /**
     * Consume
     */
    public synchronized Product pop() {
        // The buffer is empty, not able to consume
        if (count == 0) {
            try {
                // The thread will release when producer notify consumer
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // The buffer is not empty, able to consume
        count--;
        Product product = products[count];
        // The buffer is not full, notify the producer
        this.notify();
        return product;
    }

}

class Product {

    int id;

    public Product(int id) {
        this.id = id;
    }
}
