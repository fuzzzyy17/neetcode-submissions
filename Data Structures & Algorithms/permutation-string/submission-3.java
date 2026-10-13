class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        // Map<Character, Integer> subsetMap = new HashMap<Character, Integer>();
        // Map<Character, Integer> setMap = new HashMap<Character, Integer>();
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        if (s1.length() > s2.length()) {return false;}

        for (int i = 0; i < s1Chars.length; i++) {
            // subsetMap.put(s1Chars[i], 1);
            // setMap.put(s2Chars[i], 1);
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            s1Freq[index1]+=1;
            s2Freq[index2]+=1;
        }

        if (Arrays.equals(s1Freq, s2Freq)) {return true;}

        for (int r = s1.length(); r < s2.length(); r++) {
            int lIndex = s2.charAt(l) - 'a';
            s2Freq[lIndex]-=1;
            int rIndex = s2.charAt(r) - 'a';
            s2Freq[rIndex]+=1;
            if (Arrays.equals(s1Freq, s2Freq)) {return true;}
            l++;
        }
        return false;
    }
}
