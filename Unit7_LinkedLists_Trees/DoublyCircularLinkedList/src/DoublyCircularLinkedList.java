public class DoublyCircularLinkedList<E> implements DoublyCircularLinkedListInt<E>{
    DLLNode<E> first, last;

    public DoublyCircularLinkedList(){
        first = null;
        last = null;
    }

    public DoublyCircularLinkedList(E data){
        first = new DLLNode<E>(data);
        last = first;
    }
    @Override
    public DLLNode<E> getFirstNode() {
        return first;
    }

    @Override
    public DLLNode<E> getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        return first.getData();
    }

    @Override
    public E getLast() {
        return last.getData();
    }

    @Override
    public E removeFirst() {
        if(size() == 0)
            return null;
        if(size() == 1){
            E temp = first.getData();
            first = null;
            last = null;
            return temp;
        }
        E temp = first.getData();
        first = first.getNext();
        last.setNext(first);
        first.setPrev(last);
        return temp;
    }

    @Override
    public E removeLast() {
        if(size() == 0)
            return null;
        if(size() == 1){
            E temp = first.getData();
            first = null;
            last = null;
            return temp;
        }
        E temp = last.getData();
        last = last.getPrev();
        first.setPrev(last);
        last.setNext(first);
        return temp;
    }

    @Override
    public void addFirst(E data) {
        if(size() == 0){
            first = new DLLNode<E>(data);
            last = first;

            first.setNext(first);
            first.setPrev(first);

            last.setNext(first);
            last.setPrev(first);
        }
        else{
            
            DLLNode<E> temp = first;
            first = new DLLNode<E>(data);
            first.setNext(temp);
            first.setPrev(last);
            last.setNext(first);
            temp.setPrev(first);      
        }      
        
    }

    @Override
    public void addLast(E data) {
        if(size() == 0){
            first = new DLLNode<E>(data);
            first.setNext(first);
            first.setPrev(first);
            last = first;
            last.setNext(first);
            last.setPrev(first);
        }
        else{
            
            DLLNode<E> temp = last;
            last = new DLLNode<E>(data);
            first.setPrev(last);
            last.setNext(first);
            last.setPrev(temp);
            temp.setNext(last);
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

        int ret = 0;
        DLLNode<E> temp = first;
        do{
            temp = temp.getNext();
            ret++;
        }while(temp != first);

        return ret;
    }

    @Override
    public E get(int x) {
        if(x == 0)
            return first.getData();
        DLLNode<E> temp = first;
        for(int i = 0; i < x; i++){
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public void add(int x, E data) {
        if(x == 0){
            addFirst(data);
        }
        else{
            DLLNode<E> temp = first;
            for(int i = 0; i < x; i++){
                temp = temp.getNext();
            }
            DLLNode<E> newNode = new DLLNode<E>(data);
            temp.getPrev().setNext(newNode);
            newNode.setNext(temp);
            newNode.setPrev(temp.getPrev());
            temp.setPrev(newNode);
            
            if(x == size() - 1){
                last = newNode;
            }
        }
    }

    @Override
    public E remove(int x) {
        if(x == 0){
            return removeFirst();
        }
        if(x == size() - 1){
            return removeLast();
        }
        DLLNode<E> temp = first;
        for(int i = 0; i < x; i++){
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        return temp.getData();
    }

    @Override
    public E set(int x, E data) {
        if(size() == 0){
            addFirst(data);
            first.setNext(first.getNext().getNext());
            return null;
        }
        else if(x == 0){
            E ret = first.getData();
            first.setData(data);
            return ret;
        }
        DLLNode<E> temp = first;
        for(int i = 0; i < x; i++){
            temp = temp.getNext();
        }
        E ret = temp.getData();
        temp.setData(data);
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    
}
