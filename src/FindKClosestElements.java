import java.util.ArrayList;
import java.util.List;
//Given a sorted integer array arr
//return the k closest integers to x in the array.
//The result should also be sorted in ascending order.
//leetcode658
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
                lo++;
            } else {
                hi--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;

    }
    //lintcode460: 返回这k个数并按照与target的接近程度从小到大排序，如果接近程度相当，那么小的数排在前面。
    public int[] KClosetNumbers(int[] A, int target, int k) {
        int left = findLowerCloset(A, target);
        int right = left + 1;
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                result[i] = A[left];
                left--;
            }else {
                result[i] = A[right];
                right++;
            }
        }
        return result;
    }

    private boolean isLeftCloser(int[] a, int target, int left, int right) {
        if (left < 0) return false;
        if (right >= a.length) return true;
        if (target - a[left] != a[right] - target){
            return target - a[left] < a[right] - target;
        }
        return true;
    }

    private int findLowerCloset(int[] A, int target) {
        // find the last element that is smaller than target
        int start = 0, end = A.length -1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target)
                start = mid;
            else
                end = mid;
        }
        if (A[end] < target)
            return end;
        if (A[start] < target)
            return start;
        return -1;
    }
}

