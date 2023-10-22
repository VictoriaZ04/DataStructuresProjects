import java.util.ArrayList;

public class Queue<T> implements QueueInterface{
    private ArrayList<T> queue = new ArrayList<T>();
    @Override
    public boolean offer(Object o) {
        return queue.add((T)o);
    }

    @Override
    public Object element() {
        if(queue.size() > 0)
            return queue.get(0);

        return null;
    }

    @Override
    public Object poll() {
        if(queue.size() > 0)
            return queue.remove(0);
        return null;
    }

    @Override
    public boolean empty() {
        return queue.size() == 0;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Object get(int x) {
        if(queue.size() > x)
            return queue.get(x);
        return null;
    }

    @Override
    public void clear() {
        queue.clear();
    }

    public String toString(){
        String ret = "";
        for(T i:queue){
            ret += i + ", ";
        }
        return ret;
    }
    
}
