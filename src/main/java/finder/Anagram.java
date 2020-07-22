package finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {

    private List<String> sortedWordsList;
    private Map<String, List<String>> anagramMap;

    public Anagram(String filename) throws IOException {
        sortedWordsList = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
    }

    public void getAnagramMap(){
        anagramMap = sortedWordsList.stream().collect(Collectors.groupingBy(this::sortLettersInAWord));

        for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            for(String v : entry.getValue()){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        char[] s1Letters = s1.toCharArray();
        char[] s2Letters = s2.toCharArray();

        Arrays.sort(s1Letters);
        Arrays.sort(s2Letters);

        if(new String(s1Letters).equals(new String(s2Letters)))
            return true;
        return false;
    }

    public String sortLettersInAWord(String word){
        char[] lettersArray = word.toCharArray();
        Arrays.sort(lettersArray);
        return new String(lettersArray);
    }
}