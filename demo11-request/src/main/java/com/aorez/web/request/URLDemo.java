package com.aorez.web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "郑";

        String encodeU8 = URLEncoder.encode(s, "utf-8");
        System.out.println("用utf-8编码：" + encodeU8);

        String decodeISO = URLDecoder.decode(encodeU8, "ISO-8859-1");
        System.out.println("用ISO...解码：" + decodeISO);

        String decodeU8 = URLDecoder.decode(encodeU8, "utf-8");
        System.out.println("用utf-8解码：" + decodeU8);

        System.out.println("");
        String encodeISO = URLEncoder.encode(decodeISO, "ISO-8859-1");
        String decode = URLDecoder.decode(encodeISO, "utf-8");
        System.out.println("先用ISO...编码再用utf-8解码：" + decode);

        System.out.println("");
        byte[] bytes = decodeISO.getBytes("iso-8859-1");
        for (byte b: bytes) {
            System.out.print(b + " ");
        }
        String ss = new String(bytes, "utf-8");
        System.out.println(ss);
    }
}
