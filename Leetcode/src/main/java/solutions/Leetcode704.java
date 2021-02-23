package solutions;

/**
 * @Description 二分查找
 * @Author Goodenough
 * @Date 2021/2/23 14:06
 */
public class Leetcode704 {

    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
