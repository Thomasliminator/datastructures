//Thomas Lim - tl2977
public class GenericMethods implements GenericMethodsInterface{
    
    private static <AnyType extends Comparable<AnyType>> int binary(AnyType[] a, AnyType x, int start, int end){
        while(start > end){
            int mid = (start + end)/2;
        
            if(a[mid].equals(x)){
                return mid;
            }
            else if(a[mid].compareTo(x) == -1){
                return binary(a, x, mid + 1, end);
            }
            else if(a[mid].compareTo(x) == 1){
                return binary(a, x, start, mid - 1);
            }
        }
        return -1; 
    }
    
    public <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
        int start = 0;
        int end = a.length - 1; 
        
        return binary(a, x, start, end);
    }
    
    public <AnyType extends Comparable<AnyType>> int linearSearch(AnyType[] a, AnyType x){
        for(int i=0; i<a.length; i++){
            if(a[i].equals(x)){
                return i;
            }
            else{
                continue;
            }
        }
        return -1;
    }
}