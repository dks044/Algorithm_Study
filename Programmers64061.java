import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int index=0;
        Stack<Integer> bucket = new Stack<>();
        ArrayList<Integer> bucket_arr = new ArrayList<>();

        while(index < moves.length){
            int col = 0;
            for(int i=0;i<board.length;i++){
                col = moves[index];
                if(board[i][col-1]>0){
                    if(!bucket.isEmpty() && bucket.peek() == board[i][col-1] ){
                        bucket.pop();
                        answer+=2;
                        board[i][col-1] = 0;
                    }else{
                        bucket.push(board[i][col-1]);
                        board[i][col-1] = 0;
                    }
                    break;
                }
            }
            index++;
        }
        
        
        
        return answer;
    }
}
