class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> groupMap = new HashMap<>();

        for (String word : strs) {
            Map<Character, Integer> characterMap = new HashMap<>();
            
            for (char character : word.toCharArray()) {
                characterMap.put(character, characterMap.getOrDefault(character, 0) + 1);
            }
            
            if (!groupMap.containsKey(characterMap)) {
                groupMap.put(characterMap, new ArrayList<>());
            }
            
            groupMap.get(characterMap).add(word);
        }
        
        return new ArrayList<>(groupMap.values());
    }
}
