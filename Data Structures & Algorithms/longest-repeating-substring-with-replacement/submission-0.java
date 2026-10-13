class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int longest = 0;


        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));

            int windowLength = r - l + 1;

            int replacements = windowLength - maxFreq;
            
            if ((replacements <= k) && (windowLength > longest)) {
                longest = windowLength;
            } else if (replacements > k) {
                char lChar = s.charAt(l);
                freq.put(lChar, freq.get(lChar)-1);
                l++;
            }

        }
        return longest;
    }
}
