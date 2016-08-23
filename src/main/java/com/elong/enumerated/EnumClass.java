package com.elong.enumerated;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery shrubbery : Shrubbery.values()) {
            System.out.println(shrubbery + ": ordinal() :: " + shrubbery.ordinal());
            System.out.print(shrubbery.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(shrubbery.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(shrubbery == Shrubbery.CRAWLING);
            System.out.println(shrubbery.getDeclaringClass());
            System.out.println(shrubbery.name());
            System.out.println("-------------又一条可爱的分割线---------------");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }


}

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

