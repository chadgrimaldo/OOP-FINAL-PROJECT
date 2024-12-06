import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartShare {
    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<BorrowRecord> borrowedItems = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public SmartShare() {
        initializeItems();
    }

    private void initializeItems() {
        items.add(new Item("Laptop", "New", true));
        items.add(new Item("Tablet", "Used", true));
        items.add(new Item("Scientific Calculator", "New", true));
        items.add(new Item("USB Flash Drive", "New", true));
        items.add(new Item("Power Bank", "Used", true));
        items.add(new Item("Charger", "New", true));
        items.add(new Item("Printer", "Used", true));
    }

    private String getValidNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your school: ");
        String school = scanner.nextLine();
        String phone = getValidNumber("Enter your phone number: ");
        users.add(new User(name, email, school, phone));
        System.out.println("Registration successful!");
    }

    private void listItems() {
        System.out.println("\nAvailable Gadgets:");
        int index = 1;
        for (Item item : items) {
            if (item.isAvailable()) {
                System.out.printf("%d. %s (%s)%n", index++, item.getName(), item.getCondition());
            }
        }
    }

    private int selectDuration() {
        int[] durations = {1, 2, 3, 7, 30};
        System.out.println("\nSelect borrowing duration:");
        for (int i = 0; i < durations.length; i++) {
            System.out.printf("%d. %d days%n", i + 1, durations[i]);
        }
        while (true) {
            try {
                System.out.print("Enter duration number: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= durations.length) {
                    return durations[choice - 1];
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void borrowItem() {
        listItems();
        try {
            System.out.print("Select gadget number to borrow: ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < items.size() && items.get(choice).isAvailable()) {
                int duration = selectDuration();

                // Inform user about the penalty
                System.out.println("\nNote: If you return the gadget late, the penalty is ₱50 per day, up to a maximum of ₱1000.");
                System.out.print("Do you want to proceed with borrowing? (yes/no): ");
                String confirm = scanner.nextLine().trim().toLowerCase();

                if (confirm.equals("yes")) {
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    LocalDate borrowDate = LocalDate.now();
                    LocalDate returnDate = borrowDate.plusDays(duration);

                    BorrowRecord record = new BorrowRecord(email, items.get(choice), borrowDate, returnDate, false, 0);
                    borrowedItems.add(record);
                    items.get(choice).setAvailable(false);

                    System.out.printf("\n%s borrowed successfully!%n", items.get(choice).getName());
                    System.out.printf("Borrow Date: %s%n", borrowDate);
                    System.out.printf("Return Date: %s%n", returnDate);
                } else {
                    System.out.println("Borrowing cancelled.");
                }
            } else {
                System.out.println("Invalid choice or item not available.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private int calculatePenalty(LocalDate returnDate) {
        long overdueDays = ChronoUnit.DAYS.between(returnDate, LocalDate.now());
        return overdueDays > 0 ? (int) Math.min(overdueDays * 50, 1000) : 0;
    }

    private void viewBorrowHistory() {
        System.out.print("Enter your email to view history: ");
        String email = scanner.nextLine().trim().toLowerCase();
        User user = users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("\nUser Details:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("School: " + user.getSchool());
        System.out.println("Phone number: " + user.getPhone());

        System.out.println("\nBorrowing History:");
        for (BorrowRecord record : borrowedItems) {
            if (record.getUserEmail().equalsIgnoreCase(email)) {
                int penalty = calculatePenalty(record.getReturnDate());
                System.out.printf("%s - %s%n", record.getItem().getName(), record.isReturned() ? "Returned" : "Borrowed");
                System.out.printf("  Borrowed On: %s%n", record.getBorrowDate());
                System.out.printf("  Return By: %s%n", record.getReturnDate());
                System.out.printf("  Penalty: ₱%d%n", penalty);
            }
        }
    }

    private void returnItem() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        List<BorrowRecord> borrowed = new ArrayList<>();
        for (BorrowRecord record : borrowedItems) {
            if (record.getUserEmail().equalsIgnoreCase(email) && !record.isReturned()) {
                borrowed.add(record);
            }
        }

        if (borrowed.isEmpty()) {
            System.out.println("No items to return.");
            return;
        }

        for (int i = 0; i < borrowed.size(); i++) {
            BorrowRecord record = borrowed.get(i);
            System.out.printf("%d. %s - Due on %s%n", i + 1, record.getItem().getName(), record.getReturnDate());
        }

        try {
            System.out.print("Select the item number to return: ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            if (choice >= 0 && choice < borrowed.size()) {
                BorrowRecord record = borrowed.get(choice);
                record.setReturned(true);
                int penalty = calculatePenalty(record.getReturnDate());
                record.setPenalty(penalty);
                record.getItem().setAvailable(true);
                System.out.printf("%s returned successfully! Penalty: ₱%d%n", record.getItem().getName(), penalty);
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== SmartShare Menu =====");
            System.out.println("1. Registration");
            System.out.println("2. List of Available Gadgets");
            System.out.println("3. Borrow a Gadget");
            System.out.println("4. View Borrowing History");
            System.out.println("5. Return a Gadget");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    listItems();
                    break;
                case "3":
                    borrowItem();
                    break;
                case "4":
                    viewBorrowHistory();
                    break;
                case "5":
                    returnItem();
                    break;
                case "6":
                    System.out.println("Thank you for using SmartShare!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        SmartShare app = new SmartShare();
        app.mainMenu();
    }
}


