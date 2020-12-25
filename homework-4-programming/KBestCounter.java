import java.util.*;
public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>{
    private PriorityQueue<T> heap;
    private int n;
    
    public KBestCounter(int n){
        this.n = n;
        heap = new PriorityQueue<>(n);
    }
    
    public void count(T x){
        if(heap.size()<n){
            heap.add(x);
        }
        else{
            T head = heap.peek();
            if(head.compareTo(x) < 0){
                heap.poll();
                heap.add(x);
            }
        }
    }
    
    public List<T> kbest(){
        LinkedList<T> theBest = new LinkedList<T>();
        PriorityQueue<T> heapT = new PriorityQueue<T>();
        while(!heap.isEmpty()){
            T head = heap.remove();
            heapT.add(head);
            theBest.addLast(head);
        }
        heap = heapT;
        return theBest;
    }
}