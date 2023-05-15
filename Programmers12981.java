import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
		Set<String> set = new HashSet<>();
		set.add(words[0]);
		int count =1;
		for(int i=1;i<words.length;i++) {
			if(set.contains(words[i]))break;
			if(words[i].charAt(0) == words[i-1].charAt(words[i-1].length()-1)) {
				set.add(words[i]);
				count++;
			}else break;
		}
		//words루프를 다돌았는데도 탈락자가 없을경우
		if(count==words.length) {
			answer[0]=0;answer[1]=0;
		}else {
			answer[0]= count%n+1;//탈락자 n번쨰 사람. 
			answer[1]=count/n+1; //탈락자 n번쨰사람의 i번쨰 단어.
		}

        return answer;
    }
}
