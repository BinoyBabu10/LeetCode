class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If digits are increasing, remove from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build answer
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        // Remove leading zeroes
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String result = sb.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}