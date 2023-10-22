public class LinkedList<E> implements LinkedListInterface<E>{

    LLNode<E> first;
    LLNode<E> last;
    
    public LinkedList(E data){
        first = new LLNode<E>(data);
        last = first;

    }

    public LinkedList(){

        first = null;
        last = null;
    }
    
    @Override
    public LLNode<E> getFirstNode() {

        return first;
    }

    @Override
    public LLNode<E> getLastNode() {

        return last;
    }

    @Override
    public E getFirst() {

        if(first == null)
            return null;
        return first.getData();
    }

    @Override
    public E getLast() {

        return getLastNode().getData();
    }

    @Override
    public E removeFirst() {

        E temp = first.getData();
        first = first.getNext();
        return temp;
    }

    @Override
    public E removeLast() {

        LLNode<E> temp = first;
        while(temp.getNext().getNext() == null){
            temp = temp.getNext();
        }
        E tempVal = temp.getNext().getData();

        temp.setNext(null);
        last = temp;
        return tempVal;
    }

    @Override
    public void addFirst(E data) {

        LLNode<E> temp = first;
        first = new LLNode<E>(data);
        first.setNext(temp);
        if(last == null){
            last = first;
        }
    }

    @Override
    public void addLast(E data) {
        LLNode<E> temp = new LLNode<E>(data);
        if(last == null){
            first = temp;
            last = temp;
        }
        else{
            getLastNode().setNext(temp);
            last = getLastNode().getNext();
        }
    }

    @Override
    public void clear() {

        first = null;
        last = null;
    }

    @Override
    public int size() {

        if(first == null)
            return 0;

        LLNode<E> temp = first;
        int counter = 1;
        while(temp.getNext() != null){
            temp = temp.getNext();
            counter++;
        }
        return counter;
    }

    @Override
    public E get(int x) {

        LLNode<E> temp = first;

        if(size() == 0){
            return null;
        }


        for(int i = 0; i < x; i++){
            if(temp.getNext() == null){
                return null;
            }
            temp = temp.getNext();
            
        }
        
        return temp.getData();
    }

    @Override
    public void add(int x, E data) {

        LLNode<E> temp = first;
        LLNode<E> newNode = new LLNode<E>(data);
        if(size() == 0){
            first = newNode;
            last = newNode;
        }
        else if(x == 0){
            newNode.setNext(first);
            first = newNode;
        }
        else{
            if(x == size()){
                temp = last;
                last = newNode;
            }
            else{
                for(int i = 1; i < x; i++){
                    if(temp.getNext() == null){
                        break;
                    }
                    temp = temp.getNext();
                    
                }
            }

            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    @Override
    public E remove(int x) {

        LLNode<E> temp = first;
        E ret;
        if(size() == 1 && x == 0){
            first = null;
            last = null;
            return temp.getData();
        }
        if(x == size() - 1){
            ret = last.getData();
            LLNode<E> count = first;
            for(int i = 0; i < size() - 2; i++){
                count = count.getNext();
            
            }
            last = count;
            count.setNext(null);
            return ret;
        }
        else{
            for(int i = 0; i < x - 1; i++){
                if(temp.getNext() == null){
                    break;
                }
                temp = temp.getNext();
                
            }
        }

        ret = temp.getNext().getData();

        if(x != 0){
            temp.setNext(temp.getNext().getNext());
        }
        if(x == 0){ 
            ret = first.getData();
            first = first.getNext();
        }
        return ret;
    }

    @Override
    public E set(int x, E data) {

        LLNode<E> temp = first;
        E ret;
        for(int i = 0; i < x; i++){
            if(temp.getNext() == null){
                return null;
            }
            if(i == x - 1 && x == size()){
                last = temp;
            }
            temp = temp.getNext();
            
        }

        ret = temp.getData();
        temp.setData(data);

        return ret;
    }

    @Override
    public boolean isEmpty() {

        return (first == null);
    }

    @Override
    public String toString(){
        String ret = "[";
        if(size() > 0){
            ret += get(0);
        }
        for(int i = 1; i < size(); i++){
            ret += ", " + get(i);
        }
        ret += "]";
        return ret;
    }
    
}
