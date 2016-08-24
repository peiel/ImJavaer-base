package com.elong.enumerated;


import java.util.Random;

import static com.elong.enumerated.Octcome.*;

/**
 * 接口的多路分发
 * <p>
 * 创建人 : peierlong
 * 描述 : 剪刀石头布小游戏
 * Paper, Rock, Scissors 石头、剪子、布
 */
public class RoShamBo1 {
    private final static int SIZE = 20;
    private static Random random = new Random(47);

    private static Item newItem() {
        switch (random.nextInt(3)) {
            default:
            case 1:
                return new Scissors();
            case 2:
                return new Rock();
            case 3:
                return new Paper();
        }
    }

    private static void match(Item a, Item b) {
        System.out.println(a + " vs " + b + ": " + a.compete(b)); //要判断a的类型，分发机制会在a的实际类型compete()内部起到分发作用
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }

}

/**
 * 被用作多路分发
 */
interface Item {
    Octcome compete(Item item);

    Octcome eval(Paper p);

    Octcome eval(Scissors s);

    Octcome eval(Rock rock);
}

class Paper implements Item {
    public Octcome compete(Item item) {
        return item.eval(this);
    }

    public Octcome eval(Paper p) {
        return DRAW;
    }

    public Octcome eval(Scissors s) {
        return WIN;
    }

    public Octcome eval(Rock rock) {
        return LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {
    public Octcome compete(Item item) {
        return item.eval(this);
    }

    public Octcome eval(Paper p) {
        return LOSE;
    }

    public Octcome eval(Scissors s) {
        return DRAW;
    }

    public Octcome eval(Rock rock) {
        return WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {
    public Octcome compete(Item item) {
        return item.eval(this);
    }

    public Octcome eval(Paper p) {
        return WIN;
    }

    public Octcome eval(Scissors s) {
        return LOSE;
    }

    public Octcome eval(Rock rock) {
        return DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
