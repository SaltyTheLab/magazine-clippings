package org.example;
import java.util.HashMap;
import java.util.Map;

public class NoteConstructor {
    public static boolean canConstruct(String note, String[] magazine) {
        // Combine all magazine articles into one large string
        StringBuilder magazineText = new StringBuilder();
        for (String article : magazine) {
            magazineText.append(article);
        }
        
        // Count frequency of characters in the note
        Map<Character, Integer> noteCount = new HashMap<>();
        for (char c : note.toCharArray()) {
            noteCount.put(c, noteCount.getOrDefault(c, 0) + 1);
        }
        
        // Count frequency of characters in the magazine text
        Map<Character, Integer> magazineCount = new HashMap<>();
        for (char c : magazineText.toString().toCharArray()) {
            magazineCount.put(c, magazineCount.getOrDefault(c, 0) + 1);
        }
        
        // Check if magazine has enough letters to construct the note
        for (Map.Entry<Character, Integer> entry : noteCount.entrySet()) {
            char c = entry.getKey();
            int requiredCount = entry.getValue();
            if (magazineCount.getOrDefault(c, 0) < requiredCount) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String note1 = "abc";
        String[] magazines1 = {"abc"};
        
        String note2 = "give me the money";
        String[] magazines2 = {"give me", "the money"};
        
        System.out.println(canConstruct(note1, magazines1));  // Output: true
        System.out.println(canConstruct(note2, magazines2));  // Output: false
    }
}
