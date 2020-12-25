//Thomas Lim - tl2977
public class BigO implements BigOInterface{
    public void cubic(int n){
        int x = 0;
        for(int i=0; i<n*n*n; i++){
             x++;
        }
    }
    
    public void exp(int n){
        int x = 0;
        for(int i=0; i<Math.pow(2, n); i++){
            x++;
        }
    }
    
    public void constant(int n){
        int x = 0;
    }
}