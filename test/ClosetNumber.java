import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ClosetNumber {
    public static List<Integer> closestNumbers(List<Integer> list) {
        TreeMap<Integer, Integer> pairs = new TreeMap<>();

        int min = Integer.MAX_VALUE;

        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            int i1 = list.get(i);
            int i2 = list.get(i + 1);
            int abs = Math.abs(i1 - i2);
            if (abs < min) {
                pairs.clear();
                min = abs;
                if (i1 < i2)
                    pairs.put(i1, i2);
                else
                    pairs.put(i2, i1);

            } else if (abs == min) {
                if (i1 < i2)
                    pairs.put(i1, i2);
                else
                    pairs.put(i2, i1);
            }
        }
        List<Integer> result = new ArrayList<>();
        pairs.forEach((k, v) -> {
            result.add(k);
            result.add(v);
        });
        return result;
    }

}
