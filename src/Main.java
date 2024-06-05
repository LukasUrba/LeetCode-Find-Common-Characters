import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }

    public static List<String> commonChars(String[] words) {
        HashMap<String, Integer> allCharacters = new HashMap<String, Integer>();
        List<String> characters = new ArrayList<>();

        for(String word : words) {
            for(Character character : word.toCharArray()) {
                allCharacters.merge(character.toString(), 1, Integer::sum);
            }
        }

        for(String s: allCharacters.keySet()) {
            int duplicates = allCharacters.get(s)/words.length;

            if (duplicates==1) {
                System.out.println("test");
                characters.add(s);
            } else if(duplicates>1) {
                for (int i = 0; i < duplicates ; i++) {
                    characters.add(s);
                }
            }
        }
        System.out.println(allCharacters);

        return characters;
    }
}