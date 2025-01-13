class Solution {
    public int solution(int n) {
        int answer=0;
        int n_count =0;
		String temp3 = Integer.toBinaryString(n);
		char[] temp4 = temp3.toCharArray();
		for(int i=0;i<temp4.length;i++) {
			if(temp4[i]=='1') {
				n_count +=1;
			}
		}
		
		while (n !=1) {
			n+=1;
			int one_count =0;
			String temp = Integer.toBinaryString(n);
			char[] temp2 = temp.toCharArray();
			for(int i=0;i<temp2.length;i++) {
				if(temp2[i]=='1') {
					one_count +=1;
				}
			}
            //n의 1의 개수와 같을떄 break;
			if(one_count ==n_count) {
				break;
			}
			
		}
        answer =n;
        return answer;
    }
}
