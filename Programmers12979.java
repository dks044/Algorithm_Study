import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;//현재위치
        
        int index =0;
        while(position <=n){
            if(index<stations.length &&stations[index]-w <= position){
                position = stations[index]+w+ 1;
                if(stations.length >0) index +=1;
            }else{
                answer +=1; //기지국설치
                position += (w*2)+1;  
            }
        }
        

        return answer;
    }
}
