import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        //둘중 하나는 최댓값이 되야함!(가로, 세로중에)
        //명함은 직사각형이니까 어느쪽으로 눕힐지 생각해야함.\
        //어느쪽으로 눕힐지는 최대가로길이, 최대세로길이에 따라 정한다.
        //정했으면 최대가로 명함은 냅두고, 나머지 명함중 더 큰 길이를 가로로 눕힌다.(가로 방향이라면)
        int answer = 0;
        int width_max=0;
        int height_max=0;
        for(int i=0;i<sizes.length;i++){
            if(width_max< sizes[i][0]) width_max = sizes[i][0];
            if(height_max< sizes[i][1]) height_max = sizes[i][1];
        }
        //===========================================================
        int temp=0;
        int height_max2=0;
        int width_max2=0;
        if(width_max>height_max){
            for(int i=0;i<sizes.length;i++){
                if(sizes[i][1]>sizes[i][0]){
                   temp = sizes[i][0];
                   sizes[i][0] = sizes[i][1];
                   sizes[i][1] = temp;
                }else{
                    continue;
                }
            }
            for(int i=0;i<sizes.length;i++){
                if(height_max2< sizes[i][1]) height_max2 = sizes[i][1];
            }
            System.out.println(width_max+" * "+height_max2);
            answer = width_max*height_max2;
        }else{//세로방향
            for(int i=0;i<sizes.length;i++){
                if(sizes[i][0]>sizes[i][1]){
                   temp = sizes[i][1];
                   sizes[i][1] = sizes[i][0];
                   sizes[i][0] = temp;
                }else{
                    continue;
                }
            }
            for(int i=0;i<sizes.length;i++){
                if(width_max2< sizes[i][0]) width_max2 = sizes[i][0];
            }
            answer = height_max*width_max2;
        }
        
        
        return answer;
    }
}
