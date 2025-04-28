import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();

        //햄버거 카테고리 생성
        Menu burgerMenu = new Menu("Burgers");
        menuList.add(burgerMenu);
        //햄버거 객체 생성
        MenuItem burger;
        burger = new MenuItem("Shackburger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgerMenu.addMenuItem(burger);
        burger = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgerMenu.addMenuItem(burger);
        burger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgerMenu.addMenuItem(burger);
        burger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        burgerMenu.addMenuItem(burger);

        //음료 카테고리 생성
        Menu drinkMenu = new Menu("Drinks");
        menuList.add(drinkMenu);
        //음료 객체 생성
        MenuItem drink;
        drink = new MenuItem("Coca-Cola", 2.9, "갈증해소 뿐만 아니라 기분까지 상쾌하게");
        drinkMenu.addMenuItem(drink);
        drink = new MenuItem("Sprite", 2.9, "청량함에 레몬, 라임향을 더한 시원함");
        drinkMenu.addMenuItem(drink);
        drink = new MenuItem("Fanta", 2.9, "톡 쏘는 오렌지 향");
        drinkMenu.addMenuItem(drink);

        //디저트 카테고리 생성
        Menu dessertMenu = new Menu("Desserts");
        menuList.add(dessertMenu);
        //디저트 객체 생성
        MenuItem dessert;
        dessert = new MenuItem("Classic Hand-Spun Shakes", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크");
        dessertMenu.addMenuItem(dessert);
        dessert = new MenuItem("Floats", 6.8, "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료");
        dessertMenu.addMenuItem(dessert);
        dessert = new MenuItem("Shack Attack", 6.2, "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 대표 콘크리트");
        dessertMenu.addMenuItem(dessert);
        dessert = new MenuItem("Honey Butter Crunch", 6.2, "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트");
        dessertMenu.addMenuItem(dessert);

        //Kiosk 객체 생성 및 실행
        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}