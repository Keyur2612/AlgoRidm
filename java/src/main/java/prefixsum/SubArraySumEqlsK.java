package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqlsK {
    public static void main(String[] args) {
        int[] nums = {2,3,-5,5,-5,1,4};
        int result = subArraySum(nums, 5);
        System.out.println( result );
    }
    static int subArraySum(int[] nums, int k){
        int result = 0, prefixSum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0,1);

        for (int num : nums) {
            prefixSum += num;
            if(sumCountMap.containsKey(prefixSum - k)) {
                result += sumCountMap.get(prefixSum - k);
            }

            sumCountMap.put(prefixSum,
                    sumCountMap.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
