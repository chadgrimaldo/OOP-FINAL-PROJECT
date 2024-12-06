import java.time.LocalDate;

public class BorrowRecord {
    private final String userEmail;
    private final Item item;
    private final LocalDate borrowDate;
    private final LocalDate returnDate;
    private boolean returned;
    private int penalty;

    public BorrowRecord(String userEmail, Item item, LocalDate borrowDate, LocalDate returnDate, boolean returned, int penalty) {
        this.userEmail = userEmail;
        this.item = item;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returned = returned;
        this.penalty = penalty;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Item getItem() {
        return item;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
