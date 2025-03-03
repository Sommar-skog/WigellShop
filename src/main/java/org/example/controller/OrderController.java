package org.example.controller;


import org.example.model.businessobject.order.Order;
import org.example.model.businessobject.order.OrderItem;
import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.Skirt;
import org.example.model.businessobject.product.TShirt;
import org.example.model.businessobject.product.builder.PantsBuilder;
import org.example.model.businessobject.product.builder.SkirtBuilder;
import org.example.model.businessobject.product.builder.TShirtBuilder;
import org.example.model.businessobject.product.command.*;
import org.example.model.businessobject.product.enums.*;
import org.example.model.singleton.OrderService;
import org.example.view.MenuView;
import org.example.view.OrderView;
import org.example.view.ProductView;

import java.util.ArrayList;
import java.util.List;


public class OrderController {

    private final ProductView PRODUCT_VIEW;
    private final OrderView ORDER_VIEW;
    private final MenuView MENU_VIEW;
    private final MainController MAIN_CONTROLLER;
    private  Order order;

    public OrderController(MainController mainController) {
        this.MAIN_CONTROLLER = mainController;
        MENU_VIEW = mainController.getMENU_VIEW();
        ORDER_VIEW = new OrderView();
        PRODUCT_VIEW = mainController.getPRODUCT_CONTROLLER().getPRODUCT_VIEW();
    }


    public void order(){
        System.out.println("            - - - ORDER - - -");
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

        placeOrder(OrderService.getInstance().getItemsToOrderList());
        ORDER_VIEW.printOrderReadyNow();


    }

    private void placeOrder(List<OrderItem> orderItems){
        order = MAIN_CONTROLLER.getCurrentOrder();
        List<Product> orderList = order.getProductList();

        for (OrderItem orderItem : orderItems) {
            SewingProcessingPipeline pipeline = new SewingProcessingPipeline();

            List<ProductSpecification> specifications = orderItem.getSpecificationList();
            ProductSpecification size = specifications.get(0);
            ProductSpecification material = specifications.get(1);
            ProductSpecification color = specifications.get(2);
            ProductSpecification customOption1 = specifications.get(3);
            ProductSpecification customOption2 = specifications.get(4);

            switch (orderItem.getProductType()) {
                case "Pants":
                    PantsBuilder pb = new PantsBuilder();
                    Pants p = (Pants) pb.addSize((ClothingSize) size).addColor((ClothingColor) color).addMaterial((ClothingMaterial) material).build();
                    pipeline.addCommand(new FitCommand(), (PantsFit) customOption1);
                    pipeline.addCommand(new LengthCommand(), (PantsLength) customOption2);
                    pipeline.execute(p);
                    orderList.add(p);
                    break;
                case "TShirt":
                    TShirtBuilder tb = new TShirtBuilder();
                    TShirt t = (TShirt) tb.addSize((ClothingSize) size).addColor((ClothingColor) color).addMaterial((ClothingMaterial) material).build();
                    pipeline.addCommand(new SleevesCommand(), (TShirtSleeves) customOption1);
                    pipeline.addCommand(new NeckCommand(), (TShirtNeck) customOption2);
                    pipeline.execute(t);
                    orderList.add(t);
                    break;
                case "Skirt":
                    SkirtBuilder sb = new SkirtBuilder();
                    Skirt s = (Skirt) sb.addSize((ClothingSize) size).addColor((ClothingColor) color).addMaterial((ClothingMaterial) material).build();
                    pipeline.addCommand(new WaistlineCommand(), (SkirtWaistline) customOption1);
                    pipeline.addCommand(new PatternCommand(), (SkirtPattern) customOption2);
                    pipeline.execute(s);
                    orderList.add(s);
                    break;
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

    public OrderView getORDER_VIEW() {
        return ORDER_VIEW;
    }
}
