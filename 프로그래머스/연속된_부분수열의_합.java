class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int right =0;
        int left =0;
        int sum =0;
        int minLength = Integer.MAX_VALUE;
        while(right < sequence.length){
            while(sum < k && right < sequence.length){
                sum += sequence[right++];
            }
            while(sum > k && left < sequence.length){
                sum -= sequence[left++];
            }
            if(sum == k){
                int pointerLength = right - left;
                sum -= sequence[left++];
                if(minLength > pointerLength){
                    minLength = pointerLength;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        answer[0]--;
        answer[1]--;
        return answer;
    }
}
