import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // count == (diff - level)
        // 걸리는 시간 (현재시간 + 이전시간) * count + 현재시간
        int left = Arrays.stream(diffs).min().getAsInt();
        int right = Arrays.stream(diffs).max().getAsInt();
        answer = right;
        
        while(left <= right){
            int mid = (left+right)/2; //level
            long timeSum = 0;
            timeSum += times[0];
            for(int diff=1; diff<diffs.length; diff++){
                if(mid >= diffs[diff]) timeSum += times[diff];
                if(mid < diffs[diff]){
                    int count = diffs[diff] - mid;
                    int time = (times[diff] + times[diff-1]) * count + times[diff];
                    timeSum += time;
                }
            }
            if(timeSum > limit){
                left = mid +1;
            }
            if(timeSum <= limit){
                right = mid -1;
                answer = Math.min(mid, answer);
            }
        }

        return answer;
    }
}
