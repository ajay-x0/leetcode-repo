import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            
            char c2 = word2.charAt(i);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }

        // Condition 1: Must contain the exact same unique characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // Condition 2: The frequency values must match when sorted
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
        // return true;
    }
}