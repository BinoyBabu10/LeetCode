class Solution {
    public String removeDuplicateLetters(String s) {

        int[] last = new int[26];

        // Store the last index of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Already present → skip
            if (used[ch - 'a']) {
                continue;
            }

            // Remove bigger characters if they occur again later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {

                char removed = stack.pop();

                used[removed - 'a'] = false;
            }

            stack.push(ch);
            used[ch - 'a'] = true;
        }

        // Convert stack to String
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.remove(0));
        }

        return ans.toString();
    }
}