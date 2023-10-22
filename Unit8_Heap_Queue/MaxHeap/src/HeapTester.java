import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.Iterator;

import static org.junit.Assert.*;

public class HeapTester
{
    private HeapInterface<Integer> actual;

    @Test(timeout = 250)
    public void emptyTests() throws Exception
    {
        actual = new MaxHeap<>();
        assertTrue("empty() failed on a new heap",actual.isEmpty());

        int[] thingsToAdd = {1,7,5,6,7,3,8,9,1,3};
        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        assertFalse("empty() failed after adding multiple item",actual.isEmpty());

        actual.clear();
        assertTrue("empty() failed after clearing a heap with data",actual.isEmpty());
    }

    @Test(timeout = 250)
    public void sizeTestWithAdd() throws Exception
    {
        actual = new MaxHeap<>();
        assertEquals("size() failed on a new heap",0,actual.size());

        int[] thingsToAdd = {1,7,5,6,7,3,8,9,1,3};
        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        assertEquals("size() failed after adding multiple item",thingsToAdd.length,actual.size());

        actual.clear();
        assertEquals("size() failed after clearing a heap with data",0,actual.size());
    }

    @Test(timeout = 250)
    public void getAdd() throws Exception
    {
        actual = new MaxHeap<>();

        int[] thingsToAdd = {1,7,5,6,7,3,8,9,1,3};
        int[]getResults = {9, 8, 7, 7, 6, 3, 5, 1, 1, 3};

        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        for(int x = 0; x<thingsToAdd.length;x++)
            assertEquals("get() failed after adding multiple items",getResults[x],actual.get(x).intValue());
    }

    @Test(timeout = 250)
    public void sizeTestWithAddAndRemove() throws Exception
    {
        actual = new MaxHeap<>();
        assertEquals("size() failed on a new heap",0,actual.size());

        int[] thingsToAdd = {1,7,5,6,7,3,8,9,1,3};
        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        actual.remove();
        actual.remove();

        assertEquals("size() failed after adding multiple items and then removing twice",thingsToAdd.length-2,actual.size());
    }

    @Test(timeout = 250)
    public void addAndOrderTestWithToStringTest1() throws Exception
    {
        actual = new MaxHeap<>();

        int[] thingsToAdd = {1,7,5,6,7,3,8,9,1,3};
        int[]getResults = {9, 8, 7, 7, 6, 3, 5, 1, 1, 3};
        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        assertEquals("toString() failed after adding multiple items","[9, 8, 7, 7, 6, 3, 5, 1, 1, 3]",actual.toString());
    }

    @Test(timeout = 250)
    public void addAndOrderTestWithToStringTest2() throws Exception
    {
        actual = new MaxHeap<>();

        int[] thingsToAdd = {-1,8,7,9,78,4,4,44,1,0};
        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        assertEquals("toString() failed after adding multiple items","[78, 44, 7, 9, 8, 4, 4, -1, 1, 0]",actual.toString());
    }

    @Test(timeout = 250)
    public void orderAfterEveryRemove() throws Exception
    {
        actual = new MaxHeap<>();

        int[] thingsToAdd = {-1,8,7,9,78,4,4,44,1,0};

        long[] removeReults = {78,44,9,8,7,4,4,1,0,-1};
        String[] answers = {
                "[44, 9, 7, 1, 8, 4, 4, -1, 0]",
                "[9, 8, 7, 1, 0, 4, 4, -1]",
                "[8, 1, 7, -1, 0, 4, 4]",// dis bad
                "[7, 1, 4, -1, 0, 4]",
                "[4, 1, 4, -1, 0]",
                "[4, 1, 0, -1]",
                "[1, -1, 0]",
                "[0, -1]",
                "[-1]",
                "[]"
        };

        for(int x = 0; x<thingsToAdd.length;x++)
            actual.add(thingsToAdd[x]);

        for(int x = 0; x<thingsToAdd.length;x++) {
            assertEquals("remove() failed to remove the correct value", removeReults[x], actual.remove().intValue());
            assertEquals("toString() failed after adding multiple items and then processing remove(s)", answers[x], actual.toString());
        }
        assertTrue("isEmpty() failed after adding multiple items and then removing them all",actual.isEmpty());
    }
}
