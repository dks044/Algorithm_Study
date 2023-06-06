import java.util.*;
class Point {
    int x; int y; int dist; //dist는 거리
    Point(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    public int solution(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));//시작노드
        
        //상하좌우 한칸씩, memo: 한칸 이동하면 dist+1
        while(!q.isEmpty()){            
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            //최단거리 발견
            if(x == maps.length-1 && y == maps[0].length-1){
                return dist;
            }
            //상
            if(x>0 &&maps[x-1][y] ==1){
                q.add(new Point((x-1),y,dist+1));
                maps[x-1][y] = 0; //이미 지나온자리는 방문 안하도록
            }
            //하
            if(x < maps.length -1 && maps[x+1][y] ==1){
                q.add(new Point(x+1,y,dist+1));
                maps[x+1][y] =0;
            }
            // 좌
            if(y > 0 && maps[x][y-1] == 1){
                q.add(new Point(x, y-1, dist + 1));
                maps[x][y-1] = 0;  // 이미 방문한 노드는 다시 방문하지 않도록 설정
            }

            // 우
            if(y < maps[0].length -1 && maps[x][y+1] == 1){
                q.add(new Point(x, y+1, dist + 1));
                maps[x][y+1] = 0;  // 이미 방문한 노드는 다시 방문하지 않도록 설정
            }
            
        }
        
        return -1; //없을떄 -1(기본)
    }
}
