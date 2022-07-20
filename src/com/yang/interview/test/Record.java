package com.yang.test;

import java.util.*;

public class Record {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (!sc.hasNext("#")){
            String filePath = sc.next();
            int line = sc.nextInt();
            int id = filePath.lastIndexOf("\\");
            String filename = id == 0 ? filePath : filePath.substring(id + 1);
            String key = filename + " " + line;
            if(map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }else{
                map.put(key,1);
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue() == 0 ? (o1.getValue() - o2.getValue()) : o2.getValue()-o1.getValue();
            }
        });
        int m = 0;
        for (Map.Entry<String,Integer> mapping : list){
            if(m < 8){
                String[] key = mapping.getKey().split(" ");
                String filename = key[0].length() > 16 ? key[0].substring(key[0].length() - 16) : key[0];
                String line = key[1];
                int count = mapping.getValue();
                System.out.println(filename+" "+line+" "+count);
            }
            m++;
        }
    }
}
