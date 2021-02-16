package solutions;

/**
 * @Description 左旋转字符串
 * @Author Goodenough
 * @Date 2021/2/16 19:52
 */
public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
}
