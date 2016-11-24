package com.elong.thinking.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class StoreCADState {

    public static void main(String[] args) throws IOException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
        shapeTypes.add(Cricle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<Shape>();
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }

        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);

        System.out.println(shapes);

    }

}


abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random random = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory(){
        int xVal = random.nextInt(100);
        int yVal = random.nextInt(100);
        int dim = random.nextInt(100);
        switch (counter++ %3){
            default:
            case 0: return new Cricle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }

}

class Cricle extends Shape {
    private static int color = RED;

    public Cricle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class Square extends Shape{
    private static int color;

    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class Line extends Shape{
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream oi) throws IOException{
        color = oi.readInt();
    }

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}