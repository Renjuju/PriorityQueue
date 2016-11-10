import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void insertAValue() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        try {
            queue.insert("this is a string", 1);
        } catch(Exception e) {
            Assert.fail("insertion should not raise an exception");
        }
    }

    @Test
    public void getMaximumOfQueue() {
        PriorityQueue<car> queue = new PriorityQueue<>();
        queue.insert(new car("Honda"), 1);
        queue.insert(new car("Toyota"), 2);
        queue.insert(new car("Nissan"), 2);
        queue.insert(new car("Benz"), 3);

        Assert.assertEquals("Expects Benz to equal highest priority", "Benz", queue.maximum().getName());
    }

    @Test
    public void checkForStabilityInPriorityQueue() {
        PriorityQueue<car> queue = new PriorityQueue<>();
        queue.insert(new car("Honda"), 1);
        queue.insert(new car("Toyota"), 2);
        queue.insert(new car("Nissan"), 2);

        Assert.assertEquals("Expects Toyota to appear before nissan", "Toyota", queue.ExtractMax().getName());
        Assert.assertEquals("Expects Nissan to appear now in the queue", "Nissan", queue.ExtractMax().getName());
    }

    //making a class to test the queue with
    private class car {
        private String name;

        private car(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }
    }
}