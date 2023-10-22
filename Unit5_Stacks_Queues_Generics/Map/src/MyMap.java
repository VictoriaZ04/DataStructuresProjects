import java.util.ArrayList;
import java.util.Iterator;

public class MyMap<K,V> implements MapInterface{

    private MySet<MapEnt<K,V>> map = new MySet<>();
  

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        Iterator it = map.iterator();
        while(it.hasNext()){
            if(((MapEnt)it.next()).getKey() == key)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Iterator it = map.iterator();
        while(it.hasNext()){
            MapEnt x = (MapEnt)it.next();

            if((x).getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public SetInterface entrySet() {
        return map;
    }

    @Override
    public Object get(Object o) {
        Iterator it = map.iterator();
        while(it.hasNext()){
            MapEnt x = (MapEnt)it.next();
            if(x.getKey() == o)
                return x.getValue();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public SetInterface keySet() {
        MySet<K> keys = new MySet<K>();
        Iterator it = map.iterator();

        while(it.hasNext()){
            keys.add(((MapEnt)it.next()).getKey());
        }
        return keys;
    }

    @Override
    public Object put(Object key, Object value) {
        Iterator it = map.iterator();
        while(it.hasNext()){
            MapEnt x= (MapEnt)it.next();
            if(x.getKey() == key){
                V val = (V)x.getValue();
                x.setValue(value);
                return val;
            }
        }
        map.add(new MapEnt<K,V>((K)key, (V)value));
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object remove(Object key) {
        Iterator it = map.iterator();
        while(it.hasNext()){
            MapEnt h = (MapEnt)it.next();
            if((h.getKey()) == key){
                V val = (V)(h.getValue());
                map.remove(h);
                return val;
            }
        }
        return null;
    }

    @Override
    public ArrayList values() {
        ArrayList<V> keys = new ArrayList<V>();
        Iterator it = map.iterator();

        while(it.hasNext()){
            keys.add((V)((MapEnt)it.next()).getValue());
        }
        return keys;
    }
    
}
