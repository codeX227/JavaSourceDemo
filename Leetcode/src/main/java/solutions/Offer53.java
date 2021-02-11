package solutions;

/**
 * @Description 0~n-1中缺失的数字
 * @Author Goodenough
 * @Date 2021/2/11 19:00
 */
public class Offer53 {

    public int missingNumber(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(nums[m] == m)
                i = m+1;
            else
                j = m-1;
        }
        return i;
    }
}