package com.solid.quick_shop.d2d;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

    private final long id;
    private final String name;
    private final HashMap<String, String> testMap;

    public ImmutableClass(long id, String name, HashMap<String, String> map) {
        this.id = id;
        this.name = name;

        HashMap<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        this.testMap = newMap;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i=10;

        ImmutableClass ce = new ImmutableClass(i,s,h1);

        // print the ce values
        System.out.println("ce id: "+ce.getId());
        System.out.println("ce name: "+ce.getName());
        System.out.println("ce testMap: "+ce.getTestMap());
        // change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");
        // print the values again
        System.out.println("ce id after local variable change: "+ce.getId());
        System.out.println("ce name after local variable change: "+ce.getName());
        System.out.println("ce testMap after local variable change: "+ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from getter methods: "+ce.getTestMap());

    }

}
