public class Problem3{
    public static void main(String args[]){
        BigO alpha = new BigO();
        for(int i=1; i<22; i+=4){
            System.out.println("-------------- n = " + i + " --------------");
            long startTime = System.nanoTime();
            alpha.cubic(i);
            long endTime = System.nanoTime();
            System.out.println("Runtime for Cubic: " + (endTime - startTime));

            startTime = System.nanoTime();
            alpha.exp(i);
            endTime = System.nanoTime();
            System.out.println("Runtime for Exponential: " + (endTime - startTime));

            startTime = System.nanoTime();
            alpha.constant(i);
            endTime = System.nanoTime();
            System.out.println("Runtime for Constant: " + (endTime - startTime));
            
            System.out.println(" ");
        }
    }
}