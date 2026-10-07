class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> countT = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (countS.containsKey(s.charAt(i))) {
                int value = countS.get(s.charAt(i));
                countS.put(s.charAt(i), ++value);
            }
            else {
                countS.put(s.charAt(i), 1);
            }

            if (countT.containsKey(t.charAt(i))) {
                int value = countT.get(t.charAt(i));
                countT.put(t.charAt(i), ++value);
            }
            else {
                countT.put(t.charAt(i), 1);
            }
        }

        return countS.equals(countT);
    }
}
