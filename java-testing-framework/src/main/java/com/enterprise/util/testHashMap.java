package com.enterprise.util;

public class testHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();

        int numberOfItems = 50;
        String strings[] = new String[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            Integer integer = new Integer(i);
            strings[i] = integer.toString();
            System.out.println(hashMap.put(strings[i], integer));
        }

        for (String s : strings) {
            System.out.println(hashMap.get(s));
        }

    }
}
