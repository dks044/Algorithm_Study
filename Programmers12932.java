import java.util.*;
class Solution {
    public static void reverseArray(int[] arr) {
    int length = arr.length;
    for (int i = 0; i < length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[length - i - 1];
        arr[length - i - 1] = temp;
    }
}

    public int[] solution(long n) {
        
        String num = String.valueOf(n);
        int[] answer = new int[num.length()];
        char[] numm = num.toCharArray();
        ArrayList<Character> num_arr = new ArrayList<>();
        for(char word : numm){
            num_arr.add(word);
        }
        ArrayList<Integer> num_arr2 = new ArrayList<>();
        for(int i=0;i<num_arr.size();i++){
            Integer a = Character.valueOf(num_arr.get(i))-'0';
            num_arr2.add(a);
        }
        for(int i=0;i<num_arr2.size();i++){
            answer[i] = num_arr2.get(i);
        }
        reverseArray(answer);
        
        return answer;
    }
}
