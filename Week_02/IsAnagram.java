package structure.leetCode.weekWork.twoWeek;

import java.util.*;

public class isAnagram242 {

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s,t
     */
    public boolean isAnagram(String s, String t) {
//        输入: s = "anagram", t = "nagaram"
//        输出: true
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        if (chars.length != chart.length) {
            return false;
        }
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }

    public static void main(String[] args) {
        isAnagram242 solution = new isAnagram242();
        solution.isAnagram("dsdsad","dssdas");
    }


}
