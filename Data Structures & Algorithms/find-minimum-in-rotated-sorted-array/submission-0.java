class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m = nums.length / 2;

        while (true) {
            if (l == r){
                break;
            } else if (nums[m] > nums[r]) {
                // discard left
                l = m+1;
                m = l+((r-l)/2);
            } else {
                //discard right
                r = m;
                m = l+((r-l)/2);
            }
        }
        return nums[l];
    }
}
