import java.util.*;
class Solution {
    //0 : 지도에없음, 1 : 이동가능, 2 : 시작 , 3 : 장애물
    static final int OBSTACLE = 3;
    static final int START = 2;
    static final int MOVE_ENABLED = 1;
    static final int MAP_CLOSED = 0;
    
    static int getMaxLengthByString(String[] park){
        int maxLength = 0;
        for(String str : park){
            if(maxLength < str.length()) maxLength = str.length();
        }
        return maxLength;
    }
    public int[] solution(String[] park, String[] routes) {

        int maxLength = getMaxLengthByString(park);
        int[][] parkMap = new int[park.length][maxLength];
        int startIndexRow = 0;
        int startIndexCol = 0;
        //지도만들기
        for(int i=0;i<parkMap.length;i++){
            for(int j=0;j<parkMap[i].length;j++){
                char[] cell = park[i].toCharArray();
                if(j >= cell.length) break;
                if(cell[j] == 'S'){
                    parkMap[i][j] =  START;
                    startIndexRow = i;
                    startIndexCol = j;
                    continue;
                }
                if(cell[j] == 'X'){
                    parkMap[i][j] =  OBSTACLE;
                    continue;
                }
                parkMap[i][j] =  MOVE_ENABLED;
            }
        }
        
        
        for(String route : routes){
            char way = route.charAt(0);
            int step = route.charAt(2) - '0';
            if(!isMove(way,step,startIndexRow,startIndexCol,parkMap)) continue;
            else{
                if(way == 'S'){
                    for(int i=1;i<=step;i++){
                        startIndexRow++;
                    }
                }
                if(way == 'N'){
                    for(int i=1;i<=step;i++){
                        startIndexRow--;
                    }
                }
                if(way == 'E'){
                    for(int i=1;i<=step;i++){
                        startIndexCol++;
                    }
                }
                if(way == 'W'){
                    for(int i=1;i<=step;i++){
                        startIndexCol--;
                    }
                }
            }

        }
        int[] answer = {startIndexRow,startIndexCol};
        return answer;
        
    }
    static boolean isMove(char way, int step, int startIndexRow, int startIndexCol, int[][] parkMap){
        boolean move = true;
        if(way == 'S'){
            for(int i=1;i<=step;i++){
                if((startIndexRow+i) >= parkMap.length){
                    return move = false;
                }
                if(parkMap[startIndexRow+i][startIndexCol] < MOVE_ENABLED || 
                  parkMap[startIndexRow+i][startIndexCol] > START
                  ) {
                    return move = false;
                }
            }
        }
        if(way == 'N'){
            for(int i=1;i<=step;i++){
                if((startIndexRow-i) < 0){
                    return move = false;
                }
                if(parkMap[startIndexRow-i][startIndexCol] < MOVE_ENABLED || 
                  parkMap[startIndexRow-i][startIndexCol] > START
                  ) {
                    return move = false;
                }
            }
        }
        if(way == 'E'){
            for(int i=1;i<=step;i++){
                if((startIndexCol+i) >= parkMap[startIndexRow].length){
                    return move = false;
                }
                if(parkMap[startIndexRow][startIndexCol+i] < MOVE_ENABLED || 
                  parkMap[startIndexRow][startIndexCol+i] > START
                  ) {
                    return move = false;
                }
            }
        }
        if(way == 'W'){
            for(int i=1;i<=step;i++){
                if((startIndexCol-i) < 0){
                    return move = false;
                }
                if(parkMap[startIndexRow][startIndexCol-i] < MOVE_ENABLED || 
                  parkMap[startIndexRow][startIndexCol-i] > START
                  ) {
                    return move = false;
                }
            }
        }
        
        return move;
    }
}
