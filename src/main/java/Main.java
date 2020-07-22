import finder.Anagram;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/resources/words.txt";
        try {
            Anagram anagram = new Anagram(filename);
            anagram.getAnagramMap();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Anagram.isAnagram("kajak", "axjkk"));
    }
}
