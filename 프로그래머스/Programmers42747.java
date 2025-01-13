import java.util.*;
class Solution {
    //배열을 뒤집는 정적 메소드
    public static void reverseArray(int[] arr){
        int length = arr.length;
        int temp=0;
        for(int i=0;i<length/2;i++){
            temp = arr[length -1 -i];
            arr[length -1 -i] = arr[i];
            arr[i] = temp;
        }
    }
    //주어진 인용횟수의 논문 갯수를 세는 정적메소드
    public static int countOfH(int n,int[] arr){
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=n) count++;
        }
        return count;
    }
    
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        reverseArray(citations);
        int[] count_arr = new int[citations.length];
        for(int i=0;i<count_arr.length;i++){
            count_arr[i] = i+1;
        }
        
        for(int i=0;i<citations.length;i++){
            if(count_arr[i]> countOfH(count_arr[i],citations)){
                if((i-1)>0){
                    answer = count_arr[i-1];
                }else{
                    answer = count_arr[i]-1;
                }
                break;
            }
        }
        if(answer ==0){
            ArrayList<Integer> min_arr = new ArrayList<>();
            for(int i=0;i<citations.length;i++){
                min_arr.add(countOfH(1+i,citations));
            }
            Collections.sort(min_arr);
            answer = min_arr.get(0);   
        }
        
        return answer;
    }
}
