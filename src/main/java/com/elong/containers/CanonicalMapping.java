package com.elong.containers;

import java.util.WeakHashMap;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class CanonicalMapping {

    public static void main(String[] args) {
        int size = 1000;
        if (args.length > 0) size = new Integer(args[0]);

        Key[] keys = new Key[size];

        WeakHashMap<Key, Value> weakHashMap = new WeakHashMap<Key, Value>();

        for (int i = 0; i < size; i++) {
            Key key = new Key(Integer.toString(i));
            Value value = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = key;
            }
            weakHashMap.put(key, value);

            if (i % 50 == 0) {
                System.gc();
            }
        }
    }

}

class Element {
    private String ident;

    public Element(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ident.equals(((Element) obj).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing : " + getClass().getSimpleName() + " " + ident);
    }
}


class Key extends Element {

    public Key(String ident) {
        super(ident);
    }
}

class Value extends Element {

    public Value(String ident) {
        super(ident);
    }
}