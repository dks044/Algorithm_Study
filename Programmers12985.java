import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        if(n ==2){
            return 1;
        }
        //b를 큰수로 전환
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }

        while(a != b){
            if(a % 2 !=0) a = (a+1)/2;
            else a /=2;
            if(b % 2 !=0) b = (b+1)/2;
            else b /=2;
            
            answer++;
        }
        
        
        
        return answer;
    }
}
