import java.util.*;

// Product Class
class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name  = name.toLowerCase();
        this.category = category.toLowerCase();
        this.price = price;
    }

    public void display() {
        System.out.println("Product Name: " + name + ", Category: " + category + ", Price: " + price);
    }
}

public class exercise3 {
    // List to store all Products
    static List<Product> products = new ArrayList<>();

    // Map to Link Categories to Products
    static Map<String, HashSet<Product>> catMap = new HashMap<>();

    public static void addSampleProducts() {
        addProduct(new Product("P1", "C1", 79999));
        addProduct(new Product("P2", "C1", 59999));
        addProduct(new Product("P3", "C2", 4999));
        addProduct(new Product("P4", "C2", 2999));
        addProduct(new Product("P5", "C3", 39999));
    }

    // Adds Products to list and catMap
    public static void addProduct(Product p) {
        products.add(p);
        catMap.computeIfAbsent(p.category, k -> new HashSet<>()).add(p);
    }

    // Search Product by Name (Linear Search)
    public static void searchByName(String name) {
        System.out.println("Search Products by Product Name: " + name);
        boolean foundProd = false;

        for (Product product : products) {
            if (product.name.contains(name.toLowerCase())) {
                product.display();
                foundProd = true;
            }
        }

        if (!foundProd) {
            System.out.println("Product not found");
        }
    }

    // Search by Category (using HashMap)
    public static void searchByCategory(String category) {
        System.out.println("Search Products for Category: " + category);
        HashSet<Product> catProducts = catMap.get(category.toLowerCase());

        if (catProducts != null && !catProducts.isEmpty()) {
            for (Product product : catProducts) {
                product.display();
            }
        } else {
            System.out.println("No products found in this category.");
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addSampleProducts();

        while (true) {
            System.out.println("E-Commerce Product Search");
            System.out.println("1. Search by Product Name");
            System.out.println("2. Search by Category");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }


            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name (P1 to P5): ");
                    String name = scanner.nextLine();
                    searchByName(name);
                    break;
                case 2:
                    System.out.print("Enter Category (C1 to C3): ");
                    String category = scanner.nextLine();
                    searchByCategory(category);
                    break;
                case 0:
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}