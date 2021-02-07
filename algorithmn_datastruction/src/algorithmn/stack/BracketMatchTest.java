package algorithmn.stack;

import datastructure.stack.Stack;

/**
 * @括号匹配问题
 * (长安)(上海) 正确匹配
 * ((上海)长安 错误匹配
 */
public class BracketMatchTest {
    public static void main(String[] args) {
        String str = "上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(str+"中括号是否匹配："+match);
    }

    /**
     * 判断 str 字符串中括号是否匹配
     * @param str
     * @return
     */
    public static boolean isMatch(String str){
        //用栈保存左括号
        Stack<String> stack = new Stack<>();
        //遍历字符串，取出字符，如果是左括号就压入栈
        for (int i=0; i<str.length(); i++){
            String c = str.charAt(i)+"";//转化为String类型
            if (c.equals("(")){
                stack.push(c);
            }
            //如果是右括号，就弹出一个左括号，弹出为null则说明不匹，返回false
            else if (c.equals(")")) {
                String pop = stack.pop();
                if (pop == null){
                    return false;
                }
            }
        }
        //遍历完，如果栈元素为0则正确匹配，否则错误匹配
        if (stack.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
