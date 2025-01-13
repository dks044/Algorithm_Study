import java.util.*;
class Solution {
    static final int CODE = 0;
    static final int DATE = 1;
    static final int MAXIMUM = 2;
    static final int REMAIN = 3;
    
    public static int standatdIndex(String ext){
            if(ext.equals("code")){
                return CODE;
            }
            if(ext.equals("date")){
                return DATE;
            }
            if(ext.equals("maximum")){
                return MAXIMUM;
            }
            if(ext.equals("remain")){
                return REMAIN;
            }
        return 0;
    }
    
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Integer> indexs = new ArrayList<>(); //ext(기준) 통과한 인덱스를 할당하는 배열
        int indexStandard = standatdIndex(ext);
        for(int i=0;i<data.length;i++){
            if(data[i][indexStandard] < val_ext) indexs.add(i);
        }
        int[][] answer = new int[indexs.size()][4];
        List<Integer> sort_byFields = new ArrayList<>(); //sort_by 기준대로 필드를 할당한 배열
        
        int sort_byIndex = standatdIndex(sort_by);
        for(int i=0;i<data.length;i++){
            if(indexs.contains(i)) sort_byFields.add(data[i][sort_byIndex]);
        }
        
        Collections.sort(sort_byFields);
        int standard = standatdIndex(sort_by);
        int isGoing = 0;
        while(isGoing < indexs.size()){
            for(int field : sort_byFields){
                for(int i=0;i<data.length;i++){
                    if(data[i][standard] == field){
                        answer[isGoing][0] = data[i][0];
                        answer[isGoing][1] = data[i][1];
                        answer[isGoing][2] = data[i][2];
                        answer[isGoing][3] = data[i][3];
                        isGoing++;
                    }
                }
            }
        }
        
        return answer;
    }

}
