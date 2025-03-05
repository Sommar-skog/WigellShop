package org.example.model.businessobject.product.builder;

import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Product;
import org.example.model.businessobject.product.enums.ClothingColor;
import org.example.model.businessobject.product.enums.ClothingMaterial;
import org.example.model.businessobject.product.enums.ClothingSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    PantsBuilder pantsBuilder;

    @BeforeEach
    void setUp() {
        pantsBuilder = new PantsBuilder();
    }

    @Test
    void addSizeShouldSetSizeWhenValidSizeProvided() {
        ClothingSize size = ClothingSize.SMALL;
        pantsBuilder.addSize(size);
        assertEquals(size, pantsBuilder.getProduct().getSize());
    }

    @Test
    void addSizeShouldTrowExceptionWhenSizeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> pantsBuilder.addSize(null));
    }

    @Test
    void addMaterialShouldSetMaterialWhenValidMaterialProvided() {
        ClothingMaterial material = ClothingMaterial.COTTON;
        pantsBuilder.addMaterial(material);
        assertEquals(material, pantsBuilder.getProduct().getMaterial());
    }

    @Test
    void addMaterialShouldTrowExceptionWhenMaterialIsNull() {
        assertThrows(IllegalArgumentException.class, () -> pantsBuilder.addMaterial(null));
    }

    @Test
    void addColorShouldSetColorWhenValidColorProvided() {
        ClothingColor color = ClothingColor.BLACK;
        pantsBuilder.addColor(color);
        assertEquals(color, pantsBuilder.getProduct().getColor());
    }

    @Test
    void addColorShouldTrowExceptionWhenColorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> pantsBuilder.addColor(null));
    }

    @Test
    void buildShouldReturnPantsWhenAllAddMethodsAreCalled() {
        pantsBuilder.addSize(ClothingSize.SMALL);
        pantsBuilder.addMaterial(ClothingMaterial.COTTON);
        pantsBuilder.addColor(ClothingColor.BLACK);

        Product result = pantsBuilder.build();
        Pants pants = (Pants) result;

        assertEquals(ClothingSize.SMALL, pants.getSize());
        assertEquals(ClothingColor.BLACK,  pants.getColor());
        assertEquals(ClothingMaterial.COTTON, pants.getMaterial());
    }

    @Test
    void buildShouldReturnPants(){
        pantsBuilder.addSize(ClothingSize.SMALL);
        pantsBuilder.addMaterial(ClothingMaterial.COTTON);
        pantsBuilder.addColor(ClothingColor.BLACK);

        Product result = pantsBuilder.build();
        assertInstanceOf(Pants.class, result);
    }

    @Test
    void buildShouldNotReturnNull(){
        pantsBuilder.addSize(ClothingSize.SMALL);
        pantsBuilder.addMaterial(ClothingMaterial.COTTON);
        pantsBuilder.addColor(ClothingColor.BLACK);
        Product result = pantsBuilder.build();
        assertNotNull(result);
    }

    @Test
    void buildShouldTrowExceptionWhenAAddColorIsNotCalled() {

    }

    @Test
    void buildShouldTrowExceptionWhenAAddMaterialIsNotCalled() {

    }

    @Test
    void buildShouldTrowExceptionWhenAAddSizeIsNotCalled() {

    }

    @Test
    void createProduct() {
    }
}