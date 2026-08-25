public class LongestNonDecreasingSubstring {

    public static int findLongest(String dataStream) {

        int n = dataStream.length();
        int goodBlocks = 0;
        int totalBlocks = n / 2;

        for (int i = 0; i < n; i += 2) {

            String block = dataStream.substring(i, i + 2);

            if (!block.equals("10")) {
                goodBlocks++;
            }
        }

        // All blocks can be arranged in non-decreasing order
        if (goodBlocks == totalBlocks) {
            return n;
        }

        // At least one good block exists.
        // Arrange good blocks together and use one character
        // from an adjacent "10" block.
        if (goodBlocks > 0) {
            return Math.min(n, 2 * goodBlocks + 1);
        }

        // All blocks are "10"
        if (totalBlocks == 1) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {

        String dataStream = "110000";

        System.out.println(findLongest(dataStream));
    }
}