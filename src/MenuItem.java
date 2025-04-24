public class MenuItem {
    private String name;
    private String description;
    private double price;

    //생성자
    MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String show() {
        return String.format("%-15s | W %.1f | %s", name, price, description);
    }
}
