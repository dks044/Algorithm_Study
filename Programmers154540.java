import java.util.*;
class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] emptyIsland = {-1};
    public int[] solution(String[] maps) {
        List<Integer> days = new ArrayList<>();
        char[][] islandMap = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0;i<islandMap.length;i++){
            for(int j=0;j<islandMap[i].length;j++){
                islandMap[i][j] = maps[i].charAt(j);
            }
        }
        int[] nx = {1,-1,0,0};
        int[] ny = {0,0,1,-1};
        
        for(int i=0;i<islandMap.length;i++){
            for(int j=0;j<islandMap[i].length;j++){
                if(Character.isDigit(islandMap[i][j]) && !visited[i][j]){
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    int sum = 0;
                    
                    while(!q.isEmpty()){
                        Point c = q.poll();
                        if (visited[c.x][c.y]) continue; // 이미 방문했으면 건너뛰기
                        visited[c.x][c.y] = true; // 현재 위치를 방문한 것으로 표시
                        int currentDay = islandMap[c.x][c.y] - '0';
                        sum += currentDay; // 현재 지점을 sum에 추가

                        for(int move=0;move<4;move++){
                            int mx = c.x + nx[move];
                            int my = c.y + ny[move];
                            // 올바른 범위 검사 조건
                            if(mx >= 0 && my >= 0 && mx < islandMap.length && my < islandMap[0].length){
                                if(Character.isDigit(islandMap[mx][my]) && !visited[mx][my]){
                                    q.add(new Point(mx,my));
                                }
                            }
                        }
                    }
                    days.add(sum);
                }
            }
        }

        if(days.size() == 0) return emptyIsland;
        
        Collections.sort(days);
        int[] answer = new int[days.size()];
        for(int i=0;i<days.size();i++){
            answer[i] = days.get(i);
        }
        
        return answer;
    }
}
