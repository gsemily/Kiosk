public class MenuItem{
    private String name;
    private String description;
    private double price;

    //생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //메뉴 출력
    public String showItem() {
        return String.format("%-30s | W %.1f | %s", name, price, description);
    }
}
