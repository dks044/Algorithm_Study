class Solution {
    boolean solution(String s) {
        // 괄호가 하나도 없거나 홀수개면 false
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        
        // 여는 괄호는 스택에 넣어서 매칭되는 닫는 괄호가 나오면 pop
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                // 스택이 비어있으면 닫는 괄호가 많다는 뜻으로 false
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        // 스택이 비어있으면 모두 짝지어진 것으로 true
        return stack.isEmpty();
    }
}
