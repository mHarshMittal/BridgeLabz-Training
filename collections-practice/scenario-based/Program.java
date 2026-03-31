import java.util.*;

public class CreatorStats {
    public String CreatorName;
    public double[] WeeklyLikes;

    public static List<CreatorStats> EngagementBoard = new ArrayList<>();
}

public class Program {

    public void RegisterCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    public Map<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats c : records) {
            int count = 0;
            for (double like : c.WeeklyLikes) {
                if (like >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(c.CreatorName, count);
            }
        }
        return result;
    }

    public double CalculateAverageLikes() {
        double sum = 0;
        int count = 0;

        for (CreatorStats c : CreatorStats.EngagementBoard) {
            for (double like : c.WeeklyLikes) {
                sum += like;
                count++;
            }
        }

        if (count == 0)
            return 0;

        return sum / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program obj = new Program();
        boolean run = true;

        while (run) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    CreatorStats cs = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    cs.CreatorName = sc.nextLine();

                    cs.WeeklyLikes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        cs.WeeklyLikes[i] = sc.nextDouble();
                    }

                    obj.RegisterCreator(cs);
                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> result =
                            obj.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                    if (result.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> e : result.entrySet()) {
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                    }
                    break;

                case 3:
                    double avg = obj.CalculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int)avg);
                    break;

                case 4:
                    System.out.println("Logging off — Keep Creating with StreamBuzz!");
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}
