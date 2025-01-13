import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] arr : commands){
            int i = arr[0]-1;
            int j = arr[1]-1;
            int k = arr[2]-1;
            
            int[] sortingArr = new int[j-i+1];
            int sortingArrIndex = 0;
            for(int start=i;start<=j;start++){
                sortingArr[sortingArrIndex++] = array[start];
            }
            
            Arrays.sort(sortingArr);
            System.out.println(" ");
            answer[index++] = sortingArr[k];
        }
        return answer;
    }
}
