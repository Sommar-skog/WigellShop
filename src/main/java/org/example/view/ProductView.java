package org.example.view;


import org.example.model.businessobject.product.enums.ClothingSize;
import org.example.model.businessobject.product.enums.ProductSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductView {

    private final Scanner INPUT = new Scanner(System.in);


    public void printProduct(String product) { //skicka in .toString
        System.out.println(product);
    }

    public void printProductOverViewBeforeProduction(String typeOfProduct, String size, String material, String color, String customOption1, String customOption2) {
        System.out.println();
        System.out.println("Overview of your chosen product: \n" +
                typeOfProduct + "[" + size + ", " + material + ", " + color + ", " + customOption1 + ", " + customOption2 + "]");


    }

    public boolean printOrderMoreProductsQuestion(){
        System.out.println();
        while (true) {
            System.out.print("Would you like to add one more product to your order before production? (Y/N): ");
            if (INPUT.nextLine().toLowerCase().equals("y")) {
                return true;
            } else if (INPUT.nextLine().toLowerCase().equals("n")) {
                return false;
            } else {
                INPUT.nextLine();
                System.out.println("Please enter a valid option");
            }
        }
    }


    public ProductSpecification printProductOptionsMenu(ProductSpecification[] productSpecification) {
        List<String> options = convertEnumValuesToStringValues(productSpecification);
        int option;
        while (true){
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
                if (option > 0 && option <= options.size()){
                    return productSpecification[option - 1];
                }
            } catch (Exception e) {
                INPUT.nextLine();
                System.out.println("Invalid input, try again");
            }
        }
    }

    private List<String> convertEnumValuesToStringValues(ProductSpecification[] specifications) {
        return Arrays.stream(specifications).map(Object::toString).collect(Collectors.toList());
    }
}
