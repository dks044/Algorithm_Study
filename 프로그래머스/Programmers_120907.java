import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
         ArrayList<Integer> inr = new ArrayList<>();
        ArrayList<Boolean> bor = new ArrayList<>();
        int cal = 0;
        
        for(int i=0;i<quiz.length;i++){
            inr.clear();
            String[] s = quiz[i].split(" ");
            boolean ssibal = false;
            for(int j=0;j<s.length;j++){
                if(s[j].matches("-?\\d+")){
                    inr.add(Integer.parseInt(s[j]));
                }
                if(s[j].equals("-")){
                    cal = -1;
                }else if(s[j].equals("+")){
                    cal = 1;
                }
            }
            if(cal == 1){
                ssibal = (inr.get(0)+inr.get(1)) == inr.get(2);
                bor.add(ssibal);
            }else if(cal == -1){
                ssibal = (inr.get(0)-inr.get(1)) == inr.get(2);
                bor.add(ssibal);
            }
        }
		String[] answer = new String[quiz.length];
		for(int i=0;i<answer.length;i++) {
			if(bor.get(i)==true) {
				answer[i] = "O";
			}else {
				answer[i] = "X";
			}
		}
        
        
        
        
        return answer;
    }
}
