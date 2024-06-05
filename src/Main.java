import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println(commonChars(new String[]{"bella","label","roller"}));
        System.out.println(commonChars(new String[]{"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"}));

    }

    public static List<String> commonChars(String[] words) {
        HashMap<String, Integer> allCharacters = new HashMap<String, Integer>();
        List<String> characters = new ArrayList<>();
        HashMap<String, Integer> copyOfMap = new HashMap<String, Integer>();



        for(String word : words) {
            System.out.println();
            if (!allCharacters.isEmpty()) {
                 copyOfMap.putAll(allCharacters);
            }
            System.out.println(copyOfMap);
            for (Character character : word.toCharArray()) {
                allCharacters.merge(character.toString(), 1, Integer::sum);
            }
            System.out.println(allCharacters);
            if(!copyOfMap.isEmpty()) {
                for(String s : copyOfMap.keySet()) {
//                    System.out.println();
                    if(copyOfMap.get(s)==allCharacters.get(s)){
                        allCharacters.remove(s);
                    }
                }
            }

        }

        for(String s: allCharacters.keySet()) {
            int duplicates = allCharacters.get(s)/words.length;

            if (duplicates==1) {
                characters.add(s);
            } else if(duplicates>1) {
                for (int i = 0; i < duplicates ; i++) {
                    characters.add(s);
                }
            }
        }

        return characters;
    }
}