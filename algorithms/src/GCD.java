public class GCD {
    public static int Gcd(int a, int b) {
        if (a % b == 0) return b;
        return Gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(Gcd(60,36));
    }
}
