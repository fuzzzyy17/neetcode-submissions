class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');

        if (s.length() == 1) {
            return false;
        }

        for (char bracket : s.toCharArray()) {
            if ((bracket == '(') || (bracket == '[') || (bracket == '{')) {
                stack.push(bracket);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            } else if ((stack.peek() != bracketsMap.get(bracket))) {
                return false;
            } else {
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else {
        return true;
        }
    }
}
