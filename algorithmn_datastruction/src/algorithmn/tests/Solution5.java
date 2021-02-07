package algorithmn.tests;

public class Solution5 {
    public int Fibonacci(int n) {
        int preprenum = 0;
        int prenum = 1;
        int result = 0;
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else{
            for (int i = 2; i <= n; i++){
                result = preprenum + prenum;
                preprenum = prenum;
                prenum = result;
            }
        }
        return result;
    }
}
