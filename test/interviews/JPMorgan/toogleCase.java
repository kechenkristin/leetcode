package interviews.JPMorgan;

public class toogleCase {
    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 97 && c <= 122) {
                stringBuilder.append((char)(c - 32));
            } else if (c >= 65 && c <= 90) {
                stringBuilder.append((char)(c + 32));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Abc"));
    }
}
