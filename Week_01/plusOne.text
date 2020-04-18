 /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * @param nums
     */
    public int[]  addOne(int[] nums) {
        //题解 [1,2,3] + 1 = [1,2,4]
        //[1,2,9] + 1 = [1,3,0]
        //[9,9,9] + 1 = [1,0,0,0]

        for(int i = nums.length - 1; i >= 0; i--){
            nums[i]++;
            nums[i] %= 10;
            if (nums[i] != 0)  return nums;
        }

        //当需要进位到最前面时,也即[9, 9, 9]时
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }


    public static void main(String[] args) {
//        int[] str = {1,2,0,4,3};
        int[] str = {9,9,9,9};
        Solution66_AddOne solution = new Solution66_AddOne();
        solution.addOne(str);
        System.out.println(Arrays.toString(str));
    }
