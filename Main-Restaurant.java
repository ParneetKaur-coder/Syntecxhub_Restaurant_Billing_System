import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        // Initial menu
        restaurant.addItem(new MenuItem(1, "Burger", 120));
        restaurant.addItem(new MenuItem(2, "Pizza", 250));
        restaurant.addItem(new MenuItem(3, "Pasta", 180));

        Map<MenuItem, Integer> order = new LinkedHashMap<>();

        while (true) {

            System.out.println("\n====== RESTAURANT SYSTEM ======");
            System.out.println("1. Show Menu");
            System.out.println("2. Add Menu Item (Admin)");
            System.out.println("3. Remove Menu Item (Admin)");
            System.out.println("4. Order Item");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    restaurant.showMenu();
                    break;

                case 2:
                    System.out.print("Enter item id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    restaurant.addItem(new MenuItem(id, name, price));
                    System.out.println("Item added successfully!");
                    break;

                case 3:
                    System.out.print("Enter item id to remove: ");
                    int removeId = sc.nextInt();
                    restaurant.removeItem(removeId);
                    System.out.println("Item removed!");
                    break;

                case 4:
                    restaurant.showMenu();
                    System.out.print("Enter item id to order: ");
                    int orderId = sc.nextInt();

                    MenuItem item = restaurant.getItem(orderId);

                    if (item != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        order.put(item, order.getOrDefault(item, 0) + qty);
                        System.out.println("Item added to order!");
                    } else {
                        System.out.println("Invalid item ID!");
                    }
                    break;

                case 5:
                    restaurant.generateBill(order);
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}