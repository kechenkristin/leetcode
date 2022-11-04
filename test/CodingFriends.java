public class CodingFriends {
    public static int minNum(int samDaily, int kellyDaily, int difference) {
        if (kellyDaily <= samDaily) return -1;
        return (difference / (kellyDaily - samDaily)) + 1;
    }
}
