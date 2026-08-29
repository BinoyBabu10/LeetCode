
class Solution {

    public List<List<Integer>> combinationSum2(
            int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(
            0,
            target,
            candidates,
            ans,
            new ArrayList<>()
        );

        return ans;
    }

    private void backtrack(
            int index,
            int target,
            int[] candidates,
            List<List<Integer>> ans,
            List<Integer> ds) {

        // Target reached
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicate values at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (candidates[i] > target) {
                break;
            }

            // Pick
            ds.add(candidates[i]);

            // Move to i + 1 because each element can be used once
            backtrack(
                i + 1,
                target - candidates[i],
                candidates,
                ans,
                ds
            );

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }
}