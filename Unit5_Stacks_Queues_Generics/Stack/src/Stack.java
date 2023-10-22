import java.util.ArrayList;

public class Stack<T> implements StackInterface{

    public ArrayList<T> stack = new ArrayList<T>();
    
    @Override
    public void push(Object o) {
        stack.add((T)o);
        
    }

    @Override
    public Object peek() {
        if(stack.size() > 0)
        return stack.get(stack.size()- 1);

        return null;
    }

    @Override
    public Object pop() {
        if(stack.size() > 0)
        return stack.remove(stack.size()- 1);

        return null;
    }

    @Override
    public boolean empty() {
        return stack.size() == 0;
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public Object get(int x) {
        if(stack.size() > x)
        return stack.get(x);

        return null;
    }

    @Override
    public void clear() {
        stack.clear();        
    }

}