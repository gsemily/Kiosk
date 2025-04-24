import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems = new ArrayList<>();

    Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("[ SHAKESHACK MENU ]");
        int number = 1;
        for(MenuItem s:menuItems){
            System.out.print(number + ". ");
            System.out.println(s.show());
            number++;
        }
        System.out.println("0. 종료");

        while(true){
            System.out.print("> ");
            int answer = scanner.nextInt();

            switch(answer){
                case 1 -> System.out.println("메뉴 1번입니다 : ShackBurger");
                case 2 -> System.out.println("메뉴 2번입니다 : SmokeShack");
                case 3 -> System.out.println("메뉴 3번입니다 : Cheeseburger");
                case 4 -> System.out.println("메뉴 4번입니다 : Hamburger");
                case 0 -> {
                    System.out.println("프로그램을 종료합니다");
                    return;
                }
                default -> System.out.println("존재하지 않는 주문번호입니다.");
            }
        }
    }
}
