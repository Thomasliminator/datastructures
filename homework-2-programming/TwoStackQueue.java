//Thomas Lim tl2977
@SuppressWarnings("unchecked")
public class TwoStackQueue<T> implements TwoStackQueueInterface<T>{
    private MyStack<T> s1 = new MyStack<T>(); //input
    private MyStack<T> s2 = new MyStack<T>(); //output
    
    public void enqueue(T x){
        s1.push(x);
    }
    
    public T dequeue(){
        int initialSize1 = s1.size();
        for(int i=0; i<initialSize1; i++){
            s2.push(s1.pop());
        }
        
        T temp = s2.pop();
        
        int initialSize2 = s2.size();
        for(int j=0; j<initialSize2; j++){
            s1.push(s2.pop());
        }
        return temp;
        
    }
    
    public int size(){
        return s1.size();
    }
    
    public boolean isEmpty(){
        if(s1.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public static void main(String[] args){
        TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
    
    
    
    
}