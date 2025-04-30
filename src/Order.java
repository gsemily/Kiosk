import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<MenuItem> orderList = new ArrayList<>();

    //주문 추가
    public void addOrder(MenuItem menuItem) {
        orderList.add(menuItem);
    }

    //주문 내역 getter
    public List<MenuItem> getOrderList() {
        return orderList;
    }

    public void removeMenu(String name){
        List<MenuItem> filtered = orderList.stream()
                .filter(i -> !i.getName().equals(name))
                .collect(Collectors.toList());
        orderList.clear();
        orderList.addAll(filtered);
    }

    //가격
    public double getTotalPrice(CustomerType customerType) {
        double price = 0;
        for(MenuItem menuItem : orderList) {
            price += menuItem.getPrice();
        }
        return price * (1 - customerType.getDiscountRate());
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
