import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1];
        for(int i=0;i<students.length;i++) students[i] = 1;
        
        for(int i : reserve){
            students[i] = 2;
        }
        
        for(int i : lost){
            students[i]--;
        }
        
        for(int i=1;i<students.length;i++){
            if(students[i]>=2){
                if(students[i-1]==0 && students[i]>1){
                    students[i-1]++;
                    students[i]--;
                }
                if(i+1 < students.length && students[i+1]==0 && students[i]>1){
                    students[i]--;
                    students[i+1]++;
                }
            }
        }
        
        for(int i=1;i<students.length;i++){
            if(students[i]>=1){
                answer +=1;
            }
            
        }
        
        return answer;
    }
}
