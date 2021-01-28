import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1] ;
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        while (i < nums.length) {
            // check if first value is out of the window
            if (!dq.isEmpty() && dq.peekFirst() == i - k){
                dq.pollFirst();
            }
            // delete last value if it is smaller than the current value
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if (i >= k - 1) {
                res[i-k+1] = nums[dq.peekFirst()];
            }
            i++;
        }

        return res;

    }
}
