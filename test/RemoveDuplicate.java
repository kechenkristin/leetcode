public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 1) return 1;

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow;
    }

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        StringBuilder sb =new StringBuilder(str);
        sb.reverse();
        return (str.equals(sb.toString()));
    }

    public static void main(String[] args) {
        int ret = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(isPalindrome(121));
    }
}
