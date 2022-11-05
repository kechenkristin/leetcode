package interviews.JPMorgan;

public class powerOfTwo {
    public static boolean solution(int num) {
        return num > 0 && ((num & (num - 1)) == 0);
    }
}
