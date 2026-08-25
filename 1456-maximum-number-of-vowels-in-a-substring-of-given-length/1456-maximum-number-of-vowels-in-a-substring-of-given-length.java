class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add the new character
            if (isVowel(s.charAt(right))) {
                count++;
            }

            // Remove the character that is outside the window
            if (right >= k) {
                if (isVowel(s.charAt(right - k))) {
                    count--;
                }
            }

            // Window has exactly k characters
            if (right >= k - 1) {
                max = Math.max(max, count);
            }

            // Maximum possible answer
            if (max == k) {
                return k;
            }
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u';
    }
}