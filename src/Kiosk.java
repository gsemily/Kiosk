import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menu;

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
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

            //사용자 입력
            int categoryChoice = -1;
            while(true) {
                System.out.print("> ");
                categoryChoice = scanner.nextInt();

                if(categoryChoice < 0 || categoryChoice > menu.size())
                    System.out.println("존재하지 않는 카테고리입니다.");
                else break;
            }
            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            //하위 메뉴 출력
            Menu selectedMenu = menu.get(categoryChoice - 1);
            System.out.println("[ " + menu.get(categoryChoice - 1).getCategory().toUpperCase() + " MENU ]");
            selectedMenu.show();
            System.out.println("0. 뒤로가기");

            //사용자 입력
            int itemChoice = -1;
            while(true) {
                System.out.print("> ");
                itemChoice = scanner.nextInt();

                if(itemChoice < 0 || itemChoice > selectedMenu.getMenuItems().size()) {
                    System.out.println("존재하지 않는 주문번호입니다.");
                }else break;
            }
            if (itemChoice == 0) {
                continue;
            }

            //선택 메뉴 출력
            MenuItem selectedItem = selectedMenu.getMenuItems().get(itemChoice - 1);
            System.out.println("선택한 메뉴: " + selectedItem.show());
            break;
        }
    }
}
