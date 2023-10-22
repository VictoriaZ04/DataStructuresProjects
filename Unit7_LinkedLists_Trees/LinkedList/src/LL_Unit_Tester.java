import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LL_Unit_Tester
{
    private LinkedList list;

    //testing empty Lists checks
    @Test(timeout = 250)
    public void test1() throws Exception
    {
        list = new LinkedList<String>();
        assertEquals("size() failed on an empty list",0,list.size());
        assertTrue("isEmpty() failed on an empty list",list.isEmpty());
        assertNull("getFirstNode() failed on an empty list",list.getFirstNode());
        assertNull("getLastNode() failed on an empty list",list.getLastNode());
        assertEquals("toString() failed on an empty list","[]",list.toString());
    }

    //testing data after 1 item with addFirst
    @Test(timeout = 250)
    public void test2() throws Exception
    {
        list = new LinkedList<String>();
        list.addFirst("F");
        assertEquals("size() failed after addFirst(F)",1,list.size());
        assertFalse("isEmpty() failed after addFirst(F)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(F)","F",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(F)","F",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(F)","F",list.getFirst());
        assertEquals("getLast() failed after addFirst(F)","F",list.getLast());
        assertNull("getLast().getNext() failed after addFirst(F)",list.getLastNode().getNext());
        assertEquals("toString() failed after addFirst(F)","[F]",list.toString());
    }

    //testing data after 1 item with addLast
    @Test(timeout = 250)
    public void test3() throws Exception
    {
        list = new LinkedList<String>();
        list.addLast("L");
        assertEquals("size() failed after addLast(L)",1,list.size());
        assertFalse("isEmpty() failed after addLast(L)",list.isEmpty());
        assertEquals("getFirstNode() failed after addLast(L)","L",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addLast(L)","L",list.getLastNode().getData());
        assertEquals("getFirst() failed after addLast(L)","L",list.getFirst());
        assertEquals("getLast() failed after addLast(L)","L",list.getLast());
        assertNull("getLast().getNext() failed after addLast(L)",list.getLastNode().getNext());
        assertEquals("toString() failed after addLast(L)","[L]",list.toString());
    }

    //testing data after adding at spot 0 on an empty list
    @Test(timeout = 250)
    public void test4() throws Exception
    {
        list = new LinkedList<String>();
        list.add(0,"T");
        assertEquals("size() failed after add(0,T)",1,list.size());
        assertFalse("isEmpty() failed after add(0,T)",list.isEmpty());
        assertEquals("getFirstNode() failed after add(0,T)","T",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after add(0,T)","T",list.getLastNode().getData());
        assertEquals("getFirst() failed after add(0,T)","T",list.getFirst());
        assertEquals("getLast() failed after add(0,T)","T",list.getLast());
        assertNull("getLast().getNext() failed after add(0,T)",list.getLastNode().getNext());
        assertEquals("toString() failed after add(0,T)","[T]",list.toString());
    }

    //testing data after adding using add(size)
    @Test(timeout = 250)
    public void test5() throws Exception
    {
        list = new LinkedList<String>();
        list.addFirst("F");
        list.add(1,"L");
        assertEquals("size() failed after addFirst(F) add(1,L)",2,list.size());
        assertFalse("isEmpty() failed after addFirst(F) add(1,L)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(F) add(1,L)","F",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(F) add(1,L)","L",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(F) add(1,L)","F",list.getFirst());
        assertEquals("getLast() failed after addFirst(F) add(1,L)","L",list.getLast());
        assertNull("getLast().getNext() failed after addFirst(F) add(1,L)",list.getLastNode().getNext());
        assertEquals("toString() failed after addFirst(F) add(1,L)","[F, L]",list.toString());
    }

    //testing data add(index in the Axe of a list)
    @Test(timeout = 250)
    public void test6() throws Exception
    {
        list = new LinkedList<String>();
        list.addFirst("F");
        list.add(1,"A");
        list.addLast("L");
        assertEquals("size() failed after addFirst(F) add(1,A) addLast(L)",3,list.size());
        assertFalse("isEmpty() failed after addFirst(F) add(1,A) addLast(L)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(F) add(1,A) addLast(L)","F",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(F) add(1,A) addLast(L)","L",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(F) add(1,A) addLast(L)","F",list.getFirst());
        assertEquals("getLast() failed after addFirst(F) add(1,A) addLast(L)","L",list.getLast());
        assertEquals("get(1) failed after addFirst(F) add(1,A) addLast(L)","A",list.get(1));
        assertEquals("toString() failed addFirst(F) add(1,A) addLast(L)","[F, A, L]",list.toString());
        String[] answers = {"F", "A", "L"};

        LLNode<String> temp=list.getFirstNode();

        int correct=0;
        while(temp!=null)
        {
            if(temp.getData().equals(answers[correct])) {
                correct++;
            }
            temp=temp.getNext();
        }
        assertEquals("List Navigation failed after addFirst(F) add(1,A) addLast(L)",3,correct);

    }

    //testing clear
    @Test(timeout = 250)
    public void test7() throws Exception
    {
        list = new LinkedList<String>("First");
        list.addFirst("F");
        list.add(1,"A");
        list.addLast("L");
        list.clear();

        assertEquals("size() failed after addFirst(F) add(1,A) addLast(L) clear()",0,list.size());
        assertTrue("isEmpty() failed after addFirst(F) add(1,A) addLast(L) clear()",list.isEmpty());
        assertNull("getLast() failed after addFirst(F) add(1,A) addLast(L) clear()",list.getLastNode());
        assertEquals("toString() failed after addFirst(F) add(1,A) addLast(L) clear()","[]",list.toString());

    }

    //testing clear
    @Test(timeout = 250)
    public void test8() throws Exception
    {
        list = new LinkedList<String>();
        list.addFirst("F");
        list.add(1,"A");
        list.addLast("L");

        assertEquals("set(0,A) failed after addFirst(F) add(1,A) addLast(L)","F",list.set(0,"A"));
        assertEquals("set(1,B) failed after addFirst(F) add(1,A) addLast(L) set(0,A)","A",list.set(1,"B"));
        assertEquals("set(2,C) failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B)","L",list.set(2,"C"));
        assertEquals("size() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)",3,list.size());
        assertFalse("isEmpty() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)","A",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)","C",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)","A",list.getFirst());
        assertEquals("getLast() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)","C",list.getLast());
        assertEquals("get(1) failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)","B",list.get(1));
        assertEquals("toString() failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)","[A, B, C]",list.toString());
        String[] answers = {"A", "B", "C"};

        LLNode<String> temp=list.getFirstNode();

        int correct=0;
        while(temp!=null)
        {
            if(temp.getData().equals(answers[correct])) {
                correct++;
            }
            temp=temp.getNext();
        }
        assertEquals("List Navigation failed after failed after addFirst(F) add(1,A) addLast(L) set(0,A) set(1,B) set(2,C)",3,correct);
    }

    //testing remove 0 on size 1
    @Test(timeout = 250)
    public void test9() throws Exception
    {
        list = new LinkedList<String>();
        list.addFirst("N");


        assertEquals("remove(0) failed after add(N)","N",list.remove(0));
        assertEquals("size() failed after add(N) remove(N)",0,list.size());
        assertTrue("isEmpty() failed after add(N) remove(N)",list.isEmpty());
        assertNull("getFirstNode() failed after add(N) remove(N)",list.getFirstNode());
        assertNull("getLastNode() failed after add(N) remove(N)",list.getLastNode());
        assertEquals("toString() failed after add(N) remove(N)","[]",list.toString());


    }

    //testing remove
    @Test(timeout = 250)
    public void test10() throws Exception
    {
        list = new LinkedList<String>();
        list.addLast("R");
        list.addLast("3");
        list.addLast("RE");

        assertEquals("remove(0) failed after addLast(R) addLast(3) addLast(RE)","R", list.remove(0));
        assertEquals("size() failed after addLast(R) addLast(3) addLast(RE) remove(0)",2,list.size());
        assertFalse("isEmpty() failed after addLast(R) addLast(3) addLast(RE) remove(0)",list.isEmpty());
        assertEquals("getFirstNode() failed after addLast(R) addLast(3) addLast(RE) remove(0)","3",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addLast(R) addLast(3) addLast(RE) remove(0)","RE",list.getLastNode().getData());
        assertEquals("getFirst() failed after addLast(R) addLast(3) addLast(RE) remove(0)","3",list.getFirst());
        assertEquals("getLast() failed after addLast(R) addLast(3) addLast(RE) remove(0)","RE",list.getLast());
        assertEquals("toString() failed after addLast(R) addLast(3) addLast(RE) remove(0)","[3, RE]",list.toString());
        String[] answers = {"3", "RE"};

        LLNode<String> temp=list.getFirstNode();

        int correct=0;
        while(temp!=null)
        {
            if(temp.getData().equals(answers[correct])) {
                correct++;
            }
            temp=temp.getNext();
        }
        assertEquals("List Navigation failed after addLast(R) addLast(3) addLast(RE) remove(0)",2,correct);
    }

    //testing remove
    @Test(timeout = 250)
    public void test11() throws Exception
    {
        list = new LinkedList<String>();
        list.addLast("R");
        list.addLast("3");
        list.addLast("RE");

        assertEquals("remove(1) failed after addLast(R) addLast(3) addLast(RE)","3", list.remove(1));
        assertEquals("size() failed after addLast(R) addLast(3) addLast(RE) remove(1)",2,list.size());
        assertFalse("isEmpty() failed after addLast(R) addLast(3) addLast(RE) remove(1)",list.isEmpty());
        assertEquals("getFirstNode() failed after addLast(R) addLast(3) addLast(RE) remove(1)","R",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addLast(R) addLast(3) addLast(RE) remove(1)","RE",list.getLastNode().getData());
        assertEquals("getFirst() failed after addLast(R) addLast(3) addLast(RE) remove(1)","R",list.getFirst());
        assertEquals("getLast() failed after addLast(R) addLast(3) addLast(RE) remove(1)","RE",list.getLast());
        assertEquals("toString() failed after addLast(R) addLast(3) addLast(RE) remove(1)","[R, RE]",list.toString());
        String[] answers = {"R", "RE"};

        LLNode<String> temp=list.getFirstNode();

        int correct=0;
        while(temp!=null)
        {
            if(temp.getData().equals(answers[correct])) {
                correct++;
            }
            temp=temp.getNext();
        }
        assertEquals("List Navigation failed after addLast(R) addLast(3) addLast(RE) remove(1)",2,correct);
    }

    //testing remove
    @Test(timeout = 250)
    public void test12() throws Exception
    {
        list = new LinkedList<String>();
        list.addLast("R");
        list.addLast("3");
        list.addLast("RE");

        assertEquals("remove(2) failed after addLast(R) addLast(3) addLast(RE)","RE", list.remove(2));
        assertEquals("size() failed after addLast(R) addLast(3) addLast(RE) remove(2)",2,list.size());
        assertFalse("isEmpty() failed after addLast(R) addLast(3) addLast(RE) remove(2)",list.isEmpty());
        assertEquals("getFirstNode() failed after addLast(R) addLast(3) addLast(RE) remove(2)","R",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addLast(R) addLast(3) addLast(RE) remove(2)","3",list.getLastNode().getData());
        assertEquals("getFirst() failed after addLast(R) addLast(3) addLast(RE) remove(2)","R",list.getFirst());
        assertEquals("getLast() failed after addLast(R) addLast(3) addLast(RE) remove(2)","3",list.getLast());
        assertEquals("toString() failed after addLast(R) addLast(3) addLast(RE) remove(2)","[R, 3]",list.toString());
        String[] answers = {"R", "3"};

        LLNode<String> temp=list.getFirstNode();

        int correct=0;
        while(temp!=null)
        {
            if(temp.getData().equals(answers[correct])) {
                correct++;
            }
            temp=temp.getNext();
        }
        assertEquals("List Navigation failed after addLast(R) addLast(3) addLast(RE) remove(2)",2,correct);
    }

    //testing super Test
    @Test(timeout = 250)
    public void test13() throws Exception
    {
        list = new LinkedList<String>();
        list.addFirst("a");
        list.addLast("rr");
        assertEquals("remove(1) failed after addFirst(a) addLast(rr)","rr",list.remove(1));
        list.addFirst("2");
        list.add(2,"6");
        list.add(0,"pp");
        list.add(1,"5");
        assertEquals("set(2,f) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5)","2",list.set(2,"f"));
        assertEquals("set(0,ee) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f)","pp",list.set(0,"ee"));
        assertEquals("remove(3) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee)", "a",list.remove(3));
        assertEquals("remove(0) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3)","ee",list.remove(0));
        list.add(1,"1111");

        assertEquals("size() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)",4,list.size());
        assertFalse("isEmpty() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)",list.isEmpty());
        assertEquals("getFirstNode() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","5",list.getFirstNode().getData());
        assertEquals("getLastNode() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","6",list.getLastNode().getData());
        assertEquals("getFirst() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","5",list.getFirst());
        assertEquals("getLast() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","6",list.getLast());
        assertEquals("get(0) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","5",list.get(0));
        assertEquals("get(1) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","1111",list.get(1));
        assertEquals("get(2) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","f",list.get(2));
        assertEquals("get(3) failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","6",list.get(3));
        assertEquals("toString() failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)","[5, 1111, f, 6]",list.toString());


        String[] answers = {"5", "1111", "f","6"};

        LLNode<String> temp=list.getFirstNode();

        int correct=0;
        while(temp!=null)
        {
            if(temp.getData().equals(answers[correct])) {
                correct++;
            }
            temp=temp.getNext();
        }
        assertEquals("List Navigation failed after addFirst(a) addLast(rr) remove(1) addFirst(2) add(2,6) add(0,pp) add(1,5) set(2,f) set(0,ee) remove(3) remove(0) add(1,1111)",4,correct);
    }
}
