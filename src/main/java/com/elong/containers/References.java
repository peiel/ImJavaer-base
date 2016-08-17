package com.elong.containers;

import java.lang.ref.*;
import java.util.LinkedList;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class References {
    private static ReferenceQueue<VeryBig> referenceQueue = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> poll = referenceQueue.poll();
        if (poll != null) {
            System.out.println("poll.get() = " + poll.get());
        }
    }

    public static void main(String[] args) {
        int size = 10;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        LinkedList<SoftReference<VeryBig>> softReferences = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            softReferences.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i)));
            System.out.println("Just create : " + softReferences.getLast());
            checkQueue();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        LinkedList<WeakReference<VeryBig>> weakReferences = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            weakReferences.add(new WeakReference<VeryBig>(new VeryBig("weak " + i), referenceQueue));
            System.out.println("Just create : " + weakReferences.getLast());
            checkQueue();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        SoftReference<VeryBig> veryBigSoftReference = new SoftReference<VeryBig>(new VeryBig("soft"));
        WeakReference<VeryBig> veryBigWeakReference = new WeakReference<VeryBig>(new VeryBig("weak"));
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        LinkedList<PhantomReference<VeryBig>> phantomReferences = new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            phantomReferences.add(new PhantomReference<VeryBig>(new VeryBig("phantom " + i), referenceQueue));
            System.out.println("Just create: " + phantomReferences.getLast());
            checkQueue();
        }

    }


}

class VeryBig {
    private static final int SIZE = 10000;
    private long[] longs = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize :: " + ident);
    }
}
