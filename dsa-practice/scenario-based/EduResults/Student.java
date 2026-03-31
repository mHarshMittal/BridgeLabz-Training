public class Student {
    private final String name;
    private final String district;
    private final int score;

    public Student(String name, String district, int score) {
        this.name = name;
        this.district = district;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " (" + district + ") - " + score;
    }
}
