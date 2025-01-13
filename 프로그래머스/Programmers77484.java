import java.util.*;

class Solution {
    static int zeroCount(int[] numbers){
        int count =0;
        for(int num : numbers) if(num == 0) count++;
        return count;
    }
    static int matchArr(int[] arr1, int[] arr2){
        int matchCount =0;
        for(int a : arr1){
            for(int b : arr2){
                if(a==b) matchCount++;
            }
        }
        return matchCount;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        //카운트 | 등수
        Map<Integer,Integer> rank = new HashMap<>();
        rank.put(6,1);
        rank.put(5,2);
        rank.put(4,3);
        rank.put(3,4);
        rank.put(2,5);
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int[] answer = new int[2];
        int topRank = zeroCount(lottos)+matchArr(lottos,win_nums);
        answer[0] = rank.getOrDefault(topRank,6);
        int bottomRank = matchArr(lottos,win_nums);
        answer[1] = rank.getOrDefault(matchArr(lottos,win_nums),6);

        return answer;
    }
}
