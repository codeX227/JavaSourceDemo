package solutions;

/**
 * @Description 和为 s 的两个数字
 * @Author Goodenough
 * @Date 2021/2/13 19:38
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {

        int left=0, right=nums.length-1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target)
                return new int[]{nums[left],nums[right]};
            else if (sum > target)
                right--;
            else if (sum < target)
                left++;
        }
        return new int[]{};
    }
}
