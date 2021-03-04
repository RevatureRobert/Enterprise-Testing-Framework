package com.enterprise.util;

import javafx.util.Pair;

public class testHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();

        int numberOfItems = 30;
        String strings[] = new String[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            Integer integer = new Integer(i);
            strings[i] = integer.toString();
            hashMap.put(strings[i], integer);
        }

//        for (String s : strings) {
//            System.out.println(hashMap.get(s));
//        }

//        for (String s : strings) {
//            System.out.println(hashMap.remove(s));
//        }

        for (Pair<String, Integer> pair: hashMap) {
            System.out.println(pair);
        }

    }
}
