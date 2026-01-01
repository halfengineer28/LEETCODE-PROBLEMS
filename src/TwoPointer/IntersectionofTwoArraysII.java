package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII {
    public static void main(String[] args) {

    }
    public  int [] intersect(int [] nums1, int [] nums2){
        // Sorting the arrays

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // two pointer;
        int left = 0;
        int right = 0;

        List<Integer> res = new ArrayList<>();

        while (left < nums1.length && right < nums2.length){
            // element present on both array
            if (nums1[left] == nums2[right]){
                res.add(nums1[left]);
                left++;
                right++;

            }else if (nums1[left] < nums2[right]){

                left++;
            }else {
                right++;
            }


        }
        int [] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
