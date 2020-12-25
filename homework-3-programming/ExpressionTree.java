import java.util.LinkedList;
public class ExpressionTree implements ExpressionTreeInterface{
    private MyStack<ExpressionNode> expressionStack = new MyStack<ExpressionNode>();
    private ExpressionNode root;
    
    public ExpressionTree(String expression){
        String[] tokens = expression.split(" ");
        int operators = 0;
        int operands = 0;
        
        for(int i=0; i<tokens.length; i++){
            if(isOperator(tokens[i])){
                ExpressionNode leftChild = expressionStack.pop();
                ExpressionNode rightChild = expressionStack.pop();
                expressionStack.push(new ExpressionNode(tokens[i], leftChild, rightChild));
                root = expressionStack.peek();
                operators++;
            }
            else{
                expressionStack.push(new ExpressionNode(tokens[i], null, null)); 
                operands++; 
            }
        }
        
        if((operands-operators) != 1){
            System.out.println( "Input a valid postfix expression!");
            System.exit(0);
        }
    }
    
    private boolean isOperator(String t){
        if(t.equals("+")||t.equals("-")||t.equals("/")||t.equals("*")){
            return true;
        }
        else return false; 
    }
    
    static class ExpressionNode{
        //class to implement nodes
        String element;
        ExpressionNode leftChild;
        ExpressionNode rightChild;
        
        public ExpressionNode(String element, ExpressionNode leftChild, ExpressionNode rightChild){
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild; 
        }
    }
    
    class MyStack<ExpressionNode>{
        LinkedList<ExpressionNode> stack;
        
        public MyStack(){
            stack = new LinkedList<ExpressionNode>();
        }
        
        public ExpressionNode pop(){
            if(stack.size() == 0) return null;
            else return stack.remove();
        }
        
        public void push(ExpressionNode e){
            stack.addFirst(e);
        }
        
        public ExpressionNode peek(){
            return stack.getFirst();
        }
        
        public int size(){
            return stack.size();
        }
        
        public boolean isEmpty(){
            return stack.isEmpty();
        }
    }
    
    public int eval(){
        return eval(root);
    }
    
    private int eval(ExpressionNode r){
        if(isOperator(r.element)){
            if(r.element.equals("+")){
                return eval(r.leftChild) + eval(r.rightChild);
            }
            if(r.element.equals("-")){
                return eval(r.leftChild) - eval(r.rightChild);
            }
            if(r.element.equals("*")){
                return eval(r.leftChild) * eval(r.rightChild);
            }
            if(r.element.equals("/")){
                return eval(r.leftChild) / eval(r.rightChild);
            }
        }
        else{
            return Integer.parseInt(r.element);
        }
        return Integer.parseInt(r.element);
    }
    
    public String postfix(){
        return postfix(root);
    }
    
    private String postfix(ExpressionNode r){
        if(isOperator(r.element)){
            return postfix(r.leftChild) + " " + postfix(r.rightChild) + " " + r.element + " ";
        }
        else return r.element;
    }
    
    public String prefix(){
        return prefix(root);
    }
    
    private String prefix(ExpressionNode r){
        if(isOperator(r.element)){
            return r.element + " " + prefix(r.leftChild) + " " + prefix(r.rightChild) + " ";
        }
        else return r.element;
    }
    
    public String infix(){
        return infix(root);
    }
    
    private String infix(ExpressionNode r){
        if(isOperator(r.element)){
            return infix(r.leftChild) + " " + r.element + " " + infix(r.rightChild) + " ";
        }
        else return r.element;
    }
    
}