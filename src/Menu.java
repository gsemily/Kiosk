import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String category){
        this.category = category;
    }

    //카테고리 getter
    public String getCategory() {
        return category;
    }

    //메뉴리스트 getter
    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    //메뉴리스트 추가
    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }

    //카테고리 출력
    public void show(){
        int number = 1;
        for (MenuItem item : menuItems) {
            System.out.println(number + ". " + item.showItem());
            number++;
        }
    }
}
