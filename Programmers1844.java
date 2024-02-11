import java.util.*;
class Point {
    int x;
    int y;
    int dist;
    Point (int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        int[] nx = {-1,1,0,0};
        int[] ny = {0,0,-1,1};
        
        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            if(x == maps.length-1 && y == maps[0].length-1){
                return dist;
            }
            for(int i=0;i<4;i++){
                if(x+nx[i]>=0 && x+nx[i] <maps.length && y+ny[i]>=0 &&
                  y+ny[i] < maps[0].length &&
                  maps[x+nx[i]][y+ny[i]] == 1){
                    q.add(new Point(x+nx[i],y+ny[i],dist+1));
                    maps[x+nx[i]][y+ny[i]] = 0;
                }
            }
        }
        
        
        
        return answer;
    }
}
