package SlidingWindow;

import java.util.HashMap;

public class LongestSubarrayWithatMostKFrequency {
    public static void main(String[] args) {

    }
    public static int maxSubarrayLength(int[] nums, int k){
        // Brute Force      TC- 0(n^2) SC-
        int maxlength = 0;

        for (int i = 0; i < nums.length; i++){
            // HashMap for storing each and every elment and frequency;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < nums.length; j++){

                //check if Hashmap contains int at j-postion
                if (map.containsKey(nums[j])){

                    // if the value of nums[j] < k
                    if (map.get(nums[j]) < k){
                        map.put(nums[j], map.getOrDefault(nums[j], 0) +1);
                    }else{
                        break;
                    }
                }else {
                    // if map doesn't contains nums[j];
                    map.put(nums[j], map.getOrDefault(nums[j], 0) +1);

                }
                maxlength = Math.max(maxlength, j-i+1);

            }
        }
        return maxlength;
    }
    public static int maxSubarrayLength2(int[] nums, int k){
        //Optimial Approach  TC-0(N) SC-0(N);

        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlength = 0;

        while (right < nums.length ){

            // put in the map with its frequency
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            // if element is greater than k remove from left && move left pointer;
            while (map.get(nums[right]) > k){
                map.put(nums[left], map.get(nums[left])-1);
                left++;

            }
            // update maxlength is greater than previous
            maxlength = Math.max(maxlength, right-left+1);

            right++;


        }
    return maxlength;
    }

}
