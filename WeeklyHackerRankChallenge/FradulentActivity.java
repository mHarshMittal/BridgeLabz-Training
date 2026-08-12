class Result {

    public static int activityNotifications(List<Integer> expenditure, int d) {

        int count = 0;

        int[] freq = new int[201];

        // Add first d values
        for (int i = 0; i < d; i++) {
            freq[expenditure.get(i)]++;
        }

        // Check remaining values
        for (int i = d; i < expenditure.size(); i++) {

            double median = getMedian(freq, d);

            if (expenditure.get(i) >= 2 * median) {
                count++;
            }

            // Remove old value
            freq[expenditure.get(i - d)]--;

            // Add current value
            freq[expenditure.get(i)]++;
        }

        return count;
    }

    private static double getMedian(int[] freq, int d) {

        int count = 0;

        if (d % 2 == 1) {

            int middle = d / 2 + 1;

            for (int i = 0; i <= 200; i++) {

                count += freq[i];

                if (count >= middle) {
                    return i;
                }
            }

        } else {

            int first = d / 2;
            int second = first + 1;

            int value1 = 0;
            int value2 = 0;

            for (int i = 0; i <= 200; i++) {

                count += freq[i];

                if (value1 == 0 && count >= first) {
                    value1 = i;
                }

                if (count >= second) {
                    value2 = i;
                    break;
                }
            }

            return (value1 + value2) / 2.0;
        }

        return 0;
    }
}