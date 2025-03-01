import java.util.*;
class Solution {
    public boolean solution(String[] phoneBook) {
        // System.out.println("정렬전 ==============");
        // for(String s : phoneBook){
        //     System.out.println(s);
        // }
        Arrays.sort(phoneBook);
        // System.out.println("정렬후 ==============");
        // for(String s : phoneBook){
        //     System.out.println(s);
        // }
        
        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;
        
        return true;
    }
}
