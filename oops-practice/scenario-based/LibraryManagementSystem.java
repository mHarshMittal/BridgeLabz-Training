import java.time.LocalDate;
import java.util.*;

// Library management with issue/return and fine calculation.
public class LibraryManagementSystem {
    public static void main(String[] args) {
        FineCalculator studentCalculator = daysLate -> daysLate * 2;
        Library library = new Library(studentCalculator);

        library.addBook(new Book("B1", "Clean Code"));
        library.registerMember(new Member("M1", "Neha"));

        library.issueBook("B1", "M1");
        library.returnBook("B1", "M1", LocalDate.now().plusDays(10)); // late return
    }
}

class Book {
    private final String id;
    private final String title;
    private boolean issued;

    Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }
}

class Member {
    private final String id;
    private final String name;

    Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
}

class Transaction {
    private final String bookId;
    private final String memberId;
    private final LocalDate issueDate;
    private LocalDate returnDate;

    Transaction(String bookId, String memberId, LocalDate issueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public long daysLate() {
        LocalDate dueDate = issueDate.plusDays(7);
        if (returnDate == null || !returnDate.isAfter(dueDate)) {
            return 0;
        }
        return dueDate.until(returnDate).getDays();
    }
}

interface FineCalculator {
    double calculateFine(long daysLate);
}

class BookNotAvailableException extends RuntimeException {
    BookNotAvailableException(String msg) {
        super(msg);
    }
}

class Library {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Transaction> transactions = new ArrayList<>();
    private final FineCalculator fineCalculator;

    Library(FineCalculator fineCalculator) {
        this.fineCalculator = fineCalculator;
    }

    void addBook(Book book) {
        books.put(book.getId(), book);
    }

    void registerMember(Member member) {
        members.put(member.getId(), member);
    }

    void issueBook(String bookId, String memberId) {
        Book book = requireBook(bookId);
        requireMember(memberId);
        if (book.isIssued()) {
            throw new BookNotAvailableException("Book already issued");
        }
        book.setIssued(true);
        transactions.add(new Transaction(bookId, memberId, LocalDate.now()));
        System.out.println("Issued " + book.getTitle() + " to " + memberId);
    }

    void returnBook(String bookId, String memberId, LocalDate returnDate) {
        Book book = requireBook(bookId);
        Transaction tx = findTransaction(bookId, memberId);
        tx.setReturnDate(returnDate);
        book.setIssued(false);
        long daysLate = tx.daysLate();
        double fine = fineCalculator.calculateFine(daysLate);
        System.out.println("Returned with fine: " + fine);
    }

    private Book requireBook(String id) {
        Book book = books.get(id);
        if (book == null) {
            throw new IllegalArgumentException("Book missing " + id);
        }
        return book;
    }

    private void requireMember(String id) {
        if (!members.containsKey(id)) {
            throw new IllegalArgumentException("Member missing " + id);
        }
    }

    private Transaction findTransaction(String bookId, String memberId) {
        return transactions.stream()
                .filter(t -> t.bookId.equals(bookId) && t.memberId.equals(memberId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Transaction missing"));
    }
}

