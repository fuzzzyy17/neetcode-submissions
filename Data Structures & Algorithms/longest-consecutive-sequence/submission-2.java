class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> consecutiveNums = new ArrayList<Integer>();
        Collections.sort(numList);
        int current = 1;
        int highest = 1;

        if (nums.length == 0) {
            return 0;
        }
        
        for (int i = 1; i < (numList.size()); i++) {
            if ( numList.get(i-1).equals( (numList.get(i)) )) {
                continue;
            }
            if ( numList.get(i-1) == (numList.get(i)-1) ) {
                current++;
            } else {
                if ( current > highest ) {
                    highest = current;
                }
                current = 1;
            }
        }
        if ( current > highest ) {
                    highest = current;
        }
        return highest;
    }
}
