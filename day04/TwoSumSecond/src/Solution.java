class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length && numbers[i] <= target; ++i) {
            for (int j = i + 1; j < numbers.length - 1 && numbers[i] + numbers[j] <= target; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}