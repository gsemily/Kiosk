import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menu;
    private Order order;

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
        this.order = new Order();
    }

    //키오스크 프로그램 실행
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            int number = 1;
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(number + ". " + menu.get(i).getCategory());
                number++;
            }
            System.out.println("0. 종료");

            //주문창
            if (!order.getOrderList().isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel      | 진행중인 주문을 취소합니다.");
            }

            //사용자 입력
            int categoryChoice;
            while (true) {
                System.out.print("> ");
                categoryChoice = scanner.nextInt();

                if (categoryChoice < 0 || categoryChoice > 5)
                    System.out.println("존재하지 않는 카테고리입니다.");
                else break;
            }

            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (categoryChoice == 4) {
                System.out.println("아래와 같이 주문하시겠습니까?");
                System.out.println("\n[ Orders ]");
                order.showOrder();
                System.out.println("[ Total ]\nW " + order.getTotalPrice());
                System.out.println("1. Order       2. Cancel");
                System.out.print("> ");

                //주문
                int orderAnswer = scanner.nextInt();
                if (orderAnswer == 1) {
                    System.out.println("주문이 완료되었습니다. 금액은 W " + order.getTotalPrice() + "입니다.");
                    order.cancelOrder();  // 장바구니 초기화
                    continue;
                } else if (orderAnswer == 2) {
                    continue;
                }
            } else if (categoryChoice == 5) {
                System.out.println("주문을 취소하시겠습니까?");
                System.out.println("1. Remove       2. Cancel");
                System.out.println("> ");

                int cancelAnswer = scanner.nextInt();
                if (cancelAnswer == 1) {
                    order.cancelOrder(); // 장바구니 초기화
                    System.out.println("주문이 취소되었습니다.");
                } else if (cancelAnswer == 2) {
                    continue;
                }
            }

            //하위 메뉴 출력
            Menu selectedMenu = menu.get(categoryChoice - 1);
            System.out.println("[ " + menu.get(categoryChoice - 1).getCategory().toUpperCase() + " MENU ]");
            selectedMenu.show();
            System.out.println("0. 뒤로가기");

            //사용자 입력
            int itemChoice = -1;
            while (true) {
                System.out.print("> ");
                itemChoice = scanner.nextInt();

                if (itemChoice < 0 || itemChoice > selectedMenu.getMenuItems().size()) {
                    System.out.println("존재하지 않는 주문번호입니다.");
                } else break;
            }
            if (itemChoice == 0) {
                continue;
            }

            //선택 메뉴 출력
            MenuItem selectedItem = selectedMenu.getMenuItems().get(itemChoice - 1);
            System.out.println("선택한 메뉴: " + selectedItem.showItem() + "\n");
            System.out.println("\"" + selectedItem.showItem() + "\"");
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인         2. 취소");

            int orderCheck;
            while (true) {
                System.out.print("> ");
                orderCheck = scanner.nextInt();

                if (orderCheck < 1 || orderCheck > 2) {
                    System.out.println("올바른 번호를 입력하십시오.");
                } else break;
            }

            //장바구니 추가
            if (orderCheck == 1) {
                order.addOrder(selectedItem);
                System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다." + "\n");
                continue;
            }
        }
    }
}
