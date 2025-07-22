class Solution {
    public int[] solution(long n) {
        String word = String.valueOf(n);
        int[] arr = new int[word.length()];
        char[] nums = word.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            arr[i] = nums[arr.length -1 -i] - '0';
        }
        
        return arr;
    }
}
