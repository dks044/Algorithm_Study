import java.util.*;
class Process {
    int index;
    int priority;
    Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Process> list = new ArrayList<>();
        
        Queue<Process> q = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            Process p = new Process(i,priorities[i]);
            q.add(p);
        }
        int play = 1;
        while(!q.isEmpty()){
            Process current = q.poll();
            boolean isFind = false;
            for(Process p : q){
                if(p.priority > current.priority){
                    isFind = true;
                }
            }
            if(isFind) q.add(current);
            if(!isFind){
                if(location == current.index){
                    return play;
                }
                play++;
            }
        }
        
        
        return answer;
    }
}
