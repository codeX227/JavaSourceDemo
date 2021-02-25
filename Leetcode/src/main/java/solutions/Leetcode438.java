package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 查找字符串中所有字母异位词 滑动窗口
 * @Author Goodenough
 * @Date 2021/2/25 16:21
 */
public class Leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left =0, right = 0;
        int valid = 0;
        List<Integer> list = new ArrayList<>();
        for(char c : p.toCharArray())
            need.put(c, need.getOrDefault(c, 0)+1);
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (right - left >= p.length()) {
                if (valid == need.size())
                    list.add(left);
                char ch = s.charAt(left);
                left++;
                if (need.containsKey(ch)) {
                    if (need.get(ch).equals(window.get(ch)))
                        valid--;
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        return list;
    }
}
