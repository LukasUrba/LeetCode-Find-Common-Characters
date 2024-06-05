import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
        System.out.println(commonChars(new String[]{"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"}));

    }

    public static List<String> commonChars(String[] words) {
        HashMap<String, Integer> allCharacters = new HashMap<String, Integer>();
        List<String> characters = new ArrayList<>();
        HashMap<String, Integer> copyOfMap = new HashMap<String, Integer>();
        Set<String> notCharacters = new HashSet<>();

        for(String word : words) {
            for (Character character : word.toCharArray()) {
                    allCharacters.merge(character.toString(), 1, Integer::sum);
            }
            if(!copyOfMap.isEmpty()) {
                for(String s : copyOfMap.keySet()) {
                    if(copyOfMap.get(s).equals(allCharacters.get(s))){
                        allCharacters.remove(s);
                        notCharacters.add(s);
                    }
                }
            }
            copyOfMap.putAll(allCharacters);
        }

        for(String s: allCharacters.keySet()) {
            int duplicates = allCharacters.get(s)/words.length;
            if(notCharacters.contains(s)) {
                continue;
            }
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