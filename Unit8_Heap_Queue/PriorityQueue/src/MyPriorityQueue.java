import java.util.ArrayList;

public class MyPriorityQueue<E extends Comparable> implements PriorityQueueInterface<E>{
    ArrayList<E> priorityQueue;

    public MyPriorityQueue(){
        priorityQueue = new ArrayList<E>();
    }

    @Override
    public boolean add(E o) {
        if(priorityQueue.size() == 0){
            priorityQueue.add(0, o);
        }
        else{
            for(int i = 0; i < priorityQueue.size(); i++){
                if(priorityQueue.get(i).compareTo(o) > 0){
                    priorityQueue.add(i, o);
                    break;
                } else if(i == priorityQueue.size() - 1){
                    priorityQueue.add(o);
                    break;
                }
            }
        }
        return true;
    }
// 1 1 1 2 3 6
    @Override
    public boolean offer(E o) {
        return add(o);
    }

    @Override
    public E poll() {
        if(priorityQueue.isEmpty())
            return null;

        return priorityQueue.remove(0);
    }

    @Override
    public E remove() {
        return poll();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.size() == 0;
    }

    @Override
    public void clear() {
        priorityQueue.clear();
        
    }

    @Override
    public E get(int x) {
        return priorityQueue.get(x);
    }

    @Override
    public E set(int x, E item) {
        return priorityQueue.set(x, item);
    }

    @Override
    public E peek() {
        if(priorityQueue.isEmpty())
            return null;

        return priorityQueue.get(0);
    }

    public String toString(){
        if(priorityQueue.size() == 0){
            return "";
        }

        String ret = priorityQueue.get(0) + "";
        for(int i = 1; i < priorityQueue.size(); i++){
            ret = ret + ", " + priorityQueue.get(i);
        }

        
        return ret;
    }
}