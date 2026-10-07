class Solution {
    public int[] twoSum(int[] nums, int target) {
        var indiciesMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            indiciesMap.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int key = nums[j];
            int valueIndicy = indiciesMap.get(key);
            int diff = target - key;
            if ((indiciesMap.get(diff) != null) && (indiciesMap.get(diff) != j)) {
                return new int[]{j,indiciesMap.get(diff)};
            }
        }
        return new int[0];
    }
}
