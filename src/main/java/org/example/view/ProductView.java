package org.example.view;


import org.example.model.businessobject.order.OrderItem;
import org.example.model.businessobject.product.enums.ProductSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductView {

    private final Scanner INPUT = new Scanner(System.in);
    private final OrderView ORDER_VIEW = new OrderView();


    public void printProduct(String product) { //skicka in .toString
        System.out.println(product);
    }

    public void printProductOverViewBeforeProduction(List<OrderItem> items) {
        System.out.println();
        System.out.println("Overview of your chosen products: ");
        System.out.println();
        for (OrderItem item : items) {
            System.out.print(item.getProductType() + " [");

            List<ProductSpecification> spec = item.getSpecificationList();

            for (int i = 0; i < spec.size(); i++) {
                System.out.print(spec.get(i));
                if (i < spec.size() - 1) {
                    System.out.print(", ");
                }

            }
            System.out.println("]");
        }
        System.out.println();
        ORDER_VIEW.printPlacingOrderNow();
    }

    public boolean printOrderMoreProductsQuestion(){
        System.out.println();
        while (true) {
            System.out.print("Would you like to add one more product to your order before production? (Y/N): ");
            String answer = INPUT.nextLine().toLowerCase().trim();
            if (answer.equals("y")) {
                return false;
            } else if (answer.equals("n")) {
                return true;
            } else {
                System.out.println("Please enter a valid option (Y/N)");
            }
        }
    }


    public ProductSpecification printProductOptionsMenu(ProductSpecification[] productSpecification) {
        List<String> options = convertEnumValuesToStringValues(productSpecification);
        int option;
        boolean validOption = false;
        ProductSpecification productSpec = null;
        while (!validOption) {
            System.out.println();
            System.out.println("Choose an option");
            int count = 1;
            for (String o : options){
                System.out.println(count + ": " + o);
                count++;
            }
            System.out.print("Choose an option (integer): ");
            try {
                option = INPUT.nextInt();
                INPUT.nextLine();
                if (option > 0 && option <= options.size()){
                    validOption = true;
                    productSpec = productSpecification[option - 1];
                } else {
                    System.out.println("Invalid choice, try again");
                }

            } catch (Exception e) {
                INPUT.nextLine();
                System.out.println("Invalid input, try again");
            }
        }
        return productSpec;
    }

    private List<String> convertEnumValuesToStringValues(ProductSpecification[] specifications) {
        return Arrays.stream(specifications).map(Object::toString).collect(Collectors.toList());
    }
}
