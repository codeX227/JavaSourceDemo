package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 最长无重复字串 滑动窗口
 * @Author Goodenough
 * @Date 2021/2/25 16:47
 */
public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while(window.get(c) > 1){
                char ch = s.charAt(left);
                left++;
                window.put(ch, window.get(ch) - 1);
            }
            result = Math.max(result, right-left);
        }
        return result;
    }
}
