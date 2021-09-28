package com.ohs.zxf;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.spec.EncodedKeySpec;

/*
    java中字节流和字符流之前有接触过，但是一直没有深入的学习和了解。
    今天带着几个问题，简单的使用字节流的基本操作。

1 什么是字节流？
    字节流是由字节组成的,字符流是由字符组成的.Java里字符由两个字节组成.字节流是最基本的
    所有的InputStream和OutputStream的子类都是，主要用在处理二进制数据，它是按字节来处理的但实际中很多的数据是文本，
    又提出了字符流的概念，它是按虚拟机的encode来处理，
    也就是要进行字符集的转化。在从字节流转化为字符流时，实际上就是byte[]转化为String时，
    public String(byte bytes[]， String charsetName)有一个关键的参数字符集编码，通常我们都省略了，那系统就用操作系统默认的long

总结
    ·字节流按照字节来处理
    ·字符流处理文本
    ·字节输出流OutputStream  数据从程序流到外面（本机电脑等） 在程序中写入文本到本机电脑
    ·字节输入流InputStream   数据从外部流入写的程序（使用程序读取本机的文件内容）

2 什么是字符流？
    Java中的字符流处理的最基本的单元是Unicode码元（大小2字节），它通常用来处理文本数据。所谓Unicode码元，也就是一个Unicode代码单元，
    范围是0x0000~0xFFFF。在以上范围内的每个数字都与一个字符相对应，
    Java中的String类型默认就把字符以Unicode规则编码而后存储在内存中。然而与存储在内存中不同，存储在磁盘上的数据通常有着各种各样的编码方式。
    使用不同的编码方式，相同的字符会有不同的二进制表示。实际上字符流是这样工作的：

    输出字符流：把要写入文件的字符序列（实际上是Unicode码元序列）转为指定编码方式下的字节序列，然后再写入到文件中；
    输入字符流：把要读取的字节序列按指定编码方式解码为相应字符序列（实际上是Unicode码元序列从）从而可以存在内存中。

3 什么是字节（byte 简称B）
    是计算机信息技术用于计量存储容量的一种计量单位，也表示一些计算机编程语言中的数据类型和语言字符。
    是计算机中存储数据的一种计量单位。
    是编程语言中的数据类型和语言字符。
    英文1个字节，中文2个字节

4 什么是位（比特 bit）
    电脑的各种存储器的最小的存储单位是比特，也就是位（bit，简称b），它表示一个二进制位。
    比位大的单位是字节（byte，简称B），它等于8个二进制位。
    因为在存储器中含有大量的存储单元，每个存储单元可以存放8个二进制位，所以存储器的容量是以字节为基本单位的。
    电脑有32位和64位。

5 字节（byte）和位（bit）之间的关系？
    ·字节是byte简称B  位是bit简称b。
    ·1B等于8b，一个字节等于八个比特，等于8个二进制位。
    ·bit是电脑存储器中最小的存储单位。他表示一个二进制位。
    ·电脑中存在多个存储单元，一个单元可以存放8个二进制位，就是可以存放一个byte。所以存储器的容量是以字节为基本单位的。
 */
public class OutputDemo {
    public static void main(String[] args)  throws IOException {
//        readFu();
        System.out.println("哈哈".getBytes(StandardCharsets.UTF_8));
    }

    // 定义一个数组，再循环中一个个的读取文本内容，并存到数组中。
    static void readOne()throws IOException{
        File file = new File("/Users/zhouxufeng/Desktop" + File.separator + "demo.txt");

        InputStream inputStream = new FileInputStream(file);

        //这个数组的长度，就是文本内容的长度。
        byte [] bytes = new byte[(int)file.length()];

        //依次读取，存入数组
        for (int i = 0; i < file.length(); i++) {
            bytes[i] = (byte) inputStream.read();
        }
        inputStream.close();

        System.out.println(new String(bytes));

    }

    // read() 返回-1 表示文件读完。 通过判读是否读到文件末尾的方式来读取文件。
    static void readFu()throws IOException{
        File file = new File("/Users/zhouxufeng/Desktop" + File.separator + "demo.txt");

        InputStream inputStream = new FileInputStream(file);

        // 首先需要一个容器来装
        byte [] bytes = new byte[1024];

        // 用于记录读取的数据
        int len = 0;

        // 不定义这个int变量，输出的内容是乱码
        int temp ;

        //判读
        while ((temp = inputStream.read())!=-1){
            bytes[len] = (byte) temp;
            len++;
        }

        // 文件读到末尾，返回值-1。 未用定义的temp去替代这里的返回值，输出的内容有乱码。
//        while (inputStream.read()!=-1){
//            bytes[len] = (byte)inputStream.read();
//            len++;
//        }

        inputStream.close();

        System.out.println(new String(bytes,0,len,"UTF-8"));
//        System.out.println(new String(bytes,0,len));
    }
}
