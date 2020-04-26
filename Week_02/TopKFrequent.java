package structure.leetCode.weekWork.twoWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topKFrequent347 {

    /**
     * 347 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。。
     * @param nums
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
        List<Integer> res = new ArrayList();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        topKFrequent347 solution = new topKFrequent347();
        int[] nums = {1,1,1,2,2,3};
        solution.topKFrequent(nums,2);
    }


}
