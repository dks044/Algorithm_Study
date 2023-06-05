import java.util.*;
class Solution {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);
        for(int i=0;i<people.length;i++){
            for(int j=0;j<tshirts.length;j++){
                if(tshirts[j]>=people[i] && tshirts[j]!=0 && people[i] !=0){
                    people[i] =0;
                    tshirts[j] =0;
                    answer++;
                }
            }
        }
        
        
        
        return answer;
    }
}
