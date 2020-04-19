
   /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param array
     * @return
     */
 public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        //[1,2,0,4,3]
        for (int i = 0,count = 0; i < nums.length; i ++ ) {
            if(nums[i] != 0){
                //执行替换操作
                if(count != i){
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }


    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i ++ ) {
            if (nums[i] != 0){
               nums[index] = nums[i];
               index ++;
            }
        }

        while(index < nums.length)
        {
            nums[index++] = 0;
        }

    }



