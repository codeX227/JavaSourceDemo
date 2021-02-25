package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 字符串的排列 滑动窗口
 * @Author Goodenough
 * @Date 2021/2/25 16:05
 */
public class Leetcode567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left =0, right = 0;
        int valid = 0;
        for(char c : s1.toCharArray())
            need.put(c, need.getOrDefault(c, 0)+1);
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                char ch = s2.charAt(left);
                left++;
                if (need.containsKey(ch)) {
                    if (need.get(ch).equals(window.get(ch)))
                        valid--;
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        return false;
    }
}
