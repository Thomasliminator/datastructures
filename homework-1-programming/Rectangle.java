//Thomas Lim - tl2977
public class Rectangle implements RectangleInterface, Comparable<Rectangle>{
    private int length;
    private int width;
    private int perimeter;
    
    public Rectangle(int l, int w){
        length = l;
        width = w;
        perimeter = (2*w) + (2*l);
    }
    
    public double getLength(){
        return length;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getPerimeter(){
        return perimeter;
    }
    
    public int compareTo(Rectangle x){
        return (int)(perimeter - x.perimeter);
    }
}