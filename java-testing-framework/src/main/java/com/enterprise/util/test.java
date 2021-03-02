package com.enterprise.util;

public class test {
    public static void main(String args[]){
        HashMap<String, String> m = new HashMap<>(1);
        String mat = "mat";
        String pat = "pat";
        String jet = "jet";
        m.put(mat, jet);
        m.put(pat, pat);
        m.put(jet, mat);
        System.out.println(m.size);
        System.out.println(m.get(mat));
        m.remove(mat);
        m.remove(mat);
        System.out.println(m.size);
        System.out.println(m.get(mat));
    }
}
