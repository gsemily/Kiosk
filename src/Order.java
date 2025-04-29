import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> orderList = new ArrayList<>();

    public Order() {
        this.orderList = new ArrayList<>();
    }

    //주문 추가
    public void addOrder(MenuItem menuItem) {
        orderList.add(menuItem);
    }

    //주문 내역 getter
    public List<MenuItem> getOrderList() {
        return orderList;
    }

    //수량
    public int getNumberOfOrders() {
        int number = 0;
        for(MenuItem menuItem : orderList) {
            number++;
        }
        return number;
    }

    //가격
    public double getTotalPrice() {
        double price = 0;
        for(MenuItem menuItem : orderList) {
            price += menuItem.getPrice();
        }
        return price;
    }

    //주문취소
    public void cancelOrder() {
        orderList.clear();
    }

    //주문내역 출력
    public void showOrder() {
        for(MenuItem menuItem : orderList) {
            System.out.println(menuItem.showItem());
        }
    }
}
