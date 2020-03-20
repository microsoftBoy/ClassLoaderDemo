package com.classloaderdemo;

import java.io.File;
import java.util.StringTokenizer;

public class Test6 {
    public static void main(String[] args){

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        String property = System.getProperty("java.class.path");
        System.out.println();
        getExtDirs();
        getClassPath(property);
        //测试冲突111

    }

    private static File[] getExtDirs() {
//        String var0 = System.getProperty("java.ext.dirs");
        String var0 = System.getProperty("java.class.path");
        System.out.println(var0);
        System.out.println("File.pathSeparator = "+File.pathSeparator);
        File[] var1;
        if (var0 != null) {
            StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
            System.out.println(var2.toString());
            int var3 = var2.countTokens();
            System.out.println(var3);
            var1 = new File[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
                String s = var2.nextToken();
                System.out.println("var2.nextToken() = "+s);
                var1[var4] = new File(s);
            }
        } else {
            var1 = new File[0];
        }

        return var1;
    }

    private static File[] getClassPath(String var0) {
        File[] var1;
        if (var0 != null) {
            int var2 = 0;
            int var3 = 1;
            boolean var4 = false;

            int var5;
            int var7;
            for(var5 = 0; (var7 = var0.indexOf(File.pathSeparator, var5)) != -1; var5 = var7 + 1) {
                ++var3;
            }

            var1 = new File[var3];
            var4 = false;

            for(var5 = 0; (var7 = var0.indexOf(File.pathSeparator, var5)) != -1; var5 = var7 + 1) {
                int diff = var7 - var5;
                System.out.println("var7 - var5 = "+diff);
                if (var7 - var5 > 0) {
                    var1[var2++] = new File(var0.substring(var5, var7));
                } else {
                    var1[var2++] = new File(".");
                }
            }

            if (var5 < var0.length()) {
                var1[var2++] = new File(var0.substring(var5));
            } else {
                var1[var2++] = new File(".");
            }
            System.out.println("var2 = "+var2);
            System.out.println("var3 = "+var3);
            if (var2 != var3) {
                File[] var6 = new File[var2];
                System.arraycopy(var1, 0, var6, 0, var2);
                var1 = var6;
            }
        } else {
            var1 = new File[0];
        }

        return var1;
    }
}
