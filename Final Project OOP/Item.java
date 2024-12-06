public class Item {
    private final String name;
    private final String condition;
    private boolean available;

    public Item(String name, String condition, boolean available) {
        this.name = name;
        this.condition = condition;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
