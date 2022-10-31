import java.util.Arrays;

public class plusOne {

    public static int[] plusOne(int[] digits) {
        return intoArray(calDigits(digits), calArrayLen(digits));
    }

    private static int calArrayLen(int[] digits) {
        if (digits[0] == 9 && digits[digits.length - 1] == 9) return digits.length + 1;
        return digits.length;
    }

    private static int calDigits(int[] digits) {
        int sum = 0;
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int d = (int) Math.pow(10, count);
            sum += digits[i] * d;
            count++;
        }
        return sum + 1;
    }


    // 123 -> [1, 2, 3]
    private static int[] intoArray(int num, int aLen) {
        int[] ret = new int[aLen];
        int index = aLen - 1;
        while (num != 0) {
            ret[index] = num % 10;
            num /= 10;
            index--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }
}
