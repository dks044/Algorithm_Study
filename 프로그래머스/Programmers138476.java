import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(!map.containsKey(tangerine[i])){
                map.put(tangerine[i],1);
            }else{
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }
        }
        ArrayList<Integer> int_arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int_arr.add(value);
        } 
        Collections.sort(int_arr,Collections.reverseOrder());
        int temp =0;
        for(int i=0;i<int_arr.size();i++){
            if(temp >=k) break;
            temp += int_arr.get(i);
            answer++;
        }
        
        
        return answer;
    }
}
