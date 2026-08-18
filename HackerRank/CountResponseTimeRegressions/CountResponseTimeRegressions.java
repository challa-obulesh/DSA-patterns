import java.util.List;

class Result {

    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if (responseTimes.size() <= 1) {
            return 0;
        }

        int count = 0;
        long sum = responseTimes.get(0);

        for (int i = 1; i < responseTimes.size(); i++) {
            if ((long) responseTimes.get(i) * i > sum) {
                count++;
            }

            sum += responseTimes.get(i);
        }

        return count;
    }
}
