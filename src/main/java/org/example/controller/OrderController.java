package org.example.controller;


import org.example.model.businessobject.order.OrderItem;
import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.Skirt;
import org.example.model.businessobject.product.TShirt;
import org.example.model.businessobject.product.enums.*;
import org.example.model.singleton.OrderService;
import org.example.view.MenuView;
import org.example.view.OrderView;
import org.example.view.ProductView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {

    private final ProductView PRODUCT_VIEW = new ProductView();
    private final OrderView ORDER_VIEW = new OrderView();
    private final MenuView MENU_VIEW = new MenuView();



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
                    holdProductUntilOrder("Pants",pantsSize, pantsMaterial, pantsColor, fit, length);
                    break;
                case 2:
                    // T-shirt
                    ProductSpecification tShirtSize = PRODUCT_VIEW.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification tShirtMaterial = PRODUCT_VIEW.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification tShirtColor = PRODUCT_VIEW.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification sleeves = PRODUCT_VIEW.printProductOptionsMenu(TShirtSleeves.values());
                    ProductSpecification neck = PRODUCT_VIEW.printProductOptionsMenu(TShirtNeck.values());
                    holdProductUntilOrder("TShirt", tShirtSize, tShirtMaterial, tShirtColor, sleeves, neck);
                    break;
                case 3:
                    // skirt
                    ProductSpecification skirtSize = PRODUCT_VIEW.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification skirtMaterial = PRODUCT_VIEW.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification skirtColor = PRODUCT_VIEW.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification waistline = PRODUCT_VIEW.printProductOptionsMenu(SkirtWaistline.values());
                    ProductSpecification pattern = PRODUCT_VIEW.printProductOptionsMenu(SkirtPattern.values());
                    holdProductUntilOrder("Skirt", skirtSize, skirtMaterial, skirtColor, waistline, pattern);
                    break;
            }

            buyMore = PRODUCT_VIEW.printOrderMoreProductsQuestion();

            if (buyMore){
                readyForProduction = true;
            }
        }
        PRODUCT_VIEW.printProductOverViewBeforeProduction(OrderService.getInstance().getItemsToOrderList());
    }

    public void PlaceOrder(List<OrderItem> orderItems){
        Map<String, Product> productMap = new HashMap<>();
        for (OrderItem orderItem : orderItems) {
           if (orderItem.getProductType().equals("Pants")){

            } else if (orderItem.getProductType().equals("TShirt")){

           } else if (orderItem.getProductType().equals("Skirt")){

           }
        }

    }

    public void holdProductUntilOrder(String type ,ProductSpecification size, ProductSpecification material, ProductSpecification color, ProductSpecification customOption1, ProductSpecification customOption2 ){
        List<ProductSpecification> specificationList = new ArrayList<>();
        specificationList.add(size);
        specificationList.add(material);
        specificationList.add(color);
        specificationList.add(customOption1);
        specificationList.add(customOption2);

        OrderItem orderItem = new OrderItem(type,specificationList);
        OrderService.getInstance().addItemToOrderList(orderItem);
    }



}
