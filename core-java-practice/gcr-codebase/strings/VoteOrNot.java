import java.util.Random;

public class VoteOrNot {
    public static void main(String[] args) {
        Random random = new Random();
        int[] ages = new int[10];

        System.out.println("Age\tEligible to Vote");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = random.nextInt(91) + 10;
            boolean canVote = ages[i] >= 18;
            System.out.println(ages[i] + "\t" + canVote);
        }
    }
}
