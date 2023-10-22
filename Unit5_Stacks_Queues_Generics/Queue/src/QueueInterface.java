public interface QueueInterface<E>
{
	public boolean offer(E o);
	public E element();
	public E poll();
	public boolean empty();

	public int size();
	public E get(int x);

	public void clear();
}