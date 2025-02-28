package org.example;

import org.example.model.businessobject.CEO;
import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.builder.PantsBuilder;
import org.example.model.businessobject.product.enums.ClothingColor;
import org.example.model.businessobject.product.enums.ClothingMaterial;
import org.example.model.businessobject.product.enums.ClothingSize;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        PantsBuilder pantsBuilder = new PantsBuilder();
        Pants pants = (Pants) pantsBuilder.addColor(ClothingColor.BLACK).addMaterial(ClothingMaterial.COTTON).addSize(ClothingSize.SMALL).build();
        System.out.println(pants);

        PantsBuilder pantsBuilder2 = new PantsBuilder();
        Pants pants2 = (Pants) pantsBuilder2.addColor(ClothingColor.GREEN).addMaterial(ClothingMaterial.DENIM).addSize(ClothingSize.LARGE).build();
        System.out.println(pants2);

    }
}
