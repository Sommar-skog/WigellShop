package org.example.controller;


import org.example.model.businessobject.order.Order;
import org.example.model.businessobject.order.OrderItem;
import org.example.model.businessobject.product.Pants;
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

    private final ProductView productView;
    private final OrderView orderView;
    private final MenuView menuView;
    private final MainController mainController;
    private  Order order;

    public OrderController(MainController mainController) {
        this.mainController = mainController;
        menuView = mainController.getMenuView();
        orderView = new OrderView();
        productView = mainController.getProductController().getProductView();
    }


    public void order(){
        orderView.printOrderTitle();

        boolean readyForProduction = false;
        while(!readyForProduction) {
            int choice = menuView.printProductChoice();
            boolean buyMore = false;
            switch (choice) {
                case 1:
                    // Pants
                    ProductSpecification pantsSize = productView.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification pantsMaterial = productView.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification pantsColor = productView.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification fit = productView.printProductOptionsMenu(PantsFit.values());
                    ProductSpecification length = productView.printProductOptionsMenu(PantsLength.values());
                    holdProductUntilOrder("Pants",pantsSize, pantsMaterial, pantsColor, fit, length);
                    break;
                case 2:
                    // T-shirt
                    ProductSpecification tShirtSize = productView.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification tShirtMaterial = productView.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification tShirtColor = productView.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification sleeves = productView.printProductOptionsMenu(TShirtSleeves.values());
                    ProductSpecification neck = productView.printProductOptionsMenu(TShirtNeck.values());
                    holdProductUntilOrder("TShirt", tShirtSize, tShirtMaterial, tShirtColor, sleeves, neck);
                    break;
                case 3:
                    // skirt
                    ProductSpecification skirtSize = productView.printProductOptionsMenu(ClothingSize.values());
                    ProductSpecification skirtMaterial = productView.printProductOptionsMenu(ClothingMaterial.values());
                    ProductSpecification skirtColor = productView.printProductOptionsMenu(ClothingColor.values());
                    ProductSpecification waistline = productView.printProductOptionsMenu(SkirtWaistline.values());
                    ProductSpecification pattern = productView.printProductOptionsMenu(SkirtPattern.values());
                    holdProductUntilOrder("Skirt", skirtSize, skirtMaterial, skirtColor, waistline, pattern);
                    break;
            }

            buyMore = productView.printOrderMoreProductsQuestion();

            if (buyMore){
                readyForProduction = true;
            }
        }
        productView.printProductOverViewBeforeProduction(OrderService.getInstance().getItemsToOrderList());

        placeOrder(OrderService.getInstance().getItemsToOrderList());
        OrderService.getInstance().removeAllItemsFromOrderList();
        orderView.printOrderReadyNow();
    }

    private void placeOrder(List<OrderItem> orderItems){
        order = mainController.getCurrentOrder();

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
                    pipeline.addCommand(new FitCommand(), customOption1);
                    pipeline.addCommand(new LengthCommand(), customOption2);
                    pipeline.execute(p);
                    order.addProduct(p);
                    break;
                case "TShirt":
                    TShirtBuilder tb = new TShirtBuilder();
                    TShirt t = (TShirt) tb.addSize((ClothingSize) size).addColor((ClothingColor) color).addMaterial((ClothingMaterial) material).build();
                    pipeline.addCommand(new SleevesCommand(), customOption1);
                    pipeline.addCommand(new NeckCommand(), customOption2);
                    pipeline.execute(t);
                    order.addProduct(t);
                    break;
                case "Skirt":
                    SkirtBuilder sb = new SkirtBuilder();
                    Skirt s = (Skirt) sb.addSize((ClothingSize) size).addColor((ClothingColor) color).addMaterial((ClothingMaterial) material).build();
                    pipeline.addCommand(new WaistlineCommand(), customOption1);
                    pipeline.addCommand(new PatternCommand(), customOption2);
                    pipeline.execute(s);
                    order.addProduct(s);
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

    public Order getOrder() {
        return order;
    }

    public OrderView getOrderView() {
        return orderView;
    }
}
