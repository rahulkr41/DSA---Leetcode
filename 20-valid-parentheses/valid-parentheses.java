import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // If the string has an odd length, it can't be balanced
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it to the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // If it's a closing bracket, check for matching opening bracket
            else {
                // If the stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were properly matched
        return stack.isEmpty();
    }
}