
public class Course<T extends CourseType> {
    private final String code;
    private final T type;

    public Course(String code, T type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public T getType() {
        return type;
    }

    @Override
    public String toString() {
        return code + " - " + type;
    }
}

