package algorithmn.tests;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution3 {
    public String replaceSpace(StringBuffer str) {

        //创建一个stringbuffer，遍历str字符并存入stringbuffer
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < length; i++){
            char c = str.charAt(i);
            if(c == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}
