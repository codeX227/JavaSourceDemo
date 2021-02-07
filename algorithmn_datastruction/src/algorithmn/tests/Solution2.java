package algorithmn.tests;

/**
 *在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution2 {
    public boolean Find(int target, int [][] array) {
        //对二维数组每一行二分查找
        for(int i = 0; i < array.length; i++){
            int left = 0;
            int right = array[i].length - 1;
            while(left <= right){
                int mid = (left+right)/2;
                if(target < array[i][mid]){
                    right = mid - 1;
                }else if(target > array[i][mid]){
                    left = mid + 1;
                }
                else
                    return true;
            }
        }
        return false;
    }

}
