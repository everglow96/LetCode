package com.company;

import java.util.*;

/**
 * @author cxm
 * @description
 * @date 2020/06/22 17:21
 */
public class Code1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     **/
    public static int[] nums = new int[]{2, 7, 2, 3, 6};
    public static Integer target = 9;

    public static void main(String[] args) {
        System.out.println(method2());
    }

    /**
     * 暴力枚举
     * 时间：n2
     * 空间 1
     */
    public static List<Integer> method1() {
        int[] inNums = nums;
        List<Integer> index = new ArrayList<>();
        Arrays.stream(nums).forEach(e -> {
            Arrays.stream(inNums).forEach(e1 -> {
                int sum = e + e1;
                if (sum == target) {
                    index.add(e);
                    index.add(e1);
                }
            });
        });
        return index;
    }


    /**
     * 空间换时间， 将两数之和转为两数之差
     * 时间：n
     * 空间 n
     * @return
     */
    public static Map<Integer, Integer> method2() {
        // {2, 7, 2, 6};
        List<Integer> index = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(e -> {
            int diff = target - e;
            if (index.contains(diff)) {
                map.put(e, diff);
            }
            index.add(e);
        });
        return map;
    }


}
