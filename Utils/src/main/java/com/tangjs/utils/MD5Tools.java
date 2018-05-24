package com.tangjs.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tools {
	
	 public static String bytesToHexString(byte[] src) {
         StringBuilder stringBuilder = new StringBuilder("");
         if (src == null || src.length <= 0) {
             return null;
         }
         for (int i = 0; i < src.length; i++) {
             int v = src[i] & 0xFF;
             String hv = Integer.toHexString(v);
             if (hv.length() < 2) {
                 stringBuilder.append(0);
             }
             stringBuilder.append(hv);
         }
         return stringBuilder.toString();
     }

     /**
      * 解析
      * @param hexString
      * @return
      */
     public static byte[] hexStringToBytes(String hexString) {
         if (hexString == null || hexString.equals("")) {
             return null;
         }
         hexString = hexString.toUpperCase();
         int length = hexString.length() / 2;
         char[] hexChars = hexString.toCharArray();
         byte[] d = new byte[length];
         for (int i = 0; i < length; i++) {
             int pos = i * 2;
             d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
         }
         return d;
     }

     /**
      * 将指定byte数组以16进制的形式
      * @param b
      */
     public static void printHexString(byte[] b) {
         for (int i = 0; i < b.length; i++) {
             String hex = Integer.toHexString(b[i] & 0xFF);
             if (hex.length() == 1) {
                 hex = '0' + hex;
             }
             System.out.print(hex.toUpperCase());
         }

     }

     /**
      * Convert char to byte
      * @param c char
      * @return byte
      */
     private static byte charToByte(char c) {
         return (byte) "0123456789abcdef".indexOf(c);
     }

     /**
      * 加密
      * @param str
      * @return
      */
     public static String encode(String str) {
         String strDigest = "";
         try {
             // 此 MessageDigest 类为应用程序提供信息摘要算法的功能，必须用try,catch捕获
             MessageDigest md5 = MessageDigest.getInstance("MD5");

             byte[] data;
             data = md5.digest(str.getBytes("utf-8"));// 转换为MD5码
             strDigest = bytesToHexString(data);
         } catch (Exception ex) {
             throw new RuntimeException(ex);
         }
         return strDigest;
     }
     
     /**
      * MD5加密
      * @param plainText 需要加密的文件
      * @return  32位加密密文
      */
     public static String md5encode(String plainText) {
 		String str = "";
 		MessageDigest md;
 		try {
 			md = MessageDigest.getInstance("MD5");
 			md.update(plainText.getBytes());
 			byte b[] = md.digest();
 			int i;
 			StringBuffer buf = new StringBuffer("");
 			for (int offset = 0; offset < b.length; offset++) {
 				i = b[offset];
 				if (i < 0)
 					i += 256;
 				if (i < 16)
 					buf.append("0");
 				buf.append(Integer.toHexString(i));
 			}
 			str = buf.toString();
 		} catch (NoSuchAlgorithmException e) {
 			e.printStackTrace();
 		}
 		return str;
 	}
}
