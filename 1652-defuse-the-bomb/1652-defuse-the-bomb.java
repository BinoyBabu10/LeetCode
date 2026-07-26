class Solution {
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] ans = new int[n];

        // Case 1: k == 0
        if (k == 0) {
            return ans;
        }

        // ---------- k > 0 ----------
        if (k > 0) {

            int windowSum = 0;

            // First window (next k elements of index 0)
            for (int i = 1; i <= k; i++) {
                windowSum += code[i];
            }

            ans[0] = windowSum;

            int left = 1;
            int right = k;

            for (int i = 1; i < n; i++) {

                // Remove leftmost element
                windowSum -= code[left % n];
                left++;

                // Move right pointer
                right++;

                // Add new rightmost element
                windowSum += code[right % n];

                ans[i] = windowSum;
            }
        }

        // ---------- k < 0 ----------
        else {

            k = -k;

            int windowSum = 0;

            // First window (previous k elements of index 0)
            for (int i = n - k; i < n; i++) {
                windowSum += code[i];
            }

            ans[0] = windowSum;

            int left = n - k;
            int right = n - 1;

            for (int i = 1; i < n; i++) {

                windowSum -= code[left % n];
                left++;

                right++;

                windowSum += code[right % n];

                ans[i] = windowSum;
            }
        }

        return ans;
    }
}