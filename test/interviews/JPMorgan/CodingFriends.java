package interviews.JPMorgan;

public class CodingFriends {
// Let say x is the number of days. After x days: 
// samSolved = difference + x*samDaily 
// kellySolved = x*kellyDaily 
// x*kellyDaily > difference + x*samDaily 
// x > difference/(kellyDaily - samDaily) if (kellyDaily <= samDaily) { return -1; } return difference/(kellyDaily - samDaily) + 1;
    public static int minNum(int samDaily, int kellyDaily, int difference) {
        if (kellyDaily <= samDaily) return -1;
        return (difference / (kellyDaily - samDaily)) + 1;
    }
}
