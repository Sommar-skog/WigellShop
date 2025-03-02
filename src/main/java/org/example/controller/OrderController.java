package org.example.controller;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.example.model.businessobject.product.enums.*;
import org.example.view.MenuView;
import org.example.view.OrderView;
import org.example.view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private final ProductView PRODUCT_VIEW = new ProductView();
    private final OrderView ORDER_VIEW = new OrderView();
    private final MenuView MENU_VIEW = new MenuView();
    private List<String> productsToOrder = new ArrayList<>();
    private List<ProductSpecification> = new ArrayList<>();

    public void order(){
        System.out.println("Order");
        System.out.println();
        boolean readyForProduction = false;
        while(!readyForProduction) {
            int choice = MENU_VIEW.printProductChoice();
            boolean buyMore = false;
            switch (choice) {
                case 1:
                    // Pants
                    ProductSpecification pantsSize = PRODUCT_VIEW.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification pantsMaterial = PRODUCT_VIEW.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification pantsColor = PRODUCT_VIEW.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification fit = PRODUCT_VIEW.printProductOptionsMenu(PantsFit.values());
                    ProductSpecification length = PRODUCT_VIEW.printProductOptionsMenu(PantsLength.values());
                    PRODUCT_VIEW.printProductOverViewBeforeProduction("Pants", pantsSize.toString(), pantsMaterial.toString(), pantsColor.toString(), fit.toString(), length.toString());
                    holdProductUntilOrder("Pants",pantsSize, pantsMaterial, pantsColor, fit, length);
                    break;
                case 2:
                    // T-shirt
                    ProductSpecification tShirtSize = PRODUCT_VIEW.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification tShirtMaterial = PRODUCT_VIEW.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification tShirtColor = PRODUCT_VIEW.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification sleeves = PRODUCT_VIEW.printProductOptionsMenu(TShirtSleeves.values());
                    ProductSpecification neck = PRODUCT_VIEW.printProductOptionsMenu(TShirtNeck.values());
                    PRODUCT_VIEW.printProductOverViewBeforeProduction("T-shirt", tShirtSize.toString(), tShirtMaterial.toString(), tShirtColor.toString(), sleeves.toString(), neck.toString());
                    break;
                case 3:
                    // skirt
                    ProductSpecification skirtSize = PRODUCT_VIEW.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification skirtMaterial = PRODUCT_VIEW.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification skirtColor = PRODUCT_VIEW.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification waistline = PRODUCT_VIEW.printProductOptionsMenu(SkirtWaistline.values());
                    ProductSpecification pattern = PRODUCT_VIEW.printProductOptionsMenu(SkirtPattern.values());
                    PRODUCT_VIEW.printProductOverViewBeforeProduction("Skirt", skirtSize.toString(), skirtMaterial.toString(), skirtColor.toString(), waistline.toString(), pattern.toString());
                    break;
            }

            buyMore = PRODUCT_VIEW.printOrderMoreProductsQuestion();

            if (buyMore){
                readyForProduction = true;
            }
        }


    }

    public void holdProductUntilOrder(String type ,ProductSpecification size, ProductSpecification material, ProductSpecification color, ProductSpecification customOption1, ProductSpecification customOption2 ){
            StringBuilder productPlacementUntilOrder = new StringBuilder();
            productPlacementUntilOrder.append(type + ",").append(size + ",").append(material + ",").append(color + ",").append(customOption1 + ",").append(customOption2 + ",");
            productsToOrder.add(productPlacementUntilOrder.toString());
    }

    public void addProductsToOrder(ProductSpecification size, ProductSpecification material, ProductSpecification color, ProductSpecification customOption1, ProductSpecification customOption2 ){


    }

}
