import java.util.List;

class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int primarySum = 0;
        int secondarySum = 0;
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            primarySum += arr.get(i).get(i);
            secondarySum += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primarySum - secondarySum);
    }
}
