package structure.leetCode.weekWork.twoWeek;

import java.util.*;

public class majorityElement {

    /**
     * 455. jump play game
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * @return
     */
    public int jump(int[] nums) {
        // 反向查找出发位置
//        输入: [2,3,1,1,4]
//        输出: 2
        int position = nums.length - 1;
        int count = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int jump1(int[] nums) {
        // 正向查找可到达的最大位置
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                count++;
            }
        }
        return count;
    }
}
