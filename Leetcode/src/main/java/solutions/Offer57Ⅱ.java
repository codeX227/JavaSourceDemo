package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 和为 s 的连续整数序列
 * @Author Goodenough
 * @Date 2021/2/15 20:10
 */
public class Offer57Ⅱ {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        for(int l=1,r=1,sum=0; r<target; r++){
            sum+=r;
            while(sum > target){
                sum -= l++;
            }
            if(sum == target){
                int[] temp = new int[r-l+1];
                for(int i=0; i<temp.length; i++){
                    temp[i] = l+i;
                }
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
