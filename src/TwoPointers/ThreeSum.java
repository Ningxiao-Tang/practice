package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length -2; i++) {
                if (i != 0 && numbers[i] == numbers[i-1])
                    continue;
                findTwoSum(numbers, i, result);

        }
        return result;

    }

    private void findTwoSum(int[] numbers, int i, List<List<Integer>> result) {
        int left = i+1, right = numbers.length-1;
        int target = -numbers[i];
        while (left < right) {
            int twoSum = numbers[left] + numbers[right];
            if (twoSum < target)
                left++;
            else if (twoSum > target)
                right--;
            else {
                List<Integer> triple = new ArrayList<>();
                triple.add(numbers[i]);
                triple.add(numbers[left]);
                triple.add(numbers[right]);
                result.add(triple);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left-1])
                    left++;
                while (left < right && numbers[right] == numbers[right+1])
                    right--;
            }
        }
    }
}
