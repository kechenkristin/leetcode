import java.util.Arrays;

public class TargetArray1389 {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] ret = new int[n];

        for (int i = 0; i < n; i++) {
            ret = insert(nums[i], index[i], ret);
        }
        return ret;
    }

    private static int[] insert(int val, int index, int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < index; i++) {
            ret[i] = arr[i];
        }

        ret[index] = val;

        for (int i = index; i < arr.length - 1; i++) {
            ret[i + 1] = arr[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
    }
}
