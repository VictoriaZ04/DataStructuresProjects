import org.junit.Before;
import org.junit.Test;
import java.util.*;


import static org.junit.Assert.*;

public class BST_Unit_Test
{
    private BST_Interface<Integer> actual;


    @Test(timeout = 250)
    public void test1() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = new int[(int) (Math.random() * 10) + 8];
        for (int x = 0; x < thingsToAdd.length; x++)
            thingsToAdd[x] = (int) (Math.random() * 35) + 1;

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }
    }

    @Test(timeout = 250)
    public void test2() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = new int[(int) (Math.random() * 10) + 8];
        for (int x = 0; x < thingsToAdd.length; x++)
            thingsToAdd[x] = (int) (Math.random() * 35) + 1;

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        for (int x = 0; x < 25; x++) {
            int toFind = (int) (Math.random() * 35) + 1;
            if(!addedAlready.contains(toFind))
                assertFalse("contains("+toFind+") failed after "+fail,  actual.contains(toFind));
            else {
                assertTrue("contains("+toFind+") failed after "+fail,  actual.contains(toFind));
            }
        }
    }

    @Test(timeout = 250)
    public void test3() throws Exception
    {
        actual = new BST<>();

        assertTrue("empty() failed on an empty tree",actual.isEmpty());

        int[] thingsToAdd = new int[(int) (Math.random() * 10) + 8];
        for (int x = 0; x < thingsToAdd.length; x++)
            thingsToAdd[x] = (int) (Math.random() * 35) + 1;

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertFalse("empty() failed "+fail,actual.isEmpty());

        actual.clear();
        assertTrue("empty() failed "+fail+ " clear()",actual.isEmpty());

    }

    @Test(timeout = 250)
    public void test4() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = new int[(int) (Math.random() * 10) + 8];
        Integer min=0;
        for (int x = 0; x < thingsToAdd.length; x++) {
            thingsToAdd[x] = (int) (Math.random() * 35) + 1;
            if(x==0)
                min = thingsToAdd[x];
            else if(thingsToAdd[x]< min)
                min = thingsToAdd[x];
        }

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("minValue() failed " +fail,min,actual.minValue());
    }

    @Test(timeout = 250)
    public void test5() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = new int[(int) (Math.random() * 10) + 8];
        Integer max=0;
        for (int x = 0; x < thingsToAdd.length; x++) {
            thingsToAdd[x] = (int) (Math.random() * 35) + 1;
            if(x==0)
                max = thingsToAdd[x];
            else if(thingsToAdd[x] > max)
                max = thingsToAdd[x];
        }

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("minValue() failed " +fail,max,actual.maxValue());
    }

    // 3 max depths
    @Test(timeout = 250)
    public void test6() throws Exception
    {
        actual = new BST<>();

        assertEquals("maxDepth() failed on an empty tree",-1,actual.maxDepth());

        assertTrue("add(5) failed on an empty tree",  actual.add(5));
        assertEquals("maxDepth() failed after add(5)",0,actual.maxDepth());
        assertTrue("add(4) failed after add(5)",  actual.add(4));
        assertTrue("add(6) failed after add(5) add(4)",  actual.add(6));
        assertEquals("maxDepth() failed after add(5) add(4) add(6)",1,actual.maxDepth());
    }

    @Test(timeout = 250)
    public void test7() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,44,33,17,100,600,512};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("maxDepth() failed "+fail,5,actual.maxDepth());
    }

    @Test(timeout = 250)
    public void test8() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,-1,4,17,100,6};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("maxDepth() failed "+fail,3,actual.maxDepth());
    }

    // 3 pre
    @Test(timeout = 250)
    public void test9() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {3,2,4};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("preOrder() failed "+fail,"[3, 2, 4]",actual.preOrder());
    }

    @Test(timeout = 250)
    public void test10() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,44,33,17,100,600,512};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("preOrder() failed "+fail,"[8, 10, 44, 33, 17, 100, 600, 512]",actual.preOrder());
    }

    @Test(timeout = 250)
    public void test11() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,-1,4,17,100,6};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("preOrder() failed "+fail,"[8, -1, 4, 6, 10, 17, 100]",actual.preOrder());
    }

    //3 in
    @Test(timeout = 250)
    public void test12() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {3,2,4};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("inOrder() failed "+fail,"[2, 3, 4]",actual.inOrder());
    }

    @Test(timeout = 250)
    public void test13() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,44,33,17,100,600,512};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("inOrder() failed "+fail,"[8, 10, 17, 33, 44, 100, 512, 600]",actual.inOrder());
    }

    @Test(timeout = 250)
    public void test14() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,-1,4,17,100,6};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("inOrder() failed "+fail,"[-1, 4, 6, 8, 10, 17, 100]",actual.inOrder());
    }

    // 3 post
    @Test(timeout = 250)
    public void test15() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {3,2,4};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("postOrder() failed "+fail,"[2, 4, 3]",actual.postOrder());
    }

    @Test(timeout = 250)
    public void test16() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,44,33,17,100,600,512};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("postOrder() failed "+fail,"[17, 33, 512, 600, 100, 44, 10, 8]",actual.postOrder());
    }

    @Test(timeout = 250)
    public void test17() throws Exception
    {
        actual = new BST<>();

        int[] thingsToAdd = {8,10,-1,4,17,100,6};

        ArrayList<Integer> addedAlready = new ArrayList<>();

        String fail = "on an empty tree";
        for(int x = 0; x<thingsToAdd.length;x++) {
            if(addedAlready.contains(thingsToAdd[x]))
                assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
            else {
                assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                addedAlready.add(thingsToAdd[x]);
            }
            if(x==0)
                fail="after";
            fail+=" add(" + thingsToAdd[x] + ")";
        }

        assertEquals("postOrder() failed "+fail,"[6, 4, -1, 100, 17, 10, 8]",actual.postOrder());
    }

    // remove root no children
    @Test(timeout = 3000)
    public void test18() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {5};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(5) failed "+fail,actual.remove(5));

            assertEquals("preOrder() failed "+fail + " remove(5)","[]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(5)","[]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(5)","[]",actual.postOrder());
        }

    }

    // remove root children on both sides
    @Test(timeout = 3000)
    public void test19() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {5,6,7,4,3};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(5) failed "+fail,actual.remove(5));

            assertEquals("preOrder() failed "+fail + " remove(5)","[6, 4, 3, 7]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(5)","[3, 4, 6, 7]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(5)","[3, 4, 7, 6]",actual.postOrder());
        }

    }
    // remove root children on right only
    @Test(timeout = 3000)
    public void test20() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {5,7,6,8};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(5) failed "+fail,actual.remove(5));

            assertEquals("preOrder() failed "+fail + " remove(5)","[7, 6, 8]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(5)","[6, 7, 8]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(5)","[6, 8, 7]",actual.postOrder());
        }

    }
    // remove root children on left only
    @Test(timeout = 3000)
    public void test21() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {5,3,2};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(5) failed "+fail,actual.remove(5));

            assertEquals("preOrder() failed "+fail + " remove(5)","[3, 2]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(5)","[2, 3]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(5)","[2, 3]",actual.postOrder());
        }

    }
    // chain removal root on right
    @Test(timeout = 3000)
    public void test22() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {8,4,20,3,6,5,18,19,25,24,26};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(8) failed "+fail,actual.remove(8));

            assertEquals("preOrder() failed "+fail + " remove(8)","[18, 4, 3, 6, 5, 20, 19, 25, 24, 26]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(8)","[3, 4, 5, 6, 18, 19, 20, 24, 25, 26]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(8)","[3, 5, 6, 4, 19, 24, 26, 25, 20, 18]",actual.postOrder());
        }

    }
    // remove node no children
    @Test(timeout = 3000)
    public void test23() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {8,4,20,18};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(18) failed "+fail,actual.remove(18));

            assertEquals("preOrder() failed "+fail + " remove(18)","[8, 4, 20]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(18)","[4, 8, 20]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(18)","[4, 20, 8]",actual.postOrder());
        }

    }
    // remove node children on both sides
    @Test(timeout = 3000)
    public void test24() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {8,4,20,18,17,19};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(18) failed "+fail,actual.remove(18));

            assertEquals("preOrder() failed "+fail + " remove(18)","[8, 4, 20, 19, 17]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(18)","[4, 8, 17, 19, 20]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(18)","[4, 17, 19, 20, 8]",actual.postOrder());
        }

    }
    // remove node children on left only
    @Test(timeout = 3000)
    public void test25() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {8,4,20,18,17};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(18) failed "+fail,actual.remove(18));

            assertEquals("preOrder() failed "+fail + " remove(18)","[8, 4, 20, 17]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(18)","[4, 8, 17, 20]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(18)","[4, 17, 20, 8]",actual.postOrder());
        }

    }
    // chain removal node on left
    @Test(timeout = 3000)
    public void test26() throws Exception
    {
        actual = new BST<>();

        for(int test=0; test <120;test++)
        {
            actual = new BST<>();

            int[] thingsToAdd = {12,3,1,2,5,4,8,7,9,15,14,16,17};

            ArrayList<Integer> addedAlready = new ArrayList<>();

            String fail = "on an empty tree";
            for(int x = 0; x<thingsToAdd.length;x++) {
                if(addedAlready.contains(thingsToAdd[x]))
                    assertFalse("add(" + thingsToAdd[x] + ") failed "+fail,  actual.add(thingsToAdd[x]));
                else {
                    assertTrue("add(" + thingsToAdd[x] + ") failed " + fail, actual.add(thingsToAdd[x]));
                    addedAlready.add(thingsToAdd[x]);
                }
                if(x==0)
                    fail="after";
                fail+=" add(" + thingsToAdd[x] + ")";
            }
            assertTrue("remove(3) failed "+fail,actual.remove(3));

            assertEquals("preOrder() failed "+fail + " remove(3)","[12, 4, 1, 2, 5, 8, 7, 9, 15, 14, 16, 17]",actual.preOrder());
            assertEquals("inOrder() failed "+fail+ " remove(3)","[1, 2, 4, 5, 7, 8, 9, 12, 14, 15, 16, 17]",actual.inOrder());
            assertEquals("postOrder() failed "+fail+ " remove(3)","[2, 1, 7, 9, 8, 5, 4, 14, 17, 16, 15, 12]",actual.postOrder());
        }

    }
}

