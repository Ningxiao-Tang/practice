public class MergeSortedArray {
    //O(nlogn)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
    }
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] ans = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length || j < B.length) {
            if (i >= A.length && j <B.length) {
                ans[k++] = B[j++];
            }
            if (j >= B.length && i < A.length) {
                ans[k++] = A[i++];
            }
            if (i < A.length && j < B.length && A[i] < B[j]) {
                ans[k++] = A[i];
                i++;
            }
            else if (i < A.length && j < B.length &&A[i] >= B[j]){
                ans[k++] = B[j];
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[] B = {2,4,5,6};
        int[] ret = mergeSortedArray(A, B);
    }
}
