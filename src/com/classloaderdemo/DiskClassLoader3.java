package com.classloaderdemo;

import java.io.*;

public class DiskClassLoader3 extends ClassLoader {

    private String mClassPath;

    public DiskClassLoader3(String path){
        this.mClassPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Log(name);
        String fileName = getFileName(name);
        Log(fileName);
        File file = new File(mClassPath, fileName);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int len = 0;

            while ((len=fileInputStream.read()) != -1) {
                bos.write(len);
            }

            byte[] bytes = bos.toByteArray();

            fileInputStream.close();

            bos.close();

            return defineClass(name,bytes,0,bytes.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }



    private String getFileName(String name){
        int index = name.lastIndexOf(".");
        if (index == -1) {
            return name+".class";
        } else {
            return name.substring(index+1)+".class";
        }
    }

    private void Log(String s) {
        System.out.println("_zs_ =====>>> "+s+" <<<=====");
    }
}
