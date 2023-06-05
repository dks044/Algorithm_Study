import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        if(n%2 ==0) ans =0;
        long point =1;
        while(n > 1){
            n /=2;
            if(n % 2!=0){
                n*=2;
                n++;
                n/=2;
                ans++;
                continue;
            }
        }

        return ans;
    }
}
