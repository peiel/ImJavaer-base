package com.elong.io;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 创建人 : peierlong
 * 描述 : 比较io和nio之间性能的差异
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.println(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] tests = {
            new Tester("Stream Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("one.txt"))));
                    for (int i = 0; i < numOfInts; i++) {
                        dataOutputStream.write(i);
                    }
                    dataOutputStream.close();
                }
            },
            new Tester("Mapper Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile("two.txt", "rw").getChannel();
                    System.out.println("fileChannel.size() " + fileChannel.size());
//                    MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size()).asIntBuffer();
                    int k = 0;
                    for (int i = 0; i < numOfInts; i++) {
                        if (!intBuffer.hasRemaining()) continue;
                        intBuffer.put(i);
                        k++;
                    }
                    System.out.println("i = " + k);
                    System.out.println(intBuffer.capacity());
                    System.out.println(intBuffer.limit());
                    System.out.println(intBuffer.position());
                    fileChannel.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }


}
