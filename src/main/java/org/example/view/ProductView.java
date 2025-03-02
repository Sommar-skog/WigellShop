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
            } try {
                option = INPUT.nextInt();
                if (option > 0 && option < options.size()){
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
