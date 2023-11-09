import java.util.*;
class Solution {
    static Map<Character, Integer> countWord(String str){
        Map<Character, Integer> count = new HashMap<>();
        char[] strToCharArr = str.toCharArray();
        for(char c : strToCharArr){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        
        return count;
    }
    static boolean isZero(List<Character> xy){
        for(char c : xy) if(c != '0') return false;
        return true;
    }
    
    
    public String solution(String X, String Y) {
        Map<Character, Integer> xCount = countWord(X);
        Map<Character, Integer> yCount = countWord(Y);
        List<Character> xy = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry : xCount.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(yCount.containsKey(key)){
                if(value == yCount.get(key)){
                    for(int i=1;i<=value;i++) xy.add(key);
                }
                if(value > yCount.get(key)){
                    for(int i=1;i<=yCount.get(key);i++) xy.add(key);
                }
                if(value < yCount.get(key)){
                    for(int i=1;i<=value;i++) xy.add(key);
                }
            }
        }
            
            
        if(xy.isEmpty()) return "-1";
        if(isZero(xy)) return "0";
        
        Collections.sort(xy,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(char word : xy) sb.append(word);
        
        
        return sb.toString();
    }
}
