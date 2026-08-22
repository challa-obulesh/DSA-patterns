import java.util.List;

class Result {
    public static long aVeryBigSum(List<Long> ar) {
        long sum = 0;

        for (int i = 0; i < ar.size(); i++) {
            sum += ar.get(i);
        }

        return sum;
    }
}
