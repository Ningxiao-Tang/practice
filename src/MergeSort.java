public class MergeSort {
    public void mergeSort(int[] A) {
        int[] temp = new int[A.length];
        sort(A, 0, A.length-1, temp);
    }

    private void sort(int[] A, int lo, int hi, int[] temp) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) /2;
        sort(A, lo, mid, temp);
        sort(A, mid + 1, hi, temp);
        merge(A, temp, lo, mid, hi);
    }

    private void merge(int[] A, int[] temp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = A[k];
        }
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) A[k] = temp[j++];
            else if (j > hi) A[k] = temp[i++];
            else if (temp[i] < temp[j]) A[k] = temp[i++];
            else A[k] = temp[j++];
        }

    }
}
