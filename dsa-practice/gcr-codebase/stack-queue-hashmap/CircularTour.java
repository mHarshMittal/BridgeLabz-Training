class CircularTour {

    public static int findStartPoint(int[] petrol, int[] distance) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i];

            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        System.out.println(findStartPoint(petrol, distance));
    }
}
