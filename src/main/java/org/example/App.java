package org.example;

import org.example.controller.MainController;
import org.example.model.businessobject.CEO;
import org.example.model.businessobject.product.Pants;
import org.example.model.businessobject.product.Skirt;
import org.example.model.businessobject.product.TShirt;
import org.example.model.businessobject.product.builder.PantsBuilder;
import org.example.model.businessobject.product.builder.SkirtBuilder;
import org.example.model.businessobject.product.builder.TShirtBuilder;
import org.example.model.businessobject.product.command.*;
import org.example.model.businessobject.product.enums.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


       /* PantsBuilder pantsBuilder = new PantsBuilder();
        Pants pants = (Pants) pantsBuilder.addColor(ClothingColor.BLACK).addMaterial(ClothingMaterial.COTTON).addSize(ClothingSize.SMALL).build();
        System.out.println(pants);

        SewingProcessingPipeline pipeline = new SewingProcessingPipeline();
        pipeline.addCommand(new FitCommand(), PantsFit.SLIM);
        pipeline.addCommand(new LengthCommand(), PantsLength.LONG);
        pipeline.execute(pants);

        System.out.println();

        PantsBuilder pantsBuilder2 = new PantsBuilder();
        Pants pants2 = (Pants) pantsBuilder2.addColor(ClothingColor.GREEN).addMaterial(ClothingMaterial.DENIM).addSize(ClothingSize.LARGE).build();
        System.out.println(pants2);

        SewingProcessingPipeline pipeline2 = new SewingProcessingPipeline();
        pipeline2.addCommand(new LengthCommand(), PantsLength.REGULAR);
        pipeline2.addCommand(new FitCommand(), PantsFit.LOOSE);
        pipeline2.execute(pants2);

        System.out.println();

        SkirtBuilder skirtBuilder = new SkirtBuilder();
        Skirt skirt = (Skirt) skirtBuilder.addColor(ClothingColor.WHITE).addSize(ClothingSize.SMALL).addMaterial(ClothingMaterial.LINEN).build();
        System.out.println(skirt);

        SewingProcessingPipeline pipeline3 = new SewingProcessingPipeline();
        pipeline3.addCommand(new WaistlineCommand(), SkirtWaistline.HIGH_WAIST);
        pipeline3.addCommand(new PatternCommand(), SkirtPattern.SOLID);
        pipeline3.execute(skirt);

        System.out.println();

        TShirtBuilder tshirtBuilder = new TShirtBuilder();
        TShirt tShirt = (TShirt) tshirtBuilder.addSize(ClothingSize.LARGE).addMaterial(ClothingMaterial.DENIM).addColor(ClothingColor.BLACK).build();
        System.out.println(tShirt);

        SewingProcessingPipeline pipeline4 = new SewingProcessingPipeline();
        pipeline4.addCommand(new SleevesCommand(), TShirtSleeves.SHORT);
        pipeline4.addCommand(new NeckCommand(), TShirtNeck.CREW_NECK);
        pipeline4.execute(tShirt);*/


        MainController mc = new MainController();
        mc.start();

    }
}
