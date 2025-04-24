import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuItem menu;
        List<MenuItem> menuItems = new ArrayList<>();

        menu = new MenuItem("Shackburger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItems.add(menu);
        menu = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItems.add(menu);
        menu = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItems.add(menu);
        menu = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(menu);

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