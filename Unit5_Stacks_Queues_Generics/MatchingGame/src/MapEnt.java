package src;

public class MapEnt<K,V>
{
	private K key;
	private V value;

	public MapEnt(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	public K getKey()
	{
		return key;
	}

	public V getValue()
	{
		return value;
	}

	public void setValue(V value)
	{
		this.value = value;
	}
	
	public void setKey(K key)
	{
		this.key = key;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof MapEnt)
		{
			MapEnt<K,V> t = (MapEnt<K,V>)o;
			return getKey().equals(t.getKey());
		}
		else
			return false;
	}
	
	public String toString()
	{
		return "("+key+" - "+value+")";
	}
}