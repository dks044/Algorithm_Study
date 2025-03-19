import java.util.*;
class Solution {
    //회원을 대상으로 매일 한 가지 제품을 할인하는 행사
    //할인하는 제품은 하루에 하나씩만 구매
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer> map = new HashMap<>();
        int answer = 0;
        int length = 10;
        
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);    
        }
        
        int count = 0;
        for(int i=0;i <= discount.length - length;i++){
            Map<String,Integer> buy = new HashMap<>(map);
            for(int j = i; j < i+length ; j++){
                buy.put(discount[j], buy.getOrDefault(discount[j], 0) - 1);
            } 
            if(isCorrect(buy)){
                answer++;
            }
        }
        
        return answer;
    }
    static boolean isCorrect(Map<String,Integer> map){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > 0) return false;
        }
        return true;
    }
}
