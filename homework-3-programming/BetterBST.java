public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T>{
    
    public int height(){
        return height(root);
    }
    
    private int height(BinaryNode<T> n){
        if(n==null){
            return 0;
        }
        int lHeight = height(n.left);
        int rHeight = height(n.right);
        
        if(lHeight > rHeight){
            return lHeight + 1;
        }
        else{
            return rHeight + 1;
        }
    }
    
    public T imbalance(){
        return imbalance(root);
    }
    
    private T imbalance(BinaryNode<T> n){
        if(n==null){
            return null;
        }
        int lHeight = height(n.left);
        int rHeight = height(n.right);
        int delta = Math.abs(lHeight - rHeight);
        
        if(delta > 1){
            return n.data;
        }
        
        T temp = imbalance(n.left);
        
        if(temp==null){
            temp = imbalance(n.right);
            return temp;
        }
        else{
            return temp;
        }
    }
    
    public T smallestGreaterThan(T t){
        return smallestGreaterThan(t, root);
    }
    
    private T smallestGreaterThan(T t, BinaryNode<T> n){
        if(n==null){
            return null;
        }
        
        if(n.data.compareTo(t) < 0 || n.data.compareTo(t) == 0){
            return smallestGreaterThan(t, n.right);
        }
        else if(n.left == null){
            return n.data;
        }
        return smallestGreaterThan(t, n.left);
    }
    
    public BinarySearchTree<T> mirror(){
        BetterBST<T> a = new BetterBST<T>();
        mirror(a.root);
        return a;
    }
    
    private void mirror(BinaryNode<T> n){
        if(n==null){
            return;
        }
        if(n!=null){
            BinaryNode<T> temp = n.left;
            n.left=n.right;
            n.right=temp;
        }
        mirror(n.left);
        mirror(n.right);
    }
    
    public void prettyPrint(){
        prettyPrint(root, "");
    }
    
    private void prettyPrint(BinaryNode<T> n, String x){
        if(n==null){
            return;
        }
        if(n.right != null){
            prettyPrint(n.right,"  " + x);
        }
        System.out.println(x + n.data);
        if(n.left != null){
            prettyPrint(n.left, x + "  ");
        }
    }
}
