package interviews.JPMorgan;

public class adRotation {
    public static String intoBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static String removeZero(String binaryString) {
        int count = 0;
        int index = 0;
        while (binaryString.charAt(index) == '0') {
            count ++;
            index ++;
        }
        return binaryString.substring(count);
    }



    public static int flip(String binaryString) {
       binaryString = binaryString.replaceAll("0", "x");
       binaryString = binaryString.replaceAll("1", "0");
       binaryString = binaryString.replaceAll("x", "1");
       return Integer.parseInt(binaryString, 2);
    }

    public static int solution(int decimal) {
        return flip(removeZero(intoBinary(decimal)));
    }



    public static void main(String[] args) {
        String test = removeZero("00001101");
        System.out.println(test);
        int test30 = solution(30);
        System.out.println(test30);
    }
}
