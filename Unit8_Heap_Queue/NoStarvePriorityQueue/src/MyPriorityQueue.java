import java.util.ArrayList;

public class MyPriorityQueue<E extends Comparable> implements PriorityQueueInterface<E>{
    ArrayList<E> priorityQueue;

    public MyPriorityQueue(){
        priorityQueue = new ArrayList<E>();
    }

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
    public boolean offer(E o) {
        return add(o);
    }

    public E poll() {
        if(priorityQueue.isEmpty())
            return null;

        return priorityQueue.remove(0);
    }

    public E remove() {
        return poll();
    }

    public int size() {
        return priorityQueue.size();
    }

    public boolean empty() {
        return priorityQueue.size() == 0;
    }

    public void clear() {
        priorityQueue.clear();
        
    }

    public E get(int x) {
        return priorityQueue.get(x);
    }

    public E set(int x, E item) {
        return priorityQueue.set(x, item);
    }

    public E element() {
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