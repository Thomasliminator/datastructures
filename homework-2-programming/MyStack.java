//Thomas Lim tl2977
import java.io.FileNotFoundException;
@SuppressWarnings("unchecked")
public class MyStack<T> implements MyStackInterface<T>{
    public static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int stackSize;
    
    public MyStack(){
        stackSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    
    public void ensureCapacity(int newCapacity){
        T[] oldStack = stack;
        stack = (T[]) new Object[newCapacity];
        for(int i=0; i<stackSize; i++){
            stack[i] = oldStack[i]; 
        }
    }
    
    public void push(T x){
        if(stack.length == stackSize){
            ensureCapacity(stackSize * 2 + 1);
        }
        stack[stackSize] = x;
        stackSize++; 
    }
    
	public T pop(){
        if(stackSize == 0){
            return null;
        }
        else{
            T temporary = stack[stackSize - 1];
            stackSize--;
            return temporary;
        }
    }
    
	public T peek(){
        return stack[stackSize - 1]; 
    }
    
	public boolean isEmpty(){
        if(stackSize==0){
            return true;
        }
        else{
            return false;
        }
    }
    
	public int size(){
        return stackSize;
    }
    
} 