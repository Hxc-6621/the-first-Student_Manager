package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Mysql");
        list.add("Redis");
        //迭代器遍历
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            String s=it.next();
            System.out.println(s);
        }
        try {
            for(String s:list){
                if("Spring".equals(s)){
                    list.remove(s);
                }
            }
        }catch (Exception e){
            System.out.println("捕获到异常: "+e.getClass().getSimpleName());
        }
        Iterator<String> it2=list.iterator();
        while(it2.hasNext()){
            String s=it2.next();
            if("Spring".equals(s)){
                it2.remove();
            }
        }
        System.out.println("删除后： "+list);
    }
}
