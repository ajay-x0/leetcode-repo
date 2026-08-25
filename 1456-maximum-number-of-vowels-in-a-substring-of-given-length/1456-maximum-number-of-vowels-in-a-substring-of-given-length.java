public class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int l = 0, count = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            count += (vowels.contains(s.charAt(r)) ? 1 : 0);
            if (r - l + 1 > k) {
                count -= (vowels.contains(s.charAt(l)) ? 1 : 0);
                l++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}