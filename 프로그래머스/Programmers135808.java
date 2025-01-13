import java.util.*;
class Solution {
    //공백으로 분리된 문자열을 최솟값 찾아주는 
    public static int minOfString(String s){
        String[] num = s.split(" ");
        int min = Integer.valueOf(num[0]);
        for(int i=1;i<num.length;i++){
            if(Integer.valueOf(num[i]) < min) min = Integer.valueOf(num[i]);
        }
        return min;
    }
    //배열 뒤집기
    public static void reverseArr(int[] arr){
        int length = arr.length;
        for(int i=0;i<length/2;i++){
            int temp = arr[length -1 -i];
            arr[length -1 -i] = arr[i];
            arr[i] = temp;
        }
    }
    
    
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        reverseArr(score);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<score.length-m+1;i+=m){
            for(int j=i;j<i+m;j++){
                sb.append(score[j]+" ");
            }
            answer += minOfString(sb.toString()) * m;
            sb.setLength(0);
        }

        
        
        
        

        return answer;
    }
}
