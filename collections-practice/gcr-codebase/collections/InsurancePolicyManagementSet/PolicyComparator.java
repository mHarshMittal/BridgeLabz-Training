import java.util.Comparator;
import java.time.LocalDate;

public class PolicyComparator implements Comparator<Policy> {
    @Override
    public int compare(Policy p1, Policy p2) {
        return p1.getExpiryDate().compareTo(p2.getExpiryDate());
    }
}
