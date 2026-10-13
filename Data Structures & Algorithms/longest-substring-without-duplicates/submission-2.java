class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<Character>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            Character current = s.charAt(right);
            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++;
            }    
            seen.add(current);
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
}
