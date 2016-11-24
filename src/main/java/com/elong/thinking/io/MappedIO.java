package com.elong.thinking.io;

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
                    FileChannel fileChannel = new RandomAccessFile("one.txt", "rw").getChannel();
                    System.out.println("fileChannel.size() " + fileChannel.size());
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size()).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        if (!intBuffer.hasRemaining()) continue;
                        intBuffer.put(i);
                    }
                    fileChannel.close();
                }
            },
            new Tester("Stream read") {
                @Override
                public void test() throws IOException {
                    DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("one.txt"))));
                    for (int i = 0; i < numOfInts; i++) {
                        try {
                            in.readInt();
                        } catch (IOException e) {
                            break;
                        }
                    }
                    in.close();
                }
            },
            new Tester("Mapper Read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(new File("one.txt")).getChannel();
                    IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        if (!intBuffer.hasRemaining()) continue;
                        intBuffer.get();
                    }
                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }


}
