package interviews.JPMorgan;

public class CountingBits {
    public static String intoBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static int numOf1(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') count++;
        }
        return count;
    }

    public static int[] intoArray(int numOf1, String binaryString) {
        int arrIndex = 1;
        int[] ret = new int[numOf1 + 1];
        ret[0] = numOf1;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                ret[arrIndex] = i + 1;
                arrIndex++;
            }
        }
        return ret;
    }

    public static int[] solution(int decimal) {
        String binaryString = intoBinary(decimal);
        return intoArray(numOf1(binaryString), binaryString);
    }

    public static void main(String[] args) {
        int[] test = solution(161);
        System.out.println(test.toString());
    }
}
