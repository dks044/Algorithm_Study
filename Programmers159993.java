import java.util.*;
class Point {
    int x;
    int y;
    int dist;
    int lever; // 레버를 당겼는지 여부 (0: 당기지 않음, 1: 당김)
    Point(int x,int y, int dist, int lever){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.lever = lever;
    }
}

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        char[][] map = new char[n][m];
        Point start = null, lever = null, exit = null;
        
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'S') start = new Point(i, j, 0, 0);
                else if(map[i][j] == 'L') lever = new Point(i, j, 0, 0);
                else if(map[i][j] == 'E') exit = new Point(i, j, 0, 0);
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Point> q = new LinkedList<>();
        
        q.offer(start);
        visited[start.x][start.y][0] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            if(cur.x == exit.x && cur.y == exit.y && cur.lever == 1) {
                return cur.dist;
            }
            
            for(int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if(map[nx][ny] != 'X' && !visited[nx][ny][cur.lever]) {
                    visited[nx][ny][cur.lever] = true;
                    if(nx == lever.x && ny == lever.y) {
                        q.add(new Point(nx, ny, cur.dist + 1, 1));
                    } else {
                        q.add(new Point(nx, ny, cur.dist + 1, cur.lever));
                    }
                }
            }
        }
        
        return -1;
    }
}
