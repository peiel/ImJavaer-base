package com.elong.typeinfo;

/**
 * 包名: com.elong.typeinfo
 * 创建人 : Elong
 * 时间: 09/03/2017 2:44 PM
 * 描述 : Examination of the way the class loader works
 */

class Candy {
    static {
        System.out.println("Load Candy");
    }
}

class Gum{
    static {
        System.out.println("Load Gum");
    }
}

class Cookie{
    static {
        System.out.println("Load Cookie");
    }
}


public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside man");
        Candy candy = new Candy();
        System.out.println("After create Candy");
        try {
            Class.forName("com.elong.typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Not find Gum");
        }
        System.out.println("After Class.forName Gum");

        new Cookie();
        System.out.println("After Cookie create");


        System.out.println("-------------");

        Class<? extends Candy> aClass = candy.getClass();

        System.out.println(aClass.getSimpleName());


    }

}

