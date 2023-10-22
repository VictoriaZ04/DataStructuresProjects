public interface  PriorityQueueInterface<E extends Comparable>
{
    public boolean offer(E o);
    public E poll();
    public int size();
    public boolean empty();
    public void clear();
    public E get(int x);
    public E set(int x, E item);
    public E element();
}