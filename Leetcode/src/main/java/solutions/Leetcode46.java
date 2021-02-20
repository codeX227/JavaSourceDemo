package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 全排列
 * @Author Goodenough
 * @Date 2021/2/20 16:48
 */
public class Leetcode46 {
    /**
     * 回溯算法
     */
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> track){
        if(nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove((Integer) nums[i]);
        }
    }
}
