package com.elong.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class RecoverCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
