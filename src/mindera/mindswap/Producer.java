package mindera.mindswap;

public class Producer implements Runnable {
    private int numberOfPlates;
    private Container<Integer> container;


    public Producer(Container<Integer> container, int numberOfPlates) {
        this.numberOfPlates = numberOfPlates;
        this.container = container;
    }

    @Override
    public void run() {
        synchronized (container) {
            for (int i = 0; i < numberOfPlates; i++) {
                container.offer(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
