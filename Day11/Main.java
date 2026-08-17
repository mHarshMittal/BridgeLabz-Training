enum Season {
    WINTER("Cold"),
    SPRING("Mild"),
    SUMMER("Hot"),
    FALL("Cool");

    private final String description;

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class Main {

    public static void main(String[] args) {

        // Print all seasons with their descriptions
        for (Season season : Season.values()) {
            System.out.println(season + " - " + season.getDescription());
        }

        // Switch example
        Season currentSeason = Season.SUMMER;

        switch (currentSeason) {
            case SUMMER:
                System.out.println("Summer is hot.");
                break;

            default:
                System.out.println("It is not summer.");
        }
    }
}