class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> sorted = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        Collections.sort(sorted);       
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        for (Integer i : sorted) {
            List<Integer> noCurrentIndex = new ArrayList<Integer>(sorted);
            int left = 0;
            int right = (sorted.size()-2); // noCurrentIndex will be one less than sorted
            noCurrentIndex.remove(i);
            while (left < right) {
                int sum = (noCurrentIndex.get(left) + noCurrentIndex.get(right)) + i;
                //System.out.println(i + " " + noCurrentIndex.get(left) + " " + noCurrentIndex.get(right) + " " + sum);
                if (sum == 0) {
                    List<Integer> checkPermutation = new ArrayList<>();
                    checkPermutation.addAll(Arrays.asList(i, noCurrentIndex.get(left), noCurrentIndex.get(right)));
                    Collections.sort(checkPermutation);
                    if (!output.contains(checkPermutation)) {
                        output.add(Arrays.asList(i, noCurrentIndex.get(left), noCurrentIndex.get(right)));
                    }
                    left++;
                    continue;
                } else if ( sum > 0 ) {
                    right--;
                    continue;
                } else {
                    left++;
                    continue;
                }
            }
        }
        return output;
    }
}
