public class NSPQ<E> extends MyPriorityQueue<NSPQ_Node<E>> {

    public NSPQ(){

    }

    @Override
    public NSPQ_Node<E> remove(){
        if(priorityQueue.size() != 0){
            for(int i = 1; i < priorityQueue.size(); i++){
                priorityQueue.get(i).setPriority(priorityQueue.get(i).getPriority() - 1);
            }
        }
        return super.poll();
    }

    @Override
    public NSPQ_Node<E> poll(){
        return remove();
    }
}
