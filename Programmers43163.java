import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean isExist = false;
        for(String word : words) {
            if(word.equals(target)){
                isExist = true;
                break;
            }
        }
        if(!isExist) return 0;
        
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word currentWord = q.poll();
            if(currentWord.word.equals(target)){
                return currentWord.depth;
            }
            for(String word : words){
                if(isChangeable(currentWord.word, word)){
                    q.offer(new Word(word, currentWord.depth + 1));
                }
            }
        }
        return 0;
    }
    //한번에 한개의 알파벳만 바꿀수 있기 떄문에
    public boolean isChangeable(String current, String next){
        int count = 0;
        for(int i = 0; i < current.length(); i++){
            if(current.charAt(i) != next.charAt(i)){
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}

class Word {
    String word;
    int depth;
    
    Word(String word, int depth){
        this.word = word;
        this.depth = depth;
    }
}
