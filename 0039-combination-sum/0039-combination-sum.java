
class Solution {

    public void findCombination(
            int ind,
            int target,
            int[] candidates,
            List<List<Integer>> ans,
            List<Integer> ds) {

        // Base case
        if (ind == candidates.length) {

            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }

            return;
        }

        // PICK
        if (candidates[ind] <= target) {

            ds.add(candidates[ind]);

            // Same index because we can reuse the element
            findCombination(
                ind,
                target - candidates[ind],
                candidates,
                ans,
                ds
            );

            // Backtrack
            ds.remove(ds.size() - 1);
        }

        // SKIP
        findCombination(
            ind + 1,
            target,
            candidates,
            ans,
            ds
        );
    }

    public List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ds = new ArrayList<>();

        findCombination(
            0,
            target,
            candidates,
            ans,
            ds
        );

        return ans;
    }
}