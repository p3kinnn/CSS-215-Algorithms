import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        char ch1 = s.charAt(0);
        char[] arr = s.toCharArray();
        if (arr.length % 2 == 1 || ch1 == ')' ||ch1 == '}' || ch1 == ']' ) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (elem == '{' || elem == '(' || elem == '[') {
                stack.push(elem);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (elem == ')' && top != '(') {
                    return false;
                }
                if (elem==']' && top != '[') {
                    return false;
                }
                if (elem == '}' && top != '{') {
                    return false;
                } 
                
            }

        }
        return stack.isEmpty();
    }
}