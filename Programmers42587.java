import java.util.*;
class Work{
    int price;
    int location;
    Work(int price, int location){
        this.price = price;
        this.location = location;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
    	
        Queue<Work> q = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            q.add(new Work(priorities[i],i));
        }
        ArrayList<Work> ssibal_arr = new ArrayList<>();
        while(!q.isEmpty()){
            Work ssibal = q.poll();
            
            int max_price =0;
            for(Work w : q) if(w.price > max_price) max_price = w.price;
            if(max_price > ssibal.price) q.add(ssibal);
            else ssibal_arr.add(ssibal);
        }
        for(Work w : ssibal_arr){
            if(w.location == location){
                answer++;
                break;
            }else answer++;
        }
        
        return answer;
    }
}
