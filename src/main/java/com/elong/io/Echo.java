package com.elong.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 创建人 : peierlong
 * 描述 : 包装System.in
 */
public class Echo {
    public static void main(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0){
            System.out.println(s);
        }
    }
}
