package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 最小覆盖字串 滑动窗口
 * @Author Goodenough
 * @Date 2021/2/25 15:17
 */
public class Leetcode76 {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = Integer.MAX_VALUE;
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).intValue() == window.get(c).intValue())
                    valid++;
            }
            while (valid == need.size()) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                char x = s.charAt(left);
                left++;
                if (need.containsKey(x)) {
                    if (need.get(x).intValue() == window.get(x).intValue())
                        valid--;
                    window.put(x, window.get(x) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
