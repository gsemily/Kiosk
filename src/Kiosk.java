import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menu;
    private Order order;
    private Scanner scanner = new Scanner(System.in);

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
        this.order = new Order();
    }

    //키오스크 프로그램 실행
    public void start() {
        while (true) {
            showMainMenu();
            int option = inputCondition(0, menu.size() + 2);

            if (option == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (option >= 1 && option <= menu.size()) {
                addToOrder(option);
            } else if (option == 4) {
                processOrder();
            } else if (option == 5) {
                 processCancel();
            } else
                System.out.println("올바른 번호를 입력하십시오.");
            }
    }

    //메인 메뉴 출력
    private void showMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getCategory());
        }
        System.out.println("0. 종료");

        //장바구니에 주문이 있을 시 주문창 띄우기
        if (!order.getOrderList().isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel      | 진행중인 주문을 취소합니다.");
        }
    }

    //하위 메뉴 출력하고 장바구니에 주문 추가 여부 묻기
    private void addToOrder(int input){
        Menu selectedMenu = menu.get(input - 1);
        System.out.println("[ " + menu.get(input - 1).getCategory().toUpperCase() + " MENU ]");
        selectedMenu.show(); //하위 메뉴 출력
        System.out.println("0. 뒤로가기");

        //메뉴 선택
        int option = inputCondition(0, selectedMenu.getMenuItems().size());

        //선택 메뉴 출력
        MenuItem selectedItem = selectedMenu.getMenuItems().get(option - 1);
        System.out.println("선택한 메뉴: " + selectedItem.showItem() + "\n");
        System.out.println("\"" + selectedItem.showItem() + "\"");

        //장바구니 추가 여부 묻기
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인         2. 취소");
        int answer = inputCondition(1, 2);
        if (answer == 1) {
            order.addOrder(selectedItem);
            System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다." + "\n");
        }
    }

    //주문 진행하기
    private void processOrder(){
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("\n[ Orders ]");
        System.out.println(order.show()); // 장바구니 목록 출력
        System.out.printf("\n[ Total ]\nW %.1f\n", order.getTotalPrice(CustomerType.REGULAR));
        System.out.println("1. 주문       2. 메뉴판");

        //주문
        int option = inputCondition(1, 2);
        if (option == 1) {
            System.out.println("\n할인 정보를 입력해주세요.");
            System.out.println("1. 국가유공자 : 10% \n2. 군인     :  5%\n3. 학생     :  3%\n4. 일반     :  0%");
            int type = inputCondition(1, 4);

            CustomerType customerType = CustomerType.values()[type - 1];
            double discountPrice = order.getTotalPrice(customerType); //사용자 유형에 따른 할인율 적용

            System.out.printf("\n주문이 완료되었습니다. 금액은 W %.1f 입니다.\n\n", discountPrice);
            order.cancelOrder();  // 장바구니 초기화
        }
    }

    //주문 취소하기
    private void processCancel(){
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1. 모든 주문 취소\n2. 특정 주문 취소\n3. 취소");
        int option;

        //사용자 입력에 따른 주문 취소 진행
        while(true) {
            System.out.print("> ");
            option = scanner.nextInt();
            if (option < 0 || option > 4){
                System.out.println("올바른 번호를 입력하십시오.");
            }else if(option == 1){
                order.cancelOrder(); //모든 주문 취소
                System.out.println("모든 주문이 취소되었습니다.\n");
                break;
            }else if(option == 2){
                if(order.getOrderList().isEmpty()){
                    System.out.println("삭제할 메뉴가 없습니다.\n");
                    return;
                }
                System.out.println("[ 장바구니 목록 ]");
                for(int i = 0; i<order.getOrderList().size(); i++){
                    System.out.println((i + 1)+ ". " + order.getOrderList().get(i).showItem());
                }
                System.out.println("0. 취소");
                System.out.print("삭제할 메뉴 번호를 입력하십시오");
                int removeNum = inputCondition(0, order.getOrderList().size());
                if(removeNum == 0){
                    continue;
                } else {
                    String removeName = order.getOrderList().get(removeNum - 1).getName();
                    order.removeMenu(removeName);
                    System.out.println(removeName + "이 장바구니에서 제거되었습니다.\n");
                    break;
                }
            }else if(option == 3){
                break; //취소 수행하지 않음
            }
        }
    }

    //입력값이 올바른지 판단하기
    private int inputCondition(int min, int max){
        int answer;
        while(true){
            try{
                System.out.print("> ");
                answer = scanner.nextInt();
                if(answer < min || answer > max){
                    System.out.println("올바른 번호를 입력하십시오.");
                    continue;
                }else break;
            }catch (InputMismatchException e){
                System.out.println("올바른 숫자를 입력하십시오.");
                scanner.nextLine();
            }
        }
        return answer;
    }
}
