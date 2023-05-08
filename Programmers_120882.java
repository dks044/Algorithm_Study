import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> score_arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int[] row : score){
            int sum=0;
            for(int i : row){
                sum += i;
            }
            int avg = sum;
            score_arr.add(avg);
            temp.add(avg);
        }
        Collections.sort(score_arr,Collections.reverseOrder());
        
        
        ArrayList<Integer> temp2 = new ArrayList<>();
        
        for(int i=0;i<temp.size();i++){
            int rank = score_arr.indexOf(temp.get(i))+1;
            if(i>0 && temp.get(i).equals(temp.get(i-1))){
                rank = temp2.get(i-1);
            }
            temp2.add(rank);
        }
        
        
       for(int i=0;i<temp2.size();i++){
           answer[i] = temp2.get(i);
       }
        
        
        return answer;
    }
}
