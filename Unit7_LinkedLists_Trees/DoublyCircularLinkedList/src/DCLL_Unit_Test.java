import org.junit.Test;

import static org.junit.Assert.*;

public class DCLL_Unit_Test
{
    private DoublyCircularLinkedList<String> list;

    //testing empty Lists checks
    @Test(timeout = 250)
    public void test1() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        assertEquals("size() failed on an empty list",0,list.size());
        assertTrue("isEmpty() failed on an empty list",list.isEmpty());
        assertNull("getFirst() failed on an empty list",list.getFirstNode());
        assertNull("getLast() failed on an empty list",list.getLastNode());

    }

    //testing data after 1 item with addFirst
    @Test(timeout = 250)
    public void test2() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addFirst("P");
        assertEquals("size() failed after addFirst(P)",1,list.size());
        assertFalse("isEmpty() failed after addFirst(P)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(P)","P",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(P)","P",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(P)","P",list.getFirst());
        assertEquals("getLast() failed after addFirst(P)","P",list.getLast());
        assertTrue("getLast().getNext() failed after addFirst(P)",list.getLastNode().getNext()==list.getFirstNode());
        assertTrue("getFirst().getPrev() failed after addFirst(P)",list.getFirstNode().getPrev()==list.getLastNode());
    }

    //testing data after 1 item with addLast
    @Test(timeout = 250)
    public void test3() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addLast("L");
        assertEquals("size() failed after addLast(L)",1,list.size());
        assertFalse("isEmpty() failed after addLast(L)",list.isEmpty());
        assertEquals("getFirstNode() failed after addLast(L)","L",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addLast(L)","L",list.getLastNode().getData());
        assertEquals("getFirst() failed after addLast(L)","L",list.getFirst());
        assertEquals("getLast() failed after addLast(L)","L",list.getLast());
        assertTrue("getLast().getNext() failed after addLast(L)",list.getLastNode().getNext()==list.getFirstNode());
        assertTrue("getFirst().getPrev() failed after addLast(L)",list.getFirstNode().getPrev()==list.getLastNode());
    }

    //testing data after adding at spot 0 on an empty list
    @Test(timeout = 250)
    public void test4() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.add(0,"B");
        assertEquals("size() failed after add(0,B)",1,list.size());
        assertFalse("isEmpty() failed after add(0,B)",list.isEmpty());
        assertEquals("getFirstNode() failed after add(0,B)","B",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after add(0,B)","B",list.getLastNode().getData());
        assertEquals("getFirst() failed after add(0,B)","B",list.getFirst());
        assertEquals("getLast() failed after add(0,B)","B",list.getLast());
        assertTrue("getLast().getNext() failed after add(0,B)",list.getLastNode().getNext()==list.getFirstNode());
        assertTrue("getFirst().getPrev() failed after add(0,B)",list.getFirstNode().getPrev()==list.getLastNode());
    }

    //testing data after adding using add(size)
    @Test(timeout = 250)
    public void test5() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addFirst("P");
        list.add(1,"L");
        assertEquals("size() failed after addFirst(P) add(1,L)",2,list.size());
        assertFalse("isEmpty() failed after addFirst(P) add(1,L)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(P) add(1,L)","P",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(P) add(1,L)","L",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(P) add(1,L)","P",list.getFirst());
        assertEquals("getLast() failed after addFirst(P) add(1,L)","L",list.getLast());
        assertTrue("getLast().getNext() failed after addFirst(P) add(1,L)",list.getLastNode().getNext()==list.getFirstNode());
        assertTrue("getFirst().getPrev() failed after addFirst(P) add(1,L)",list.getFirstNode().getPrev()==list.getLastNode());
    }

    //testing data add(index in the middle of a list)
    @Test(timeout = 250)
    public void test6() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addFirst("P");
        list.add(1,"M");
        list.addLast("L");

        String[] answers = {"P", "M", "L"};

        listValidator(answers,"addFirst(P) add(1,M) addLast(L)");

    }

    //testing clear
    @Test(timeout = 250)
    public void test7() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addFirst("P");
        list.add(1,"M");
        list.addLast("L");
        list.clear();

        assertEquals("size() failed after addFirst(P) add(1,M) addLast(L) clear()",0,list.size());
        assertTrue("isEmpty() failed after addFirst(P) add(1,M) addLast(L) clear()",list.isEmpty());
    }

    //testing clear
    @Test(timeout = 250)
    public void test8() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addFirst("P");
        list.add(1,"M");
        list.addLast("L");

        assertEquals("set(0,A) failed after addFirst(P) add(1,M) addLast(L)","P",list.set(0,"A"));
        assertEquals("set(1,S) failed after addFirst(P) add(1,M) addLast(L) set(0,A)","M",list.set(1,"S"));
        assertEquals("set(2,C) failed after addFirst(P) add(1,M) addLast(L) set(0,A) set(1,S)","L",list.set(2,"C"));


        String[] answers = {"A", "S", "C"};

        listValidator(answers,"addFirst(P) add(1,M) addLast(L) set(0,A) set(1,S) set(2,C)");
    }

    //testing remove 0 on size 1
    @Test(timeout = 250)
    public void test9() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addFirst("N");


        assertEquals("remove(0) failed after addFirst(N)","N",list.remove(0));
        assertEquals("size() failed after addFirst(N) remove(0)",0,list.size());
        assertTrue("isEmpty() failed after addFirst(N) remove(0)",list.isEmpty());
        assertNull("getFirstNode() failed after addFirst(N) remove(0)",list.getFirstNode());
        assertNull("getLastNode() failed after addFirst(N) remove(0)",list.getLastNode());

    }

    //testing remove
    @Test(timeout = 250)
    public void test10() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addLast("M");
        list.addLast("88");
        list.addLast("P");
        list.addLast("7");
        assertEquals("remove(0) failed after addLast(M) addLast(88) addLast(P) addLast(7)","M", list.remove(0));

        String[] answers = {"88", "P","7"};

        listValidator(answers,"addLast(M) addLast(88) addLast(P) addLast(7) remove(0)");
    }

    //testing remove
    @Test(timeout = 250)
    public void test11() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addLast("M");
        list.addLast("88");
        list.addLast("P");
        list.addFirst("1");

        assertEquals("remove(1) failed  after addLast(M) addLast(88) addLast(P) addFirst(1)","M", list.remove(1));

        String[] answers = {"1","88", "P"};

        listValidator(answers,"addLast(M) addLast(88) addLast(P) addFirst(1) remove(1)");
    }

    //testing remove
    @Test(timeout = 250)
    public void test12() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addLast("M");
        list.addLast("88");
        list.add(2,"m");
        list.addLast("P");

        assertEquals("remove(3) failed after addLast(M) addLast(88) add(2,m) addLast(P)","P", list.remove(3));

        String[] answers = {"M", "88","m"};

        listValidator(answers,"addLast(M) addLast(88) add(2,m) addLast(P) remove(3)");
    }

    //testing super Test
    @Test(timeout = 250)
    public void test13() throws Exception
    {
        list = new DoublyCircularLinkedList<>();
        list.addLast("M");
        list.addLast("88");
        list.addLast("P");
        assertEquals("remove(0) failed after addLast(M) addLast(88) addLast(P)","M",list.remove(0));
        list.add(1,"S");
        list.add(3,"T");
        assertEquals("set(0,K) failed after addLast(M) addLast(88) addLast(P) remove(0) add(1,S) add(3,T)","88",list.set(0,"K"));
        list.addFirst("X");
        assertEquals("set(2,H) failed after addLast(M) addLast(88) addLast(P) remove(0) add(1,S) add(3,T) set(0,K) addFirst(X)","S",list.set(2,"H"));
        list.add(4,"4");
        list.add(3,"77");
        list.add(1,"1");


        String[] answers = {"X", "1","K", "H","77","P","4","T"};

        listValidator(answers,"addLast(M) addLast(88) addLast(P) remove(0) add(1,S) add(3,T) set(0,K) addFirst(X) set(2,H) add(4,4) add(3,77) add(1,1)");
    }

    private void listValidator(String[] expectedData, String commands)
    {
        //First Checks
        assertEquals("getFirst() failed after "+commands,expectedData[0],list.getFirstNode().getData());
        assertTrue("First does not have a previous of last after  "+commands,list.getFirstNode().getPrev()==list.getLastNode());

        //Last Checks
        assertEquals("getLast() failed after "+commands,expectedData[expectedData.length-1],list.getLastNode().getData());
        assertTrue("Last does not have a next of first on test "+commands,list.getLastNode().getNext()==list.getFirstNode());

        //Is Empty Check
        assertFalse("isEmpty() failed after"+commands,list.isEmpty());

        //Size check
        assertEquals("size() failed after "+commands,expectedData.length,list.size());

        // get checks
        for(int x=0; x<expectedData.length;x++)
        {
            System.out.println(list.get(x).equals(expectedData[x]));
            assertTrue("get("+x+") failed after "+commands,list.get(x).equals(expectedData[x]));
        }


        //forward
        int correct=0;
        DLLNode<String> temp=list.getFirstNode();
        for(int x=0; x<expectedData.length+1;x++)
        {
            if((temp.getData().equals(expectedData[correct%expectedData.length])))
                correct++;
            temp=temp.getNext();
        }

        assertEquals("After "+commands+ " forward navigation failed",expectedData.length+1,correct);

        //background
        correct=0;
        temp=list.getLastNode();
        for(int x=expectedData.length-1; x>=-1;x--)
        {
            String value=null;
            if(x!=-1)
                value = expectedData[expectedData.length-1-correct];
            else
                value = expectedData[expectedData.length-1];

            if((temp.getData().equals(value)))
                correct++;
            temp=temp.getPrev();
        }

        assertEquals("After "+commands+ " backward navigation failed",expectedData.length+1,correct);
    }
}
