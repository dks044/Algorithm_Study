import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Set<Character> alphabet = new HashSet<>();
        for(String target : targets){
            for(char c : target.toCharArray()) if(Character.isUpperCase(c)) alphabet.add(c);
        }
        Map<Character,List<Integer>> keyPressCount = new HashMap<>();
        for(String key : keymap){
            for(char c : alphabet){
                if(!keyPressCount.containsKey(c) && key.contains(String.valueOf(c))){
                   //System.out.println(c+" "+key.indexOf(c));
                   keyPressCount.put(c,new ArrayList<Integer>());
                   keyPressCount.get(c).add(key.indexOf(c)+1);
                   continue;
                }
                if(keyPressCount.containsKey(c) && key.contains(String.valueOf(c))){
                    keyPressCount.get(c).add(key.indexOf(c)+1);
                    continue;
                }
            }
        }
        sort(keyPressCount);
        for(int result=0;result<answer.length;result++){
            char[] target = targets[result].toCharArray();
            for(char word : target){
                if(keyPressCount.containsKey(word)) answer[result] += keyPressCount.get(word).get(0);
                if(!keyPressCount.containsKey(word)){
                    answer[result] = -1;
                    break;
                }
            }
         }
        return answer;
    }
    static void sort (Map<Character,List<Integer>> keyPressCount){
       for(Map.Entry<Character,List<Integer>> entry : keyPressCount.entrySet()){
           List<Integer> entryList = entry.getValue();
           Collections.sort(entryList);
       }
    }
}
