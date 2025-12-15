package com.solid.quick_shop.jvm;

// File: DemoJVM.java
public class DemoJVM {
    // static initializer -> demonstrates class loading & initialization
    static {
        System.out.println("[DemoJVM] static initializer: class loaded by " +
                DemoJVM.class.getClassLoader());
    }

    // a nested class we will load lazily via reflection to show ClassLoader + init
    public static class Lazy {
        static {
            System.out.println("[Lazy] static initializer: Lazy class initialized by " +
                    Lazy.class.getClassLoader());
        }

        public void sayHello() {
            System.out.println("[Lazy] Hello from Lazy.sayHello()");
        }
    }

    // a worker thread to show stacks & thread creation
    static class Worker extends Thread {
        public void run() {
            System.out.println("[Worker] thread started; name=" + getName());
            // simple loop to keep thread alive so you can jstack/jcmd it
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("[Worker] tick " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("[Worker] thread finishing");
        }
    }

    // method to allocate many objects to demonstrate heap usage / GC activity
    static void allocateHeap(int mb) {
        System.out.println("[allocateHeap] Allocating ~" + mb + "MB of objects");
        final int bytes = mb * 1024 * 1024;
        // create one big byte[] per iteration and drop reference quickly to let GC collect
        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[bytes / 5]; // spread across 5 arrays
            // touch the array to ensure allocation
            b[0] = 1;
            b[b.length - 1] = 1;
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        }
        System.out.println("[allocateHeap] done creating objects (eligible for GC)");
    }

    // a method to demonstrate reflection & bytecode execution paths
    static void reflectivelyLoadAndInvoke() throws Exception {
        System.out.println("[reflectivelyLoadAndInvoke] Using Class.forName to load Lazy");
        // load the nested class by full name
        Class<?> lazyClass = Class.forName("DemoJVM$Lazy");
        Object lazyInstance = lazyClass.getDeclaredConstructor().newInstance();
        // call sayHello via reflection
        lazyClass.getMethod("sayHello").invoke(lazyInstance);
    }

    // NOTE: demonstrating JNI/native-call would normally require a C library + System.loadLibrary,
    // so we only print how it would look — do NOT attempt to run System.loadLibrary unless you have the native lib.
    static void showJNISimulation() {
        System.out.println("[showJNISimulation] (simulated) Native methods would be loaded with System.loadLibrary()");
        System.out.println("[showJNISimulation] Example: System.loadLibrary(\"my_native_lib\"); then native methods get executed via JNI");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("[main] JVM name: " + System.getProperty("java.vm.name"));
        System.out.println("[main] java.home (JRE): " + System.getProperty("java.home"));
        System.out.println("[main] java.version: " + System.getProperty("java.version"));

        // Start a worker thread
        Worker w = new Worker();
        w.setName("demo-worker");
        w.start();

        // Show reflection & class loading on demand
        reflectivelyLoadAndInvoke();

        // Allocate heap to observe GC (use with GC logging)
        allocateHeap(50); // ~50MB allocation churn; reduce if low-memory container

        // Show simulated JNI
        showJNISimulation();

        // print current thread count so you can correlate with jstack/jcmd
        System.out.println("[main] Active thread count: " + Thread.activeCount());

        // join worker to finish cleanly
        w.join();
        System.out.println("[main] Exiting");
    }
}

