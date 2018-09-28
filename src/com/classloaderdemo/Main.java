package com.classloaderdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // write your code here
//        ClassLoader classLoader = Test.class.getClassLoader();
//        System.out.println("classLoader is: "+classLoader.toString());
//        System.out.println("classLoader Parent is: "+classLoader.getParent().toString());
//        System.out.println("classLoader grand Parent is: "+classLoader.getParent().getParent().toString());

//        Class<?> aClass = classLoader.loadClass(Test.class.getName());
//        Test o = (Test) aClass.newInstance();
//        ClassLoader classLoader1 = int.class.getClassLoader();
//        System.out.println("classLoader1 is: "+classLoader1.toString());
//        FileUtils.test("D:\\lib\\Test.class");


        DiskClassLoader diskClassLoader = loadClass3();

        System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
//                Thread.currentThread().setContextClassLoader(diskClassLoader);
                loadClass4();
            }
        }).start();



    }

    private static void loadClass4() {
        System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\lib");
        Thread.currentThread().setContextClassLoader(diskClassLoader);
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

            Class<?> aClass = contextClassLoader.loadClass("com.classloaderdemo.SpeakTest");

            System.out.println("aClass "+aClass.getClassLoader().toString());

            if (aClass != null) {
                Object o = aClass.newInstance();
                Method method = aClass.getDeclaredMethod("speak", null);
                method.invoke(o, null);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void loadClass() {
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\lib");
        try {
            Class<?> aClass = diskClassLoader.loadClass("com.classloaderdemo.Test");

            if (aClass != null) {
                Object o = aClass.newInstance();
                Method method = aClass.getDeclaredMethod("say", null);
                method.invoke(o, null);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private static void loadClass2() {
        DiskClassLoader2 diskClassLoader = new DiskClassLoader2("D:\\lib");
        try {
            Class<?> aClass = diskClassLoader.loadClass("com.classloaderdemo.Test");

            if (aClass != null) {
                Object o = aClass.newInstance();
                Method method = aClass.getDeclaredMethod("say", null);
                method.invoke(o, null);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static DiskClassLoader loadClass3() {
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\lib\\test");
        try {
            Class<?> aClass = diskClassLoader.loadClass("com.classloaderdemo.SpeakTest");

            System.out.println(aClass.getClassLoader().toString());

            if (aClass != null) {
                Object o = aClass.newInstance();
                Method method = aClass.getDeclaredMethod("speak", null);
                method.invoke(o, null);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return diskClassLoader;
    }


}
