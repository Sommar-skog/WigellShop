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

public class App 
{
    public static void main( String[] args )
    {

        MainController mc = new MainController();
        mc.start();

    }
}
