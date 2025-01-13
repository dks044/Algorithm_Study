import java.util.*;
import java.util.stream.*;
class Solution {
    static int parsePoint(int point){
        if(point < 4) point = (4-point);
        if(point > 4) point -= 4;
        if(point == 4) point = 0;
        return point;
    }
    static char compareWord(char a,char b){
        char result = ' ';
        if(a > b) result = b;
        else result = a;

        return result;
    }
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character,Integer> kakaoMap = new HashMap<>();
        String[] kakaoGraphs = {"RT","CF","JM","AN"};
        for(String graph : kakaoGraphs){
            char firstWord = graph.charAt(0);
            char secondWord = graph.charAt(1);
            kakaoMap.put(firstWord,0);
            kakaoMap.put(secondWord,0);
        }
        
        for(int i=0;i<survey.length;i++){
            char firstWord = survey[i].charAt(0);
            char secondWord = survey[i].charAt(1);
            int point = parsePoint(choices[i]);
            if(choices[i]>=1 && choices[i]<=3){
                if(!kakaoMap.containsKey(firstWord)) kakaoMap.put(firstWord,point);
                else kakaoMap.put(firstWord,kakaoMap.get(firstWord)+point);
            }else if(choices[i]==4) continue;
            else{
                if(!kakaoMap.containsKey(secondWord)) kakaoMap.put(secondWord,point);
                else kakaoMap.put(secondWord,kakaoMap.get(secondWord)+point);
            }
        }
        
        List<Map.Entry<Character,Integer>> sortKakaoMap = kakaoMap.entrySet()
                                                                 .stream()
                                                                 .sorted(Map.Entry.<Character,Integer>comparingByValue()
                                                                  .reversed()
                                                                  .thenComparing(Map.Entry.comparingByKey()))
                                                                 .collect(Collectors.toList());
        
        //지표에 따른 문자열 할당
        for(String graph : kakaoGraphs){
            char firstWord = graph.charAt(0);
            char secondWord = graph.charAt(1);
            if(kakaoMap.get(firstWord) > kakaoMap.get(secondWord)) answer += firstWord;
            else if(kakaoMap.get(firstWord) < kakaoMap.get(secondWord)) answer += secondWord;
            else{//같을경우
                answer+= compareWord(firstWord,secondWord);
            }
        }
        
        return answer;
    }
}
