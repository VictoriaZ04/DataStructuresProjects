import java.util.ArrayList;
import java.util.Iterator;

public class MySet<T> implements SetInterface{
    private ArrayList<T> set = new ArrayList<T>();

    @Override
    public boolean add(Object o) {
        if(set.contains((T)o)){
            return false;
        }
        set.add((T)o);

        return true;
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }

    @Override
    public boolean remove(Object o) {
        if(set.contains(o)){
            set.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }
}