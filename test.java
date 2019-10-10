package com.cmos.mmp.mana.quartz;

import com.cmos.mmp.beans.test.Test;
/*
数据分类
*/
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String args[]){
        File file=new File("D:\\t.txt");
        BufferedReader reader=null;
        String temp=null;
        int line=1;
       Map<String,String> list= addArea();
        try{
            reader=new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                String s[]=temp.split("\\|");;
                System.out.println(list.get(s[0].substring(0,7)));
                     if(list.get(s[0].substring(0,7))!=null) {
                         BufferedOutputStream bos = new BufferedOutputStream(
                                 new FileOutputStream(new File("d://files/" + list.get(s[0].substring(0, 7) )+ "---" + s[2] +"---"+s[3]+"---" + s[1] +".txt"), true));
                         byte[] buff = (s[0] + "\r\n").getBytes();
                         bos.write(buff, 0, buff.length);
                         bos.flush();
                         bos.close();
                         System.out.println(s[2] + "文件写入成功");
                         System.out.println("line" + line + ":----" + temp);
                     }
                line++;
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static Map<String,String> addArea(){

        File file=new File("D:\\valentinesday_goal_user.txt");
        BufferedReader reader=null;
        String temp=null;
        int line=1;
      Map<String,String> list=new HashMap<>();
        try{
            reader=new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                String s[]=temp.split("\\|");
              list.put(s[1],s[2]);
                line++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
