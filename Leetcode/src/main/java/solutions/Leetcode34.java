package solutions;

/**
 * @Description 在排序数组中找元素的第一个和最后一个位置 二分查找
 * @Author Goodenough
 * @Date 2021/2/23 18:00
 */
public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};

        int left = findLeft(nums,target);
        int right = findRight(nums,target);

        return new int[]{left, right};
    }

    public int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                right = mid - 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        return (left < nums.length && nums[left] == target) ? left : -1;
    }

    public int findRight(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                left = mid + 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        return (right >=0 && nums[right] == target) ? right : -1;
    }
}
