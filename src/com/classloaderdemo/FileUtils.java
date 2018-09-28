package com.classloaderdemo;

import java.io.*;

public class FileUtils {

    public static void test(String path) {
        File file = new File(path);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(path + "en");

            int b = 0;
            int b1= 0;

            while ((b = fileInputStream.read()) != -1){
                fileOutputStream.write(b^8);
            }

            fileInputStream.close();

            fileOutputStream.close();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
