import java.util.*;

public class Restaurant {

    private List<MenuItem> menu = new ArrayList<>();
    private final double GST = 0.05;

    // Add item dynamically
    public void addItem(MenuItem item) {
        menu.add(item);
    }

    // Remove item dynamically
    public void removeItem(int id) {
        menu.removeIf(item -> item.getId() == id);
    }

    // Show menu
    public void showMenu() {
        System.out.println("\n----- MENU -----");
        for (MenuItem item : menu) {
            System.out.println(item.getId() + ". " + item.getName() + " - ₹" + item.getPrice());
        }
    }

    // Get item by ID
    public MenuItem getItem(int id) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Generate bill
    public void generateBill(Map<MenuItem, Integer> order) {

        double subtotal = 0;

        System.out.println("\n===== ITEMIZED RECEIPT =====");

        for (Map.Entry<MenuItem, Integer> entry : order.entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();

            double total = item.getPrice() * qty;
            subtotal += total;

            System.out.println(item.getName() + " x " + qty + " = ₹" + total);
        }

        double gstAmount = subtotal * GST;
        double finalTotal = subtotal + gstAmount;

        System.out.println("----------------------------");
        System.out.println("Subtotal: ₹" + subtotal);
        System.out.println("GST (5%): ₹" + gstAmount);
        System.out.println("Total Payable: ₹" + finalTotal);
        System.out.println("============================\n");
    }
}