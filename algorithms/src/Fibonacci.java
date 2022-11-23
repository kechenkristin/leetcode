public class Fibonacci {
    public static int fibRe(int n) {
        if (n <= 1) return n;
        return fibRe(n - 1) + fibRe(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(fibRe(9));
    }
}
