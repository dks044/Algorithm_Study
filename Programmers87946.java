import java.util.*;
class Method {
    int n;
    int depth;
    Method(int n,int depth){
        this.n = n;
        this.depth = depth;
    }
}

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        Queue<Method> q = new LinkedList<>();
        boolean[] visited = new boolean[dungeons.length];
        q.add(new Method(k,0));
        while(!q.isEmpty()){
            Method m = q.poll();
            for(int i=0;i<dungeons.length;i++){
                if(dungeons[i][0]>=m.n && m.n - dungeons[i][1] >0 && !visited[i]){
                    q.add(new Method(m.n - dungeons[i][1],m.depth+1));
                    visited[i] = true;
                }
            }
            answer = Math.max(answer,m.depth);
        }
        
        return answer;
    }
    
}
