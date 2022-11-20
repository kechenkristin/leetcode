package interviews.JPMorgan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Stock {
    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        // Write your code here
        List<Integer> ret = new ArrayList<>();
        for (Integer q : queries) {
            ret.add(helperFindPointer(stockData, q));
        }
        return ret;
    }

    private static int helperFindPointer(List<Integer> stockData, int day) {
        int index = day - 1;

        if (index == 0) {
            if (stockData.get(1) < stockData.get(index)) return 2;
            return orderS(stockData, index, stockData.get(index)) + 1;
        }

        if (index == stockData.size() - 1) {
            if (stockData.get(index - 1) < stockData.get(index)) return index;
            return reverseS(stockData, index, stockData.get(index)) + 1;
        }


        int lp = index - 1;
        int rp = index + 1;
        int dayData = stockData.get(index);
        // case1 day6
        if (stockData.get(lp) < dayData) return lp + 1;
        if (stockData.get(rp) < dayData) return rp + 1;

        int ld = orderS(stockData, rp, dayData) + 1;
        int rd = reverseS(stockData, lp, dayData) + 1;

        if (ld != -1) return ld + 1;
        if (rd != -1) return rd + 1;
        return -1;

    }

    private static int orderS(List<Integer> stockData, int start, int target) {
        for (int i = start + 1; i < stockData.size(); i++) {
            if (stockData.get(i) < target) {
                return i;
            }
        }
        return -2;
    }

    private static int reverseS(List<Integer> stockData, int start, int target) {
        for (int i = start - 1; i > 0; i--) {
            if (stockData.get(i) < target) {
                return i;
            }
        }
        return -2;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 6, 8, 4, 9, 10, 8, 3, 6, 4};
        List<Integer> s = Arrays.asList(arr);
        Integer[] arr2 = new Integer[]{6, 5, 8};
        List<Integer> q = Arrays.asList(arr2);
        List<Integer> ret = predictAnswer(s, q);
        System.out.println(ret);

        Integer[] arr3 = new Integer[]{
                10,
                5,
                6,
                8,
                4,
                9,
                10,
                8,
                3,
                6,
                4,
                3,
        };
        List<Integer> s1 = Arrays.asList(arr3);
        Integer[] arr4 = new Integer[]{3, 1, 8};
        List<Integer> q1 = Arrays.asList(arr4);
        List<Integer> ret1 = predictAnswer(s1, q1);

        System.out.println(ret1);
    }

}
