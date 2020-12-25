//Thomas Lim tl2977
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolBalance implements SymbolBalanceInterface{
    public static void main(String[] args){
        ///*
        for(int i=1; i<7; i++){
            String filename = "TestFiles/Test" + i + ".java";
            SymbolBalance sb = new SymbolBalance();
            sb.setFile(filename);
            System.out.println("file " + i + " " + sb.checkFile());
        } //*/
        
        /*
        String filename = "TestFiles/Test4.java";
        SymbolBalance sb = new SymbolBalance();
        sb.setFile(filename);
        System.out.println("file " + 4 + " " + sb.checkFile());
        */
    }
    
    private File inputFile;
    private Scanner s;
    private MyStack<Character> theStack;
    private boolean quotations = false;
    private boolean commentBlock = false;
    private int lineNumber;
    
    public void setFile(String fileName){
        try {
            inputFile = new File(fileName);
            s = new Scanner(inputFile);
        } 
        catch (FileNotFoundException e) {
            System.err.println("File Path " + fileName + "DNE.");
        }
    }
    
    public BalanceError checkFile(){
        theStack = new MyStack<>();
        lineNumber = 1;
        while(s.hasNextLine()){
            String currentLine = s.nextLine();
            char[] lineCharacters = currentLine.toCharArray();
            for(int i=0; i<lineCharacters.length; i++){
                //System.out.println("quote line " + lineNumber + "." + i + ": "+ quotations);
                //System.out.println("comment line " + lineNumber + "." + i + ": "+ commentBlock);
                char currentSymbol = lineCharacters[i];
                if(quotations == true || commentBlock == true){
                    if((i+1)<lineCharacters.length){
                        if(lineCharacters[i] == ('*') && lineCharacters[i+1] == ('/') && commentBlock == true){
                            commentBlock = false;
                        }
                    }
                    
                    if(lineCharacters[i] == ('"')){
                        if(quotations == true){
                            quotations = false;
                            theStack.pop();
                            continue;
                        }
                    }
                    else{
                        continue;
                    }
                }
                
                if(commentBlock == false){
                    if(lineCharacters[i] == ('"') && quotations == false){
                        quotations = true;
                        theStack.push(lineCharacters[i]); 
                        continue;
                    }
                }
                
                try{
                    if((i+1)<lineCharacters.length){
                        if(lineCharacters[i] == ('/') && lineCharacters[i+1] == ('*')){
                            commentBlock = true;
                            continue;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e2){
                    throw e2;
                }
                
                if(lineCharacters[i] == ('{') || lineCharacters[i] == ('[') || lineCharacters[i] == ('(')){
                    theStack.push(lineCharacters[i]);
                    continue;
                }
                
                if(lineCharacters[i] == ('}') || lineCharacters[i] == (']') || lineCharacters[i] == (')')){
                    if(theStack.isEmpty()){
                        BalanceError EmptyStackError = new EmptyStackError(lineNumber);
                        return EmptyStackError;
                    }
                    
                    if((theStack.peek()).equals('{') && lineCharacters[i] == ('}') ||
                       (theStack.peek()).equals('[') && lineCharacters[i] == (']') ||
                       (theStack.peek()).equals('(') && lineCharacters[i] == (')')){
                        char symbolPopped = theStack.pop();
                        continue;
                    } 
                    
                    else{
                        char symbolPopped = theStack.pop();
                        BalanceError MismatchError = new MismatchError(lineNumber, currentSymbol, symbolPopped);
                        return MismatchError;
                    }
                }
            }
            
            lineNumber++;
            
        }
        
        int sizeOfStack = theStack.size();
        
        if(sizeOfStack > 0){
            char topElement = theStack.peek();
            BalanceError NonEmptyStackError = new NonEmptyStackError(topElement, sizeOfStack);
            return NonEmptyStackError;
        }
        else{
            return null;
        }
        
    }
}