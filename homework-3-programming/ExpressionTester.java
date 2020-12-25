import java.util.Scanner;
public class ExpressionTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        ExpressionTree x = new ExpressionTree(input);
        System.out.println("Input was " + input);
        System.out.println("Evaluates to " + x.eval());
        System.out.println("Postfix is " + x.postfix());
        System.out.println("Prefix is " + x.prefix());
        System.out.println("Infix is " + x.infix());
    }
}