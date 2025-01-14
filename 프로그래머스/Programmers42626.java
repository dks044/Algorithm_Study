import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> ssibal = new PriorityQueue<>();
        for(int i : scoville) ssibal.add(i);
        
        while(!시발(ssibal, K)){
            if(ssibal.size() == 1 && ssibal.peek() < K) return -1;
            if(ssibal.size() == 1) break;
            int a = ssibal.poll();
            int b = ssibal.poll();
            int result = 계산한다(a,b);
            ssibal.add(result);
            answer++;
        }
        
        return answer;
    }
    static boolean 시발(PriorityQueue<Integer> ssibal, int k){
        for(int i : ssibal) if(i < k) return false;
        return true;
    }
    static int 계산한다(int a, int b){
        return a + (b * 2);
    }
}
