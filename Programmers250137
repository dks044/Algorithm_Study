import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int max = 0;
        int oH = health;
        Map<Integer,Integer> monGraph = new HashMap<>();
        for(int[] num : attacks){
            monGraph.put(num[0],num[1]);
            max  = Math.max(max,num[0]);
        }
        int bandageCombo = 0;
        for(int i=1;i<=max;i++){
            if(monGraph.containsKey(i)){
                health -= monGraph.get(i);
                bandageCombo = 0;
                if(health <= 0) return -1;
            }
            if(!monGraph.containsKey(i) && health <= oH){
                health += bandage[1];
                bandageCombo++;
                if(health > oH) health = oH;
            }
            if(!monGraph.containsKey(i) && bandageCombo == bandage[0]){
                health += bandage[2];
                bandageCombo =0;
                if(health > oH) health = oH;
            }
            System.out.println(i+"번째"+" 남은체력:"+health+" 콤보:"+bandageCombo);
        }
        
        answer = health;
        return answer;
    }
}
