package interviews.JPMorgan;

public class maximumUnits {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int ret = 0;
        int count = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            for (int j = 0; j < boxTypes[i][0]; j++) {
                if (count <= truckSize) {
                    return ret;
                }else {
                    ret += boxTypes[i][1];
                    count++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        int[][] arr2 = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(maximumUnits(arr, 4));
        System.out.println(maximumUnits(arr2, 10));
    }
}
