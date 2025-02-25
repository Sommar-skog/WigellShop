package org.example.view;

import java.util.Scanner;

public class View {


    private Scanner scanner = new Scanner(System.in);

    public  void start(){
        System.out.println("            VÄLKOMMEN TILL WIGELL SHOP");
        printLogInMeny();
    }

    private void printLogInMeny(){
        System.out.println();
        System.out.println("            LOGGA IN");
        System.out.println();
        System.out.println("            1. Återkommande kund" +
                "           2. Ny kund" +
                "           3. Avsluta");
        System.out.println();
        System.out.print("            Ange siffran för ditt val: ");

    }

    private void printPlaceOrder(){
        System.out.println();
        System.out.println("            ORDER");
        System.out.println();
        System.out.println("            1. Lägg order" +
                "           2. Logga ut");
        System.out.println();
        System.out.print("            Ange siffran val: ");

    }

    private void printItems(){
        System.out.println();
        System.out.println("            VAROR");
        System.out.println();
        System.out.println("            1. Byxor" +
                "           2. T-shirt" +
                "           3. Kjol");
    }

    private void printItemOptions(){
        System.out.println();
        //TODO gemensamma alternativ: size, color, material
    }

    private void printPantsOptions(){
        //TODO alternativ för fit och length

    }

    private void printTShirtOptions(){
        System.out.println();
        //TODO alternativ för sleeves och neck
    }

    private void printSkirtOptions(){
        System.out.println();
        //TODO alternativ för waistline och pattern
    }
}
