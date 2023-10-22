public class NSPQ_Node<E> implements Comparable
{
	private E data;
	private Integer priority;

	public NSPQ_Node(E data, Integer priority)
	{
		this.data 		= data;
		this.priority 	= priority;
	}

	public E getData()
	{ return data; }
	
	public void setData(E data)
	{ this.data = data; }
	
	public Integer getPriority()
	{ return priority; }
	
	public void setPriority(Integer priority)
	{  this.priority 	= priority; }
	
	public int compareTo(Object o)
	{
		NSPQ_Node<E> other = (NSPQ_Node<E>)o;
		return priority.compareTo(other.getPriority());
	}
	
	public String toString()
	{
		return "("+data+", "+priority+")"; 
	}
}
