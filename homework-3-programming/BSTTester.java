public class BSTTester{
    public static void main(String[] args){
        BetterBST<Integer> bst = new BetterBST<Integer>();
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(10);
        bst.insert(7);
        bst.insert(9);
        bst.insert(0);
        
        System.out.println("smallestGreaterThan(2): " + bst.smallestGreaterThan(2));
        System.out.println("smallestGreaterThan(7): " + bst.smallestGreaterThan(7));
        System.out.println("smallestGreaterThan(13): " + bst.smallestGreaterThan(13));
        System.out.println("Height: " + bst.height());
        System.out.println("Imbalance: " + bst.imbalance());
        System.out.println("Pretty Print: ");
        bst.prettyPrint();
        //BetterBST<Integer> mirror = bst.mirror();
        System.out.println("Mirror: ");
        //bst.prettyPrint();
        bst.mirror().prettyPrint();
    }
}