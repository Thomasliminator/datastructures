import java.util.*;
import java.io.*;

public class SpellChecker implements SpellCheckerInterface{
    HashSet<String> dictionary = new HashSet<String>();
    public SpellChecker(String fileName){
        File inputFile = new File(fileName);
        try{
            Scanner s = new Scanner(inputFile);
            while(s.hasNextLine()){
                String word = s.nextLine().trim(); //trim?
                dictionary.add(word.toLowerCase());
            }
        }
        catch(FileNotFoundException e){
            System.err.print("File not found.");
        }
    }
    
    public List<String> getIncorrectWords(String filename){
        File file = new File(filename);
        List<String> incorrectWords = new ArrayList<String>();
        try{
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                String word = s.nextLine().trim().toLowerCase();
                if(!dictionary.contains(word)){
                    incorrectWords.add(word);
                }
            }
        }
        catch(FileNotFoundException e){
            System.err.print("File not found.");
        }
        return incorrectWords;
    }
    
    public Set<String> getSuggestions(String word){
        Set<String> suggestions = new HashSet<String>();
        String possible = "";
        for(char l = 'a'; l <= 'z'; l++){
            for(int i=0; i<word.length(); i++){
                possible = word.substring(0,i) + l + word.substring(i, word.length());
                if(dictionary.contains(possible)){
                    suggestions.add(possible);
                    possible = "";
                }
                else{
                    possible = "";
                    continue;
                }
            }
        }
        
        for(int i=0; i<word.length(); i++){
            possible = word.substring(0,i) + word.substring(i+1, word.length());
            if(dictionary.contains(possible)){
                suggestions.add(possible);
                possible = "";
            }
            else{
                possible = "";
                continue;
            }
        }
        
        for(int i=0; i<word.length()-1; i++){
            if(i==word.length()-2){
                possible = word.substring(0,i) + word.charAt(i+1) + word.charAt(i);
            }
            else{
                possible = word.substring(0,i) + word.charAt(i+1) + word.charAt(i) + word.substring(i+2, word.length());
            }
            if(dictionary.contains(possible)){
                suggestions.add(possible);
                possible = "";
            }
            else{
                possible = "";
                continue;
            }
        }
        return suggestions;
    }
}











