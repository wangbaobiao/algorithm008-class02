package structure.leetCode.weekWork.twoWeek;

import java.util.*;

public class twoSum1 {

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * @param nums, target
     */
    public int[] twoSum(int[] nums, int target) {
//        给定 nums = [2, 7, 11, 15], target = 9
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]
        int[] numExist = new int[2];
        for (int i =0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == target - nums[j]) {
                    numExist[0] = j;
                    numExist[1] = i;

                }
            }
        }
        return numExist;
    }

    public int[] twoSum1(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        twoSum1 sum = new twoSum1();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(sum.twoSum(nums,9)));

    }


}
