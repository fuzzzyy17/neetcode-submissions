class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> buckets = new HashMap<Integer,Integer>(); 
        for ( int num : nums ) {
            if (buckets.get(num) == null) {
                buckets.put(num, 1);
            } else {
                buckets.put(num, (buckets.get(num)+1));
            }
        }
        List<Integer>[] frequencyBuckets = new List[nums.length+1];
        for (int i : buckets.keySet()) {
            int frequency = buckets.get(i);

            if (frequencyBuckets[frequency] == null) {
                frequencyBuckets[frequency] = new ArrayList<>();
            }

            frequencyBuckets[frequency].add(i);
        }
int[] result = new int[k];
        int index = 0;

        for (int frequency = frequencyBuckets.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            if (frequencyBuckets[frequency] != null) {
                for (int num : frequencyBuckets[frequency]) {
                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
