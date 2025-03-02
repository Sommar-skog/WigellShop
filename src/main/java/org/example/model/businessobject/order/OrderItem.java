package org.example.model.businessobject.order;

import org.example.model.businessobject.product.enums.ProductSpecification;

import java.util.List;

public class OrderItem {
    private String productType;
    private List<ProductSpecification> specificationList;

    public OrderItem(String productType, List<ProductSpecification> specificationList) {
        this.productType = productType;
        this.specificationList = specificationList;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public List<ProductSpecification> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<ProductSpecification> specificationList) {
        this.specificationList = specificationList;
    }
}
