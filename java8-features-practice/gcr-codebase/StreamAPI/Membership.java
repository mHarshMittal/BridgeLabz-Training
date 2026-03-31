import java.time.*;
import java.util.*;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

public class Membership {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("John", LocalDate.now().plusDays(10)),
            new Member("Sara", LocalDate.now().plusDays(40))
        );

        members.stream()
               .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
               .forEach(m -> System.out.println(m.name));
    }
}
