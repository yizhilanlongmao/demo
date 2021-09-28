package com.ohs.zxf;
/*
1 什么是字符流？   字符（Character）
    每次读取(写出)两个字节，有中文时，使用该流就可以正确传输显示中文，读写的单位是char，在Reader/Writer中单向流动。
    Java中的字符流处理的最基本的单元是Unicode码元（大小统一为2字节），它通常用来处理文本数据。
    字符流只能处理纯文本文件

    1 char = 2 byte = 16 bit (Java默认UTF-16编码)

2 字符流具体使用
        输出流     Writer
        输入流     Reader

 */

import java.io.*;

public class WriteDemo {
    public static void main(String[] args) throws IOException{
//        writerDemo();
//        readDemo();
        xunHun();
    }

    // 字符输出流
    static void writerDemo()throws IOException {
        File file = new File("/Users/zhouxufeng/Desktop" + File.separator + "demo.txt");

        // 输出流  新增参数true，提供追加内容的数据管道。
        Writer writer = new FileWriter(file,true);

        writer.write("新增内容 【我很喜欢龙猫】");
        writer.close();
    }

    // 字符输入流  通过返回值获得
    static void readDemo()throws IOException{
        File file = new File("/Users/zhouxufeng/Desktop" + File.separator + "demo.txt");

        Reader reader = new FileReader(file);

        // 定义char数组作为接受数据的容器
        char [] chars = new char[100];

        int len = reader.read(chars);
        reader.close();

        System.out.println(new String(chars,0,len));
    }

    // 循环获得
    static void xunHun() throws IOException{
        File file = new File("/Users/zhouxufeng/Desktop" + File.separator + "demo.txt");

        Reader reader = new FileReader(file);

        char [] chars = new char[100];

        int len = 0;

        // 为什么不定义这个count，读取出来的内容出错。
        int count;

        while ((count = reader.read())!=-1){
            chars[len] = (char) count;
            len++;
        }

        reader.close();
        System.out.println(new String(chars,0,len));
    }

}
