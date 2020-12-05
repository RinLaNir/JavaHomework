package task_5_7;

public class Equipment extends Item{
    private String type;

    public Equipment(String type, double price, double weight) {
        super(price, weight);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
