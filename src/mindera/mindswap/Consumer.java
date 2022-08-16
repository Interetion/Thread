package mindera.mindswap;

public class Consumer implements Runnable {

    private int numberOfOrders;
    private Container<Integer> queue;

    public Consumer(Container<Integer> queue, int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (numberOfOrders > 0) {

                queue.poll();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}