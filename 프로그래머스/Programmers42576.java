import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> participantMap = new HashMap<>();
        Map<String,Integer> completionMap = new HashMap<>();
        
        for(String s : participant){
            if(!participantMap.containsKey(s)) participantMap.put(s,0);
            else participantMap.put(s,participantMap.get(s)+1);
        }
        for(String s : completion){
            if(!completionMap.containsKey(s)) completionMap.put(s,0);
            else completionMap.put(s,completionMap.get(s)+1);
        }
        for(Map.Entry<String,Integer> entry : participantMap.entrySet()){
            if(!completionMap.containsKey(entry.getKey())) return entry.getKey();
            int completionMapValue = completionMap.get(entry.getKey());
            if(completionMapValue != entry.getValue()) return entry.getKey();
        }

        
        return "";
    }
}
