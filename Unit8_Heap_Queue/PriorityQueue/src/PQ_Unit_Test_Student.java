import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;;//EditDelete
//Click to add an import
public class PQ_Unit_Test_Student {

    // Initialization code(click to edit)
    private PriorityQueueInterface<Integer> actualInt;
    private PriorityQueueInterface<String> actualString;

    @Before
    public void setUp() {
// Setup code(click to edit)
        actualInt = new MyPriorityQueue<>();
        actualString = new MyPriorityQueue<>();
    }

    @After
    public void tearDown() {
// TearDown code(click to edit)
    }



    @Test
    public void isEmptyOnEmptyPQ() {
// Failure message: 
// isEmpty failed on an empty queue
        assertTrue("isEmpty() failed", actualInt.isEmpty());
    }

    @Test
    public void isEmptyAfterAdds() {
// Failure message: 
// isEmpty failed on a PriorityQueue with data

        int[] thingsToAdd = new int[(int) (Math.random() * 10) + 10];
        for (int x = 0; x < thingsToAdd.length; x++) {
            thingsToAdd[x] = (int) (Math.random() * 35) + 1;
            actualInt.offer(thingsToAdd[x]);
        }

        assertFalse("empty() failed", actualInt.isEmpty());
    }

    @Test
    public void sizeRandomAddTests() {
// Failure message: 
// size failed after adding random elements
        for (int test = 0; test < 10; test++) {
            actualInt = new MyPriorityQueue<>();
            int[] thingsToAdd = new int[(int) (Math.random() * 10) + 10];
            for (int x = 0; x < thingsToAdd.length; x++) {
                thingsToAdd[x] = (int) (Math.random() * 35) + 1;
                actualInt.offer(thingsToAdd[x]);
            }
            

            assertEquals("size() failed to return the correct number", thingsToAdd.length, actualInt.size());
        }
    }

    @Test
    public void sizeOnEmptyPQ() {
// Failure message: 
// size failed to return 0 on an empty Priority Queue
        assertEquals("size() failed to return the correct number", 0, actualInt.size());
    }

    @Test
    public void removeAllInts() {
// Failure message: 
// Failed to remove values in the correct order after adding multiple times
        for (int test = 0; test < 10; test++) {
            actualInt = new MyPriorityQueue<>();
            int[] thingsToAdd = new int[(int) (Math.random() * 10) + 10];

            for (int x = 0; x < thingsToAdd.length; x++) {
                thingsToAdd[x] = (int) (Math.random() * 35) + 1;
                actualInt.offer(thingsToAdd[x]);
            }

            Arrays.sort(thingsToAdd);

            System.out.println(Arrays.toString(thingsToAdd) + " *" + actualInt.peek());
            System.out.println(actualInt);
            for (int x = 0; x < thingsToAdd.length; x++) {
                assertEquals("peek() failed to return the correct value", thingsToAdd[x], actualInt.peek().intValue());
                assertEquals("remove() failed to return the correct value", thingsToAdd[x], actualInt.poll().intValue());
            }
        }
    }

    @Test
    public void removeAllStrings() {
// Failure message: 
// Failed to remove values in the correct order after adding multiple times
        for (int test = 0; test < 10; test++) {
            actualString = new MyPriorityQueue<>();
            String[] thingsToAdd = new String[(int) (Math.random() * 10) + 10];

            for (int x = 0; x < thingsToAdd.length; x++) {
                int numLetters = (int) (Math.random() * 7 + 3);
                String s = "";
                for (int a = 0; a < numLetters; a++) {
                    int type = (int) (Math.random() * 3);
                    if (type == 0)
                        s += (char) (Math.random() * 10 + 48);
                    else if (type == 1)
                        s += (char) (Math.random() * 26 + 65);
                    else
                        s += (char) (Math.random() * 26 + 65);
                }
                thingsToAdd[x]=s;
                actualString.offer(thingsToAdd[x]);
            }

            Arrays.sort(thingsToAdd);

            for (int x = 0; x < thingsToAdd.length; x++) {
                assertEquals("peek() failed to return the correct value", thingsToAdd[x], actualString.peek());
                assertEquals("remove() failed to return the correct value", thingsToAdd[x], actualString.poll());
            }
        }
    }
}