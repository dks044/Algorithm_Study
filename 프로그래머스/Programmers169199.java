import java.util.*;
class Point{
    int x;
    int y;
    int dist;
    Point (int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        char[][] graph = new char[board.length][board[0].length()];
        Point start = null;
        Point exit = null;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                graph[i][j] = board[i].charAt(j);
                if(graph[i][j] == 'R') start = new Point(i,j,0);
                if(graph[i][j] == 'G') exit = new Point(i,j,0);
            }
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int[] mx = {-1,1,0,0};
        int[] my = {0,0,-1,1};
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x + mx[i];
                int ny = p.y + my[i];
                int ndist = p.dist;
                // 이동할 수 있는 한 계속 이동
                while(nx>=0 && nx<graph.length && ny>=0 && 
                      ny<graph[0].length && graph[nx][ny] != 'D'){
                    nx += mx[i];
                    ny += my[i];
                }
                // 장애물이나 보드 끝에 부딪혔으므로 한 칸 뒤로 이동
                nx -= mx[i];
                ny -= my[i];
                ndist += 1;
                if(!visited[nx][ny]){
                    q.add(new Point(nx, ny, ndist));
                    visited[nx][ny] = true;
                }
            }
            if(p.x == exit.x && p.y == exit.y){
                return p.dist;
            }
        }

        
        return answer;
    }
}
