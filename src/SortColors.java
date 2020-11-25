public class SortColors {
    public static void sortColors(int[] nums) {
        if(nums==null || nums.length<2) return;
        sort(nums, 0, nums.length-1 );
    }

    private static void sort(int[] nums, int lo, int hi) {
        int i = 0;
        while (i <= hi){
            if (nums[i] == 0){
                int t = nums[i];
                nums[i] = nums[lo];
                nums[lo] = t;
                lo++;
                i++;
            }
            else if (nums[i] == 2){
                int t = nums[i];
                nums[i] = nums[hi];
                nums[hi] = t;
                hi--;
            }
            else
                i++;
        }


    }



    public static void main(String[] args) {
        int[] test = {0,2,2,2,2,1,0,1,0,0,0,1,0,2,0};
        sortColors(test);
        for (int a : test){
            System.out.println(a);
        }
    }
}
