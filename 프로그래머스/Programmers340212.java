import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = Arrays.stream(diffs).min().getAsInt();
        int right = Arrays.stream(diffs).max().getAsInt();
        int min = right;
        
        while(left <= right){
            int level = (left + right) / 2;
            long time = 0;
            time += times[0];
            for(int i=1;i<diffs.length;i++){
                if(level >= diffs[i]) time += times[i];
                else{
                    int worngCount = diffs[i] - level;
                    int ssibal = (times[i] + times[i-1]) * worngCount + times[i];
                    time += ssibal;
                }
            }
            if(time > limit){
                left = level +1;
            }else{
                right = level -1;
                min = Math.min(min,level);
            }
        }
        return min;
    }
}
