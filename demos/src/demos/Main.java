package demos;

public class Main {

    public int findMax(int[] nums){
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}