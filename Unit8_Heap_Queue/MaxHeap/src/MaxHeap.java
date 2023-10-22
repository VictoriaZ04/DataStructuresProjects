import java.util.ArrayList;

public class MaxHeap<E extends Comparable> implements HeapInterface<E>{
    ArrayList<E> heap;

    public MaxHeap(){
        heap = new ArrayList<E>();
    }

    @Override
    public boolean add(E item) {
        int index = heap.size();
        heap.add(item);
        while(index != 0 && (item.compareTo(heap.get((index-1)/2)) > 0)){
            heap.set(index, heap.get((index-1)/2));
            heap.set((index-1)/2, item);
            index = (index-1)/2;
        }
        
        return true;
    }
    public boolean insert(E item){
        return add(item);
    }

    @Override
    public E remove() {
        if(heap.size() == 0){
            return null;
        }

        E ret = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int index = 0;
        while(index != heap.size() - 1){
            E left = null;
            E right = null;

            if(heap.size() > (index*2)+2){
                right = heap.get((index*2)+2);
                left = heap.get((index*2)+1);
            }else if(heap.size() > (index*2)+1){
                left = heap.get((index*2)+1);
            }
            else{
                break;
            }

            boolean rightb = false;
            boolean leftb = false;
            E temp = heap.get(index);
            if(right != null && right.compareTo(heap.get(index)) > 0){
                rightb = true;
            }
            if(left != null && left.compareTo(heap.get(index)) > 0){
                leftb = true;
            }

            if(leftb && rightb){
                if(left.compareTo(right) == 0 || left.compareTo(right) < 0){
                    heap.set(index, right);
                    heap.set((index*2)+2, temp);
                    index = (index*2)+2;
                }
                else if(left.compareTo(right) > 0){
                    heap.set(index, left);
                    heap.set((index*2)+1, temp);
                    index = (index*2)+1;
                }
            }
            else if(leftb){
                heap.set(index, left);
                heap.set((index*2)+1, temp);
                index = (index*2)+1;
            }
            else if(rightb){
                heap.set(index, right);
                heap.set((index*2)+2, temp);
                index = (index*2)+2;
            }
            else{
                break;
            }

            
        }
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public E get(int x) {
        return heap.get(x);
    }

    @Override
    public void clear() {
        heap.clear();
    }
    
    public String toString(){
        return heap.toString();
    }

   

    
    
}
