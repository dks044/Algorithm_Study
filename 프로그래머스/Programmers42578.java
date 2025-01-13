import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        //의상의 종류, 의상의 이름(리스트)
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(!map.containsKey(clothes[i][1])){
                map.putIfAbsent(clothes[i][1],new ArrayList<String>());
                map.get(clothes[i][1]).add(clothes[i][0]);
            }else{
                map.get(clothes[i][1]).add(clothes[i][0]);
            }
        }


        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()){ 
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            if(map.size() ==1){
                System.out.println("저 사이즈1 맞습니다.");
                return value.size();
            }
            answer += (int)Math.pow(2,value.size());
        }
        answer--;
        return answer;
    }
}
