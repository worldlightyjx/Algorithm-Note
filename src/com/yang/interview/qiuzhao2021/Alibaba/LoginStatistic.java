package src.com.yang.interview.qiuzhao2021.Alibaba;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class LoginStatistic {

    public static void main(String[] args) {
        //使用TreeMap保证答案的key stirng 按照字典序排序
        TreeMap<String,Integer> map = new TreeMap<>();
        //打开文件并读取内容
        File file = new File("biz.log");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str=bufferedReader.readLine())!=null){
                //统计Login的User，并添加进TreeMap
                if(str.contains("Login")){
                    int index = str.indexOf("Login");
                    String user = str.substring(0,index).trim();
                    if(map.containsKey(user)){
                        map.put(user,map.get(user)+1);
                    }else{
                        map.put(user,1);
                    }
                }

            }
            //输出答案
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
